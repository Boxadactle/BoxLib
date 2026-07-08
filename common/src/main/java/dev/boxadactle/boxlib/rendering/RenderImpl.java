package dev.boxadactle.boxlib.rendering;

import dev.boxadactle.boxlib.function.Provider;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.util.debug.DebugValueAccess;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RenderImpl {

    static List<Renderer3D<?>> renderers = new ArrayList<>();
    static List<Provider<Pair<Renderer3D<?>, Boolean>>> renderProviders = new ArrayList<>();

    public static void renderAll(double var1, double var3, double var5, DebugValueAccess var7, Frustum var8, float var9) {
        Iterator<Renderer3D<?>> iterator = renderers.iterator();
        while (iterator.hasNext()) {
            Renderer3D<?> renderer3D = iterator.next();
            renderer3D.render(var1, var3, var5, var7, var8, var9);
            if (renderer3D.disposeNextFrame()) {
                iterator.remove();
            }
        }

        Iterator<Provider<Pair<Renderer3D<?>, Boolean>>> providerIterator = renderProviders.iterator();
        while (providerIterator.hasNext()) {
            Provider<Pair<Renderer3D<?>, Boolean>> provider = providerIterator.next();
            Pair<Renderer3D<?>, Boolean> pair = provider.get();
            Renderer3D<?> renderer3D = pair.getA();
            renderer3D.render(var1, var3, var5, var7, var8, var9);
            if (!pair.getB()) {
                providerIterator.remove();
            }
        }
    }

}
