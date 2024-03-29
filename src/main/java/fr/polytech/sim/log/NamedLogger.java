package fr.polytech.sim.log;

/**
 * Name logger that is supposed to log its name along with each log entry, to
 * facilitate tracing.
 */
public abstract class NamedLogger implements Logger {
    final protected String name;

    /**
     * Constructor.
     *
     * @param name  logger name.
     */
    protected NamedLogger(String name) {
        this.name = name;
    }

    /**
     * Method to build the message put in the logfiles
     * @param format
     * @param args
     * @return
     */
    public void log(String format, Object... args){
        String entry = String.format(format, args);
        String message = String.format("%s\t%s\n", name, entry);
        showMessage(message);
    }

    protected abstract void showMessage(String message);

}
