package fr.polytech.sim.log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampedLoggerDecorator implements Logger{
    Logger logger;
     public TimestampedLoggerDecorator(Logger logger){
        this.logger=logger;
     }

    public void log(String format, Object... args){
         DateFormat date = new SimpleDateFormat("hh:mm:ss a");
         String time = date.format(new Date());
         logger.log("At "+time+" |"+format, args); //affichage du message avec l'horaire
     }

}
