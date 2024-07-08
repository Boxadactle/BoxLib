package dev.boxadactle.boxlib.function;

/**
 * The ClassProvider interface represents a provider of a specific class.
 * It defines a single method, get(), which returns an instance of the class.
 *
 * @param <T> the type of the class being provided
 */
public interface ClassProvider<T> {

    /**
     * Returns an instance of the class being provided.
     *
     * @return an instance of the class
     */
    T get();

}
