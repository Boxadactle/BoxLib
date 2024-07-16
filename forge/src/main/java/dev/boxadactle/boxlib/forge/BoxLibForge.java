package dev.boxadactle.boxlib.forge;

import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.keybind.KeybindingImpl;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import dev.boxadactle.boxlib.util.MouseUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(ModConstants.MOD_ID)
public class BoxLibForge {

    public BoxLibForge() {
        BoxLib.init();
    }

    @Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

//        @SuppressWarnings("unchecked")
//        @SubscribeEvent
//        public static void registerCommands(RegisterCommandsEvent event) {
//            BCommandImpl.register((CommandDispatcher<BCommandSourceStack>) (CommandDispatcher<?>) event.getDispatcher());
//        }

        @SubscribeEvent
        public static void mouseDown(GuiScreenEvent.MouseClickedEvent.Pre e) {
            MouseUtils.setMouseDown(e.getButton());
        }

        @SubscribeEvent
        public static void mouseUp(GuiScreenEvent.MouseReleasedEvent.Pre ignored) {
            MouseUtils.setMouseUp();
        }

        @SubscribeEvent
        public static void tick(TickEvent.ClientTickEvent ignored) {
            Scheduling.tick();
        }

    }

    @Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModForgeEvents {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            KeybindingImpl.register(ClientRegistry::registerKeyBinding);
        }
    }

}
