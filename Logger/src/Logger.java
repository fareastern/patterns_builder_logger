import java.text.SimpleDateFormat;
import java.util.Date;

class Logger {
    private static Logger instance;
    private int num = 1;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String msg) {
        String date = dateFormat.format(new Date());
        System.out.println("[" + date + " " + num++ + "] " + msg);
    }
}