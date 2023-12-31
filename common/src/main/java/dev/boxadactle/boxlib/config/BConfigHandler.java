package dev.boxadactle.boxlib.config;

import dev.boxadactle.boxlib.util.ClientUtils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class BConfigHandler {

    private static final HashMap<Class<? extends BConfig>, BConfigClass<?>> classes = new HashMap<>();

    private static String verifyFileExtension(String filename, String extension) {
        String nExtension = extension.trim().startsWith(".") ? extension : "." + extension;
        return filename + nExtension;
    }

    private static File getPath(String filename, String extension) {
        Path path = Paths.get(ClientUtils.getConfigFolder().toString(), verifyFileExtension(filename, extension));

        return new File(path.toString());
    }

    /**
     * The method that registers a config class.
     * This method must be run in order to load/save
     * a config class
     *
     * @param config The config class being registered.
     *               This class MUST implement {@link dev.boxadactle.boxlib.config.BConfig} and annotate {@link dev.boxadactle.boxlib.config.BConfigFile}
     * @return The registered config class
     *
     * @see dev.boxadactle.boxlib.config.BConfig
     * @see dev.boxadactle.boxlib.config.BConfigFile
     */
    public static <T extends BConfig> BConfigClass<T> registerConfig(Class<T> config) {
        Objects.requireNonNull(config);

        if (classes.containsKey(config)) throw new BConfig.ConfigException("Class " + config.getName() + " has already been registered!");

        BConfigFile a = config.getAnnotation(BConfigFile.class);

        File filepath;

        if (a != null) {
            if (a.value().isEmpty()) throw new BConfig.ConfigException("Class " + config.getName() + " does not specify a filename");
            filepath = getPath(a.value(), a.filetype());
        } else throw new BConfig.ConfigException("Class " + config.getName() + " does not annotate the BConfigFile annotation.");

        BConfigClass<T> holder = new BConfigClass<>(config, filepath);
        holder.load();
        classes.put(config, holder);
        return holder;
    }

    public static <T extends BConfig> BConfigClass<T> getConfigClass(Class <T> config) {
        return (BConfigClass<T>) classes.get(config);
    }

}
