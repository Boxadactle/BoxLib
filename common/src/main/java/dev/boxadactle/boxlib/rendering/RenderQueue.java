package dev.boxadactle.boxlib.rendering;

import dev.boxadactle.boxlib.function.Provider;
import oshi.util.tuples.Pair;

public class RenderQueue {

    public static void addRenderer(Renderer3D renderer) {
        RenderImpl.renderers.add(renderer);
    }

    public static void addRenderer(Provider<Pair<Renderer3D, Boolean>> provider) {
        RenderImpl.renderProviders.add(provider);
    }

    public static void removeRenderer(Renderer3D renderer) {
        RenderImpl.renderers.remove(renderer);
    }

}
