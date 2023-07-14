package dev.boxadactle.boxlib;

import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.ModLogger;
import dev.boxadactle.boxlib.util.MouseUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("boxlib")
public class BoxLib {

    public static ModLogger LOGGER;

    public BoxLib() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::initializeMod);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void initializeMod(FMLCommonSetupEvent event) {
        LOGGER = new ModLogger("BoxLib");

        ModConstantsProvider.registerProvider(ModConstants.class);

        ModConstants.init();
        GuiUtils.init();
        RenderUtils.init();

        LOGGER.info("Initialized %s", ModConstantsProvider.getProvider("boxlib").getString());
    }

    @Mod.EventBusSubscriber(modid = "boxlib", value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void registerClientCommands(RegisterClientCommandsEvent e) {
            BCommandManager.registerToGame(e.getDispatcher());
        }

        @SubscribeEvent
        public static void mouseDown(ScreenEvent.MouseButtonPressed e) {
            MouseUtils.setMouseDown(e.getButton());
        }

        @SubscribeEvent
        public static void mouseUp(ScreenEvent.MouseButtonReleased e) {
            MouseUtils.setMouseUp();
        }
    }
}
