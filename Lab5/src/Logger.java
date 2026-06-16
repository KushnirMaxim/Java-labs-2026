import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Logger {
    private static boolean loggingEnabled = true;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String username = System.getProperty("user.name");

    static {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream("lab5.properties"));
            loggingEnabled = props.getProperty("logging", "on").equals("on");
        } catch (IOException e) {
            loggingEnabled = true;
        }
    }

    public static void log(String className, String message, String type) {
        if (!loggingEnabled) return;
        String entry = LocalDateTime.now().format(formatter) + " | " + username + " | " + message + " | " + type;
        try (FileWriter fw = new FileWriter(className + ".log", true)) {
            fw.write(entry + "\n");
        } catch (IOException e) {
            System.err.println("Помилка логування: " + e.getMessage());
        }
    }

    public static void log(String className, String message) {
        log(className, message, "message");
    }
}