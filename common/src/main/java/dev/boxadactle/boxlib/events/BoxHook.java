package dev.boxadactle.boxlib.events;

public interface BoxHook<T> {

    void register(T listener);

    T invoker();

}