package dev.boxadactle.boxlib;

import dev.boxadactle.boxlib.command.BCommandManager;
import dev.boxadactle.boxlib.gui.BConfigScreen;
import dev.boxadactle.boxlib.gui.widget.BLeftLabel;
import dev.boxadactle.boxlib.gui.widget.BStringField;
import dev.boxadactle.boxlib.gui.widget.BToggleButton;
import dev.boxadactle.boxlib.gui.widget.BWidgetContainer;
import dev.boxadactle.boxlib.util.GuiUtils;
import dev.boxadactle.boxlib.util.ModLogger;
import dev.boxadactle.boxlib.util.RenderUtils;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.util.Arrays;

public class BoxLib implements ClientModInitializer {

    public static ModLogger LOGGER;

    public static final boolean DEBUG_MODE = false;

    @Override
    public void onInitializeClient() {
        LOGGER = new ModLogger("BoxLib");

        ModConstantsProvider.registerProvider(ModConstants.class);

        GuiUtils.init();
        RenderUtils.init();

        LOGGER.info("Initialized " + ModConstants.getProvider("boxlib").getString());

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> BCommandManager.registerToGame(dispatcher));
    }

    public static class DebugConfigScreen extends BConfigScreen {

        public DebugConfigScreen(Screen parent) {
            super(parent);
        }

        @Override
        protected Text getName() {
            return Text.literal("wow amazing screen");
        }

        @Override
        protected void initFooter(int startX, int startY) {
            addDrawableChild(createCancelButton(startX, startY, parent));
        }

        @Override
        protected void initConfigButtons() {
            this.addConfigOption(new BLeftLabel(Text.literal("wow so fun")));

            this.addConfigOption(new BStringField("this just needs to be a long thing", BoxLib.LOGGER::info));

            this.addConfigOption(new BWidgetContainer(
                    new BStringField("this just needs to be a long thing", BoxLib.LOGGER::info),
                    new BStringField("this just needs to be a long thing", BoxLib.LOGGER::info)
            ));

            this.addConfigOption(new BToggleButton<>("Value: %s", ExampleEnum.BIG, Arrays.stream(ExampleEnum.values()).toList(), BoxLib.LOGGER::info) {
                @Override
                public ExampleEnum to(Text input) {
                    switch (input.getString()) {
                        case "BIG": return ExampleEnum.BIG;
                        case "SMALL": return ExampleEnum.SMALL;
                        case "TINY": return ExampleEnum.TINY;
                        case "NORMAL": return ExampleEnum.NORMAL;
                        case "GIGANTIC": return ExampleEnum.GIGANTIC;
                    }
                    return null;
                }

                @Override
                public Text from(ExampleEnum input) {
                    switch (input) {
                        case BIG: return Text.literal("BIG");
                        case SMALL: return Text.literal("SMALL");
                        case TINY: return Text.literal("TINY");
                        case NORMAL: return Text.literal("NORMAL");
                        case GIGANTIC: return Text.literal("GIGANTIC");
                    }
                    return null;
                }
            });
        }

        private enum ExampleEnum {
            BIG,
            SMALL,
            TINY,
            NORMAL,
            GIGANTIC
        }
    }

}
