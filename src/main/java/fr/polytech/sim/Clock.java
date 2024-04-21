package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public class Clock {
    private final int time = new Random().nextInt(25);
    private static Clock instance;
    private Clock(){}

    /**
     * Random integer between 0 and 24 inclusive.
     */
    public int getTime() {
        return this.time;
    }

    public static Clock getInstance(){
        if(instance == null) {
            instance = new Clock();
        }
        return instance;
    }
}
