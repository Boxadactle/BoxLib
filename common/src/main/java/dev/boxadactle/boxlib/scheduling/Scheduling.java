package dev.boxadactle.boxlib.scheduling;

import dev.boxadactle.boxlib.function.EmptyMethod;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * The Scheduling class provides functionality for scheduling actions to be executed after a certain delay.
 */
public class Scheduling {

    static List<ScheduleAction> actions = Lists.newArrayList();
    static List<ScheduleAction> finishedActions = Lists.newArrayList();

    /**
     * Schedules an action to be executed immediately.
     *
     * @param action the action to be scheduled
     */
    public static void schedule(ScheduleAction action) {
        actions.add(action);
    }

    /**
     * Schedules an action to be executed after a specified number of ticks.
     *
     * @param ticks  the number of ticks to wait before executing the action
     * @param method the method to be executed
     * @return the scheduled action
     */
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

    /**
     * Cancels a scheduled action.
     *
     * @param action the action to be canceled
     */
    public static void cancel(ScheduleAction action) {
        finishedActions.add(action);
    }

    /**
     * Executes the scheduled actions and removes the completed actions from the list.
     */
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
