import java.util.*;

public class BFS {
    static int[] value = {10, 22, 35, 40, 55, 60, 75, 90}; // a1..a8
    static List<Integer>[] adj = new ArrayList[8];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 8; i++) adj[i] = new ArrayList<>();

        // edges undirected sama seperti DFS
        addEdge(0,1); addEdge(0,2);
        addEdge(1,3); addEdge(1,4);
        addEdge(2,5);
        addEdge(3,6);
        addEdge(4,6); addEdge(4,7);
        addEdge(5,7);
        addEdge(6,7);

        System.out.println("Nodes dan nilai:");
        for (int i = 0; i < 8; i++) System.out.printf("a%d = %d\n", i+1, value[i]);

        // input node awal
        System.out.print("\nMasukkan node awal (a1..a8): ");
        String startNode = sc.nextLine().toLowerCase();
        int start = Integer.parseInt(startNode.substring(1)) - 1;

        System.out.print("Masukkan nilai yang dicari (n): ");
        int target = sc.nextInt();

        System.out.println("\n--- Mulai BFS dari " + startNode + " ---");
        bfsWithTrace(start, target);
    }

    static void addEdge(int u, int v) {
        adj[u].add(v); adj[v].add(u);
    }

    static void bfsWithTrace(int start, int target) {
        boolean[] visited = new boolean[8];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        printQueue(queue, "Queue awal");

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println("\nDequeue -> ambil a" + (u+1) + " (nilai=" + value[u] + ")");
            if (value[u] == target) {
                System.out.println(">>> DITEMUKAN di a" + (u+1) + " (nilai=" + value[u] + ")");
                return;
            }

            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                    System.out.println("  Enqueue a" + (v+1));
                    printQueue(queue, "  Queue sekarang");
                } else {
                    System.out.println("  Tetangga a" + (v+1) + " sudah visited, lewati");
                }
            }
        }
        System.out.println("\nHasil: nilai " + target + " TIDAK DITEMUKAN di graf.");
    }

    static void printQueue(Queue<Integer> q, String caption) {
        List<String> names = new ArrayList<>();
        for (int x : q) names.add("a" + (x+1));
        System.out.println(caption + ": " + names);
    }
}
