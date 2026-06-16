import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SystemInfo {
    public static void write() {
        String info = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                " | ОС: " + System.getProperty("os.name") +
                " " + System.getProperty("os.arch") +
                " " + System.getProperty("os.version") +
                " | JVM: " + System.getProperty("java.version") +
                " (" + System.getProperty("java.vendor") + ")" +
                " | Користувач: " + System.getProperty("user.name");

        try (FileWriter fw = new FileWriter("system_info.txt", true)) {
            fw.write(info + "\n");
            System.out.println("system_info.txt записано");
        } catch (IOException e) {
            Logger.log("SystemInfo", "Помилка запису system_info: " + e.getMessage(), "exception");
        }
    }
}