public class Main {
    public static void main(String[] args) {
        // Запис системної інформації
        SystemInfo.write();

        Habitat swamp = new Habitat("Болото", "прісна");
        Habitat river = new Habitat("Річка", "прісна");

        Amphibian frog = new Amphibian("Жаба трав'яна", "Rana temporaria", 40, swamp);
        Amphibian toad = new Amphibian("Ропуха сіра", "Bufo bufo", 35, river);
        Amphibian salamander = new Amphibian("Саламандра плямиста", "Salamandra salamandra", 30, swamp);

        Pond pond = new Pond("Лісове озеро", new Amphibian[]{frog, toad, salamander});
        pond.describeAll();

        // Серіалізація
        Serializer.serialize(pond, "pond.ser");

        // Десеріалізація і вивід інформації про класи
        Pond loadedPond = (Pond) Serializer.deserialize("pond.ser");
        if (loadedPond != null) {
            System.out.println("\n=== Інформація про класи ===");
            System.out.println("Клас: " + loadedPond.getClass().getName());
            for (Amphibian a : loadedPond.getAmphibians()) {
                System.out.println("Клас: " + a.getClass().getName());
            }
        }
    }
}