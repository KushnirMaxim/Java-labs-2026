import java.io.Serializable;

public class Amphibian implements Serializable {
    private String name;
    private String species;
    private Heart heart;
    private Habitat habitat;

    // КОМПОЗИЦІЯ - inner клас
    class Heart implements Serializable {
        private int beatsPerMinute;

        public Heart(int beatsPerMinute) {
            this.beatsPerMinute = beatsPerMinute;
            Logger.log("Amphibian", "Створено Heart з пульсом: " + beatsPerMinute);
        }

        public String getInfo() {
            return name + " має серце з пульсом " + beatsPerMinute + " уд/хв";
        }
    }

    // STATIC NESTED клас
    static class Classification implements Serializable {
        private String order;
        private String family;

        public Classification(String order, String family) {
            this.order = order;
            this.family = family;
            Logger.log("Amphibian", "Створено Classification: " + order + ", " + family);
        }

        public String getInfo() {
            return "Ряд: " + order + ", Родина: " + family;
        }
    }

    public Amphibian(String name, String species, int heartRate, Habitat habitat) {
        this.name = name;
        this.species = species;
        this.habitat = habitat;
        this.heart = new Heart(heartRate);
        Logger.log("Amphibian", "Створено Amphibian: " + name);
    }

    public void describe() {
        // ЛОКАЛЬНИЙ КЛАС
        class Describer {
            public void print() {
                System.out.println("--- " + name + " ---");
                System.out.println("Вид: " + species);
                System.out.println("Середовище: " + habitat.getInfo());
                System.out.println(heart.getInfo());
            }
        }
        Logger.log("Amphibian", "Викликано describe для: " + name);
        new Describer().print();
    }

    public String getName() { return name; }
    public String getSpecies() { return species; }
}