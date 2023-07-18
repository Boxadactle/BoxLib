package dev.boxadactle.boxlib;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
@SuppressWarnings("unchecked")
public abstract class ModConstantsProvider {

    private static final List<ModConstantsProvider> INSTANCES = new ArrayList<>();

    public static <T extends ModConstantsProvider> void registerProvider(Class<T> provider) throws IllegalStateException {
        ModConstantsProvider a;
        try {
            a = provider.getConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

        INSTANCES.add(a);
    }

    public static <T extends ModConstantsProvider> T getProvider(String modId) throws NullPointerException {
        AtomicReference<ModConstantsProvider> a = new AtomicReference<>(null);
        INSTANCES.forEach(instance -> {
            if (instance.getModId().equals(modId)) a.set(instance);
        });
        if (a.get() == null) throw new NullPointerException("Mod " + modId + " has not registered a constants provider");
        return (T) a.get();
    }

    public String getString() {
        return this.getName() + " v" + this.getVersion();
    }

    public abstract String getName();
    public abstract String getModId();
    public abstract String getVersion();
    public abstract String[] getAuthors();
    public abstract String getWiki();

}
