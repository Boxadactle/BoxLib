package dev.boxadactle.boxlib.scheduler;

import dev.boxadactle.boxlib.util.function.EmptyMethod;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class Scheduling {

    static List<ScheduleAction> actions = Lists.newArrayList();
    static List<ScheduleAction> finishedActions = Lists.newArrayList();

    public static void schedule(ScheduleAction action) {
        actions.add(action);
    }

    public static ScheduleAction schedule(int ticks, EmptyMethod method) {
        ScheduleAction action = new ScheduleAction() {
            @Override
            public int getWaitTime() {
                return ticks;
            }

            @Override
            public void run() {
                method.accept();
            }
        };

        actions.add(action);

        return action;
    }

    public static void cancel(ScheduleAction action) {
        finishedActions.add(action);
    }

    public static void tick() {
        if (actions.isEmpty()) return;

        actions.forEach(a -> {
            if (a.tick()) finishedActions.add(a);
        });

        // we all love java.util.ConcurrentModificationException
        finishedActions.forEach(completed -> actions.remove(completed));

        finishedActions.clear();
    }

}
