package dev.boxadactle.boxlib;

import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.config.BConfigClass;
import dev.boxadactle.boxlib.config.BConfigHandler;
import dev.boxadactle.boxlib.example.ExampleConfigClass;
import dev.boxadactle.boxlib.example.ExampleConfigScreen;
import dev.boxadactle.boxlib.scheduler.ScheduleAction;
import dev.boxadactle.boxlib.scheduler.Scheduling;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.ModLogger;
import dev.boxadactle.boxlib.util.MouseUtils;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.RegisterClientCommandsEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("boxlib")
public class BoxLib {

    public static final ModLogger LOGGER = new ModLogger(ModConstants.MOD_NAME);

    public static BConfigClass<ExampleConfigClass> CONFIG;

    public BoxLib() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::initializeMod);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void initializeMod(FMLCommonSetupEvent event) {
        GuiUtils.init();
        RenderUtils.init();

        // make sure to register your config like this
        CONFIG = BConfigHandler.registerConfig(ExampleConfigClass.class);

        // we can register it to forge like this
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
            new ConfigScreenHandler.ConfigScreenFactory((minecraft, screen) -> new ExampleConfigScreen(screen))
        );

        LOGGER.info("Initialized %s", ModConstants.MOD_NAME + " v" + ModConstants.VERSION);
    }

    public static <T> T initializeClass(Class<T> tClass) {
        T a;
        try {
            a = tClass.getConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        return a;
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

        @SubscribeEvent
        public static void tick(TickEvent.ClientTickEvent e) {
            Scheduling.tick();
        }
    }
}
