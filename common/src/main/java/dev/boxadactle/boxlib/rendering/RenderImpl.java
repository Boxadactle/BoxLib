package dev.boxadactle.boxlib.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.boxadactle.boxlib.function.Provider;
import net.minecraft.client.renderer.MultiBufferSource;
import oshi.util.tuples.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RenderImpl {

    static List<Renderer3D> renderers = new ArrayList<>();
    static List<Provider<Pair<Renderer3D, Boolean>>> renderProviders = new ArrayList<>();

    public static void renderAll(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, double d, double e, double f) {
        Iterator<Renderer3D> iterator = renderers.iterator();
        while (iterator.hasNext()) {
            Renderer3D renderer3D = iterator.next();
            renderer3D.render(poseStack, bufferSource, d, e, f);
            if (renderer3D.disposeNextFrame()) {
                iterator.remove();
            }
        }

        Iterator<Provider<Pair<Renderer3D, Boolean>>> providerIterator = renderProviders.iterator();
        while (providerIterator.hasNext()) {
            Provider<Pair<Renderer3D, Boolean>> provider = providerIterator.next();
            Pair<Renderer3D, Boolean> pair = provider.get();
            Renderer3D renderer3D = pair.getA();
            renderer3D.render(poseStack, bufferSource, d, e, f);
            if (!pair.getB()) {
                providerIterator.remove();
            }
        }
    }

}
