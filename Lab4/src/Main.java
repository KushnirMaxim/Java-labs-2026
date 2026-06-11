public class Main {

    // ===== АСОЦІАЦІЯ =====
    static class Habitat {
        private String name;
        private String waterType;

        public Habitat(String name, String waterType) {
            this.name = name;
            this.waterType = waterType;
        }

        public String getInfo() {
            return name + " (" + waterType + ")";
        }
    }

    // ===== ГОЛОВНИЙ КЛАС =====
    static class Amphibian {
        private String name;
        private String species;
        private Heart heart;       // композиція
        private Habitat habitat;   // асоціація

        // КОМПОЗИЦІЯ
        class Heart {
            private int beatsPerMinute;

            public Heart(int beatsPerMinute) {
                this.beatsPerMinute = beatsPerMinute;
            }

            public String getInfo() {
                return name + " має серце з пульсом " + beatsPerMinute + " уд/хв";
            }
        }

        // STATIC NESTED
        static class Classification {
            private String order;
            private String family;

            public Classification(String order, String family) {
                this.order = order;
                this.family = family;
            }

            public String getInfo() {
                return "Ряд: " + order + ", Родина: " + family;
            }
        }

        public Amphibian(String name, String species, int heartRate, Habitat habitat) {
            this.name = name;
            this.species = species;
            this.heart = new Heart(heartRate);
            this.habitat = habitat;
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

            new Describer().print();
        }
    }

    // ===== АГРЕГАЦІЯ =====
    static class Pond {
        private String name;
        private Amphibian[] amphibians;

        public Pond(String name, Amphibian[] amphibians) {
            this.name = name;
            this.amphibians = amphibians;
        }

        public void describeAll() {
            System.out.println("\n=== Ставок: " + name + " ===");
            for (Amphibian a : amphibians) {
                a.describe();
                Amphibian.Classification classification = new Amphibian.Classification("Жаби", "Ranidae");
                System.out.println(classification.getInfo());
            }
        }
    }

    public static void main(String[] args) {
        Habitat swamp = new Habitat("Болото", "прісна");
        Habitat river = new Habitat("Річка", "прісна");

        Amphibian frog = new Amphibian("Жаба трав'яна", "Rana temporaria", 40, swamp);
        Amphibian toad = new Amphibian("Ропуха сіра", "Bufo bufo", 35, river);
        Amphibian salamander = new Amphibian("Саламандра плямиста", "Salamandra salamandra", 30, swamp);

        Pond pond = new Pond("Лісове озеро", new Amphibian[]{frog, toad, salamander});
        pond.describeAll();
    }
}