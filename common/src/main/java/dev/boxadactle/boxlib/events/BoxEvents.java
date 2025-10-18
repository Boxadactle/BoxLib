package dev.boxadactle.boxlib.events;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BoxEvents {

    @SuppressWarnings("unchecked")
    public static <T> BoxHook<T> create(Class<T> type, InvokerFactory<T> invokerFactory) {
        return new BoxHook<T>() {
            private final List<T> listeners = new ArrayList<>();
            private T invoker = invokerFactory.create(listeners.toArray((T[]) Array.newInstance(type, 0)));

            @Override
            public void register(T listener) {
                listeners.add(listener);
                invoker = invokerFactory.create(listeners.toArray((T[]) Array.newInstance(type, 0)));
            }

            @Override
            public T invoker() {
                return invoker;
            }
        };
    }

    public interface InvokerFactory<T> {
        T create(T[] listeners);
    }

}
