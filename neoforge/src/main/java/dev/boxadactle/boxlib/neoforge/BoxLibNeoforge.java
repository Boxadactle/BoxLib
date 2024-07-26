package dev.boxadactle.boxlib.neoforge;

import com.mojang.brigadier.CommandDispatcher;
import dev.boxadactle.boxlib.command.BCommandImpl;
import dev.boxadactle.boxlib.command.BCommandSourceStack;
import dev.boxadactle.boxlib.core.BoxLib;
import dev.boxadactle.boxlib.core.ModConstants;
import dev.boxadactle.boxlib.keybind.KeybindingImpl;
import dev.boxadactle.boxlib.scheduling.Scheduling;
import dev.boxadactle.boxlib.util.MouseUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterClientCommandsEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.event.TickEvent;

@Mod(ModConstants.MOD_ID)
public class BoxLibNeoforge {

    public BoxLibNeoforge() {
        BoxLib.init();
    }

    @Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, value = Dist.CLIENT)
    public static class ClientNeoforgeEvents {

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
        public static void tick(TickEvent.ClientTickEvent ignored) {
            Scheduling.tick();
        }

    }

    @Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModNeoforgeEvents {
        @SubscribeEvent
        public static void registerKeybinds(RegisterKeyMappingsEvent e) {
            KeybindingImpl.register(e::register);
        }
    }

}
