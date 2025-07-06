package dev.boxadactle.boxlib.scheduling;

/**
 * The abstract base class for scheduled actions.
 * Subclasses of this class can be used to define actions that are executed after a certain amount of time has elapsed.
 */
public abstract class ScheduleAction implements Runnable {

    private int elapsedTicks = 0;

    /**
     * Gets the wait time in ticks before the action should be executed.
     *
     * @return The wait time in ticks.
     */
    public abstract int getWaitTime();

    /**
     * Advances the elapsed ticks and checks if the action should be executed.
     *
     * @return true if the action was executed, false otherwise.
     */
    public boolean tick() {
        elapsedTicks++;

        if (getWaitTime() == elapsedTicks) {
            this.run();
            return true;
        }

        return false;
    }

    /**
     * Executes the action.
     * Subclasses should override this method to define the specific action to be performed.
     */
    public abstract void run();
}
