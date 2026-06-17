import java.io.Serializable;

public class Pond implements Serializable {
    private String name;
    private Amphibian[] amphibians;

    public Pond(String name, Amphibian[] amphibians) {
        this.name = name;
        this.amphibians = amphibians;
        Logger.log("Pond", "Створено Pond: " + name);
    }

    public void describeAll() {
        Logger.log("Pond", "Викликано describeAll для: " + name);
        System.out.println("\n=== Ставок: " + name + " ===");
        for (Amphibian a : amphibians) {
            a.describe();
            Amphibian.Classification classification = new Amphibian.Classification("Жаби", "Ranidae");
            System.out.println(classification.getInfo());
        }
    }

    public Amphibian[] getAmphibians() { return amphibians; }
    public String getName() { return name; }
}