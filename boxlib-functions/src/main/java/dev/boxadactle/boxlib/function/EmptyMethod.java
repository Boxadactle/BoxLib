package dev.boxadactle.boxlib.function;

/**
 * Represents an empty method that takes no arguments and returns no result.
 * This functional interface can be used to define lambda expressions or method references
 * that represent a block of code with no input or output.
 */
@FunctionalInterface
public interface EmptyMethod {

    /**
     * Executes the empty method.
     */
    void accept();

}
