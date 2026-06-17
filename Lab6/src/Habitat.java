import java.io.Serializable;

public class Habitat implements Serializable {
    private String name;
    private String waterType;

    public Habitat(String name, String waterType) {
        this.name = name;
        this.waterType = waterType;
        Logger.log("Habitat", "Створено Habitat: " + name);
    }

    public String getInfo() {
        Logger.log("Habitat", "Викликано getInfo для: " + name);
        return name + " (" + waterType + ")";
    }
}