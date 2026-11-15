import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pilihanMenu = 0;

        do {
            System.out.println("=".repeat(12));
            System.out.println("0. Keluar Program");
            System.out.println("1. Cetak Stasiun Lin Cikarang");
            System.out.println("2. Cetak Stasiun Lin Jakarta Kota");
            System.out.println("3. Hitung Tarif");
            System.out.print("Masukkan pilihan (0/1/2/3): ");
            int pilihanBaru = scanner.nextInt(); scanner.nextLine();
            pilihanMenu = pilihanBaru; 
            System.out.println("=".repeat(12));

            switch (pilihanMenu) {
                case 0: 
                    System.out.println("Program keluar.");
                    break;
                case 1: {
                    menuCetakLinCikarang();
                    break;
                }

                case 2: {
                    menuCetakLinJakartaKota();
                    break;
                }
                
                case 3:
                    menuHitungTarif(scanner);
                    break;
            
                default:
                    System.out.println("Pilihan tidak dikenal!");
                    break;
            }

        } while (pilihanMenu!=0);        

        scanner.close();
    }

    private static void menuHitungTarif(
        Scanner scanner
    ){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        addLinCikarang(graph);
        addLinJakartaKota(graph);
        
        System.out.print("Masukkan stasiun awal: ");
        String start = scanner.nextLine().trim();
        
        if(validasiStasiun(start, graph) == false){
            System.out.println("Nama stasiun tidak valid!");
            return;
        }

        System.out.print("Masukkan stasiun akhir: ");
        String end = scanner.nextLine().trim();

        if(validasiStasiun(end, graph) == false){
            System.out.println("Nama stasiun tidak valid!");
            return;
        }

        int jarak = hitungJarak(graph, start, end);
        int tarif = hitungTarif(jarak);

        System.out.printf("Jarak = %d meter\n", jarak);
        System.out.printf("Tarif = Rp%d\n", tarif);
    }

    private static void menuCetakLinCikarang(){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        addLinCikarang(graph);
        menuCetakLin(graph, "Cikarang");
    }

    private static void menuCetakLinJakartaKota(){
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        addLinJakartaKota(graph);
        menuCetakLin(graph, "Jakarta Kota");
    }

    private static void menuCetakLin(
        Map<String, Map<String, Integer>> graph,
        String nama
    ){
        System.out.printf("==== Lin %s ====\n", nama);
        String[] arrayStasiun = new String[graph.keySet().size()];
        int i = 0;
        for (String stasiun : graph.keySet()) {
            arrayStasiun[i] = stasiun;
            i++;
        }
        System.out.printf("%s\n", String.join(", ", arrayStasiun));
    }

    private static boolean validasiStasiun(
        String stasiunMungkinValid, 
        Map<String, Map<String, Integer>> graph
    ){
        Set<String> stasiunValid = graph.keySet();
        boolean isValid = stasiunValid.contains(stasiunMungkinValid);
        return isValid;
    }

    private static int hitungTarif(int jarakMeter) {
        int baseTarif = 3000;
        int tarifPer10Kilo = 0;
        if (jarakMeter > 25) {
            int jarakPerSepuluhKilo = (int) Math.ceil((jarakMeter - 25_000) / 10_000d);
            tarifPer10Kilo = jarakPerSepuluhKilo * 1000;
        }
        return baseTarif + tarifPer10Kilo;
    }

    

    // Bagian dari Red Line; Kurang lengkap
    private static void addLinJakartaKota(Map<String, Map<String, Integer>> graph){
        // Jakarta Kota
        add(graph, "Jakarta Kota",  "Jayakarta", 1487);
        // Jayakarta
        add(graph, "Jayakarta",  "Mangga Besar", 1020);
        // Mangga Besar
        add(graph, "Mangga Besar",  "Sawah Besar", 1171);
        // Sawah Besar
        add(graph, "Sawah Besar",  "Juanda", 707);
        // Juanda
        add(graph, "Juanda",  "Gondangdia", 2198);
        // Gondangdia
        add(graph, "Gondangdia",  "Cikini", 1699);
        // Cikini
        add(graph, "Cikini",  "Manggarai", 1606);
        // Manggarai
    }

    private static void addLinCikarang(Map<String, Map<String, Integer>> graph){
        // Cikarang
        add(graph, "Cikarang",  "Metland Telaga Murni", 3482);
        // Metland Telaga Murni
        add(graph, "Metland Telaga Murni",  "Cibitung", 3007);
        // Cibitung
        add(graph, "Cibitung",  "Tambun",   3420);
        // Tambun
        add(graph, "Tambun",    "Bekasi Timur", 3430);
        // Bekasi Timur
        add(graph, "Bekasi Timur",  "Bekasi", 3298);
        // Bekasi
        add(graph, "Bekasi",    "Kranji",   2520);
        // Kranji
        add(graph, "Kranji",    "Cakung",   3097);
        // Cakung
        add(graph, "Cakung",    "Klender Baru",   1385);
        // Klender Baru
        add(graph, "Klender Baru",    "Buaran",   1305 );
        // Buaran
        add(graph, "Buaran",    "Klender",   3100);
        // Klender
        add(graph, "Klender",    "Jatinegara",   3395);
        // Jatinegara
        add(graph, "Jatinegara",    "Matraman",   1312);
        // Matraman
        add(graph, "Matraman",    "Manggarai",   1340);
        // Manggarai
        add(graph, "Manggarai",    "Sudirman",   3186);
        // Sudirman
        add(graph, "Sudirman",    "BNI City",    460);
        // BNI City
        add(graph, "BNI City",    "Karet",   351);
        // Karet
        add(graph, "Karet",    "Tanah Abang",   2029);
        // Tanah Abang
        add(graph, "Tanah Abang",    "Duri",   3632);
        // Duri
        add(graph, "Duri",    "Angke",   1230);
        // Angke
        add(graph, "Angke",    "Kampung Bandan",   4102);
        // Kampung Bandan
        add(graph, "Kampung Bandan",    "Rajawali",   1444);
        // Rajawali
        add(graph, "Rajawali",    "Kemayoran",   1901);
        // Kemayoran
        add(graph, "Kemayoran",    "Pasar Senen",   1436);
        // Pasar Senen
        add(graph, "Pasar Senen",    "Gang Sentiong", 1567);
        // Gang Sentiong
        add(graph, "Gang Sentiong",    "Kramat",   973);
        // Kramat
        add(graph, "Kramat",    "Pondok Jati",   1829);
        // Pondok Jati
        add(graph, "Pondok Jati",    "Jatinegara",   1236);
        // Jatinegara
    }

    private static void add(
            Map<String, Map<String, Integer>> graph,
            String stasiunPertama,
            String stasiunKedua,
            Integer jarakMeter) {
        if (graph.get(stasiunPertama) == null) {
            graph.put(stasiunPertama, new HashMap<>());
        }
        if (graph.get(stasiunKedua) == null) {
            graph.put(stasiunKedua, new HashMap<>());
        }

        graph.get(stasiunPertama).put(stasiunKedua, jarakMeter);
        graph.get(stasiunKedua).put(stasiunPertama, jarakMeter);
    }

    
    static int hitungJarak(
            Map<String, Map<String, Integer>> graph,
            String start,
            String destination) {
        Map<String, Integer> distance = new HashMap<>();
        Map<String, String> previous = new HashMap<>();

        for (String station : graph.keySet()) {
            distance.put(station, Integer.MAX_VALUE);
        }

        distance.put(start, 0);

        PriorityQueue<String> queue = new PriorityQueue<>(
                Comparator.comparingInt(distance::get));

        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(destination)) {
                break;
            }

            int currentDistance = distance.get(current);

            for (Map.Entry<String, Integer> neighbor : graph.get(current).entrySet()) {

                // System.out.printf("%s : %s : %s\n\n", current, graph.get(current).toString(),
                // graph.get(current).entrySet().toString());

                String next = neighbor.getKey();
                int weight = neighbor.getValue();

                int newDistance = currentDistance + weight;

                if (newDistance < distance.get(next)) {
                    distance.put(next, newDistance);
                    previous.put(next, current);

                    queue.remove(next);
                    queue.add(next);
                }
            }
        }

        List<String> path = new ArrayList<>();

        String current = destination;

        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }

        Collections.reverse(path);

        // System.out.printf("Shortest distance: %d\n", distance.get(destination));
        // System.out.printf("Shortest path: %s\n", String.join(" -> ", path));

        return distance.get(destination);
    }

}