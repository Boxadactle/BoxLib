package dev.boxadactle.boxlib.scheduler;

import dev.boxadactle.boxlib.BoxLib;

public abstract class ScheduleAction implements Runnable {

    private int elapsedTicks = 0;

    public abstract int getWaitTime();

    public boolean tick() {
        elapsedTicks++;

        if (getWaitTime() == elapsedTicks) {
            this.run();
            return true;
        }

        return false;
    }

}
