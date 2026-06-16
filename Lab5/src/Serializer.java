import java.io.*;

public class Serializer {
    public static void serialize(Object obj, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(obj);
            Logger.log("Serializer", "Серіалізовано об'єкт у файл: " + filename);
        } catch (IOException e) {
            Logger.log("Serializer", "Помилка серіалізації: " + e.getMessage(), "exception");
        }
    }

    public static Object deserialize(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = ois.readObject();
            Logger.log("Serializer", "Десеріалізовано об'єкт з файлу: " + filename);
            return obj;
        } catch (IOException | ClassNotFoundException e) {
            Logger.log("Serializer", "Помилка десеріалізації: " + e.getMessage(), "exception");
            return null;
        }
    }
}