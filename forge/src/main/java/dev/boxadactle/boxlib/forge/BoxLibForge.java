package dev.boxadactle.boxlib.forge;

import dev.boxadactle.boxlib.BoxLib;
import dev.boxadactle.boxlib.example.ExampleConfigScreen;
import dev.boxadactle.boxlib.forge.command.BCommandManager;
import dev.boxadactle.boxlib.scheduler.Scheduling;
import dev.boxadactle.boxlib.util.MouseUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(BoxLib.MOD_ID)
public class BoxLibForge {

    public BoxLibForge() {
        BoxLib.init();

        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((minecraft, screen) -> new ExampleConfigScreen(screen))
        );
    }

    @Mod.EventBusSubscriber(modid = BoxLib.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void registerCommands(RegisterClientCommandsEvent e) {
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

        @SubscribeEvent
        public static void tick(TickEvent.ClientTickEvent e) {
            Scheduling.tick();
        }

    }
}