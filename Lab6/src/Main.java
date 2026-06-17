import java.util.*;

public class Main {
    public static void main(String[] args) {

        Habitat swamp = new Habitat("Болото", "прісна");
        Habitat river = new Habitat("Річка", "прісна");

        Amphibian frog = new Amphibian("Жаба трав'яна", "Rana temporaria", 40, swamp);
        Amphibian toad = new Amphibian("Ропуха сіра", "Bufo bufo", 35, river);
        Amphibian salamander = new Amphibian("Саламандра плямиста", "Salamandra salamandra", 30, swamp);
        Amphibian frog2 = new Amphibian("Жаба трав'яна", "Rana temporaria", 40, swamp); // дублікат
        Amphibian newt = new Amphibian("Тритон звичайний", "Lissotriton vulgaris", 25, river);

        // ===== 1. ArrayList =====
        System.out.println("=== ArrayList ===");
        List<Amphibian> arrayList = new ArrayList<>();
        arrayList.add(frog);
        arrayList.add(toad);
        arrayList.add(salamander);
        arrayList.add(frog2); // дублікат — ArrayList дозволяє
        arrayList.add(newt);
        arrayList.forEach(a -> System.out.println(a));

        // ===== 2. HashSet — тільки унікальні =====
        System.out.println("\n=== HashSet (унікальні) ===");
        Set<Amphibian> hashSet = new HashSet<>(arrayList);
        hashSet.forEach(a -> System.out.println(a));

        // ===== 3. Сортування ArrayList =====
        System.out.println("\n=== ArrayList після сортування за назвою ===");
        Collections.sort(arrayList);
        arrayList.forEach(a -> System.out.println(a));

        // ===== 4. TreeSet — унікальні і впорядковані =====
        System.out.println("\n=== TreeSet (унікальні + впорядковані) ===");
        Set<Amphibian> treeSet = new TreeSet<>(arrayList);
        treeSet.forEach(a -> System.out.println(a));

        // ===== 5. TreeMap — ключ: назва, значення: об'єкт =====
        System.out.println("\n=== TreeMap (ключ: назва) ===");
        Map<String, Amphibian> treeMap = new TreeMap<>();
        treeMap.put(frog.getName(), frog);
        treeMap.put(toad.getName(), toad);
        treeMap.put(salamander.getName(), salamander);
        treeMap.put(newt.getName(), newt);
        treeMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        // ===== 6. LinkedList =====
        System.out.println("\n=== LinkedList ===");
        LinkedList<Amphibian> linkedList = new LinkedList<>(arrayList);
        linkedList.addFirst(new Amphibian("Квакша звичайна", "Hyla arborea", 45, swamp));
        linkedList.forEach(a -> System.out.println(a));

        // ===== 7. Queue =====
        System.out.println("\n=== Queue ===");
        Queue<Amphibian> queue = new LinkedList<>();
        queue.add(frog);
        queue.add(toad);
        queue.add(salamander);
        while (!queue.isEmpty()) {
            System.out.println("Витягнуто з черги: " + queue.poll());
        }

        // ===== 8. PriorityQueue — сортує автоматично =====
        System.out.println("\n=== PriorityQueue ===");
        PriorityQueue<Amphibian> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(frog);
        priorityQueue.add(toad);
        priorityQueue.add(salamander);
        priorityQueue.add(newt);
        while (!priorityQueue.isEmpty()) {
            System.out.println("Витягнуто: " + priorityQueue.poll());
        }
    }
}