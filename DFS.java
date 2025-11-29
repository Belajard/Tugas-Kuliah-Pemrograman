import java.util.*;

public class Depth-FirstSearch {
    static void dfs(Map<String, List<String>> graph, String start, String target) {

        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            String node = stack.pop();

            if (!visited.contains(node)) {
                System.out.println("Visit: " + node);
                visited.add(node);

                if (node.equals(target)) {
                    System.out.println("Target ditemukan: " + node);
                    return;
                }

                for (String neighbor : graph.get(node)) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println("Target tidak ditemukan.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ------ GRAF ------
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("a1", Arrays.asList("a2", "a3"));
        graph.put("a2", Arrays.asList("a4", "a5"));
        graph.put("a3", Arrays.asList("a6"));
        graph.put("a4", Arrays.asList("a8"));
        graph.put("a5", Arrays.asList());
        graph.put("a6", Arrays.asList());
        graph.put("a8", Arrays.asList("a7"));
        graph.put("a7", Arrays.asList());

        // ------ INPUT USER ------
        System.out.print("Masukkan node awal: ");
        String start = sc.nextLine();

        System.out.print("Masukkan node yang dicari: ");
        String target = sc.nextLine();

        System.out.println("\n=== PROSES DFS ===");
        dfs(graph, start, target);
    }
}
