package dev.boxadactle.boxlib.forge;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.command.BCommandImpl;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.keybind.KeybindingImpl;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import dev.boxadactle.boxlib.test.config.ExampleConfigScreen;
import dev.boxadactle.boxlib.util.MouseUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(ModConstants.MOD_ID)
public class BoxLibForge {

    public BoxLibForge() {
        ModConstants.IS_TEST_ENVIRONMENT = !FMLEnvironment.production;
        BoxLib.init();

        if (ModConstants.IS_TEST_ENVIRONMENT) {
            ModList.get().getModContainerById(ModConstants.MOD_ID).ifPresent(modContainer -> modContainer.registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                    new ConfigScreenHandler.ConfigScreenFactory(((minecraft, screen) -> new ExampleConfigScreen(screen)))
            ));
        }

        Minecraft.getInstance().extraTelemetryAvailable();
    }

    @Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SuppressWarnings("unchecked")
        @SubscribeEvent
        public static void registerCommands(RegisterClientCommandsEvent event) {
            BCommandImpl.register((CommandDispatcher<BCommandSourceStack>) (CommandDispatcher<?>) event.getDispatcher());
        }

        @SubscribeEvent
        public static void mouseDown(ScreenEvent.MouseButtonPressed.Pre e) {
            MouseUtils.setMouseDown(e.getButton());
        }

        @SubscribeEvent
        public static void mouseUp(ScreenEvent.MouseButtonReleased.Pre ignored) {
            MouseUtils.setMouseUp();
        }

        @SubscribeEvent
        public static void tick(TickEvent.ClientTickEvent.Post ignored) {
            Scheduling.tick();
        }

    }

    @Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModForgeEvents {
        @SubscribeEvent
        public static void registerKeybinds(RegisterKeyMappingsEvent e) {
            KeybindingImpl.register(e::register);
        }
    }

}