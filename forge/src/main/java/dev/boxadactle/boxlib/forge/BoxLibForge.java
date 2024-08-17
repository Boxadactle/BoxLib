package dev.boxadactle.boxlib.forge;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.command.BCommandImpl;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.keybind.KeybindingImpl;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import dev.boxadactle.boxlib.util.MouseUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(ModConstants.MOD_ID)
public class BoxLibForge {

    public BoxLibForge() {
        BoxLib.init();
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