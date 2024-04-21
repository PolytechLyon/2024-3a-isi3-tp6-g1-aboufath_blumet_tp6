package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.FileLogger;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerCreator;

import java.util.Iterator;

import static fr.polytech.sim.log.LoggerCreator.useLog;
import static fr.polytech.sim.utils.Context.inject;
import static fr.polytech.sim.utils.Context.injectAll;

/**
 * Bike simulation.
 */
public class BikeSimulator implements Simulation {
    //private final Logger logger = new FileLogger("BikeSimulator");

    public void run() {
        //Bike bike = new SimpleBike();
        // this.logger.log("Bike's speed %.2f Km/h.", bike.getVelocity());
        //this.logger.log("Bike's mass %.2f Kg.", bike.getMass());

        //Avec inject
//        Bike bike = inject(Bike.class);
//        useLog("BikeSimulator (inject)","Bike's speed %.2f Km/h.", bike.getVelocity());
//        useLog("BikeSimulator (inject)","Bike's mass %.2f Kg.", bike.getMass());

        //Avec injectAll
        Iterator<Bike> bikes = injectAll(Bike.class);
        while(bikes.hasNext()){
            Bike bike = bikes.next();
            useLog("BikeSimulator (injectAll)","Bike's speed %.2f Km/h.", bike.getVelocity());
            useLog("BikeSimulator (injectAll)","Bike's mass %.2f Kg.", bike.getMass());
        }
    }
}
