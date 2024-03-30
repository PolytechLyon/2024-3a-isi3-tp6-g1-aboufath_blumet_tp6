package fr.polytech.sim.cycling;

import fr.polytech.sim.transport.Vehicle;

public class TagAlongBike extends Bike{

    Vehicle veloEnfant;
    public TagAlongBike() {//Vehicle childBike
        components.add(new SimpleBike());
        this.veloEnfant = new SimpleBike();//childBike;
        components.add(this.veloEnfant);
    }



}
