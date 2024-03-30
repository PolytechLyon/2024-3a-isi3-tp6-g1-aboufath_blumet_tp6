package fr.polytech.sim.log;

public class LoggerCreator {
    static Logger createLogger(String name){
        //return new FileLogger(name);
        //return new ConsoleLogger(name);
        //return new TimestampedLoggerDecorator(new FileLogger(name));
        return new TimestampedLoggerDecorator(new ConsoleLogger(name));

    }
    public static void useLog(String name,String format, Object... args){
        Logger logger = createLogger(name);
        logger.log(format,args);
    }
}
