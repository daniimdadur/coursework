package semester_2.task_03;

import java.util.*;

public class DfsBfsGraph {
    // Membuat graph menggunakan adjacency list
    private Map<String, List<String>> graph = new HashMap<>();

    // Menambahkan hubungan antar node
    public void addEdge(String node1, String node2) {
        graph.putIfAbsent(node1, new ArrayList<>());
        graph.putIfAbsent(node2, new ArrayList<>());

        graph.get(node1).add(node2);
        graph.get(node2).add(node1); // graph tidak berarah
    }

    // ================= DFS =================
    public void dfs(String start, String target) {
        Set<String> visited = new HashSet<>();

        System.out.println("Proses DFS:");
        dfsRecursive(start, target, visited);
    }

    private void dfsRecursive(String current, String target, Set<String> visited) {

        System.out.println("Mengunjungi node : " + current);

        if (current.equals(target)) {
            System.out.println("Target ditemukan : " + target);
            return;
        }

        visited.add(current);

        for (String neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, target, visited);
            }
        }
    }

    // ================= BFS =================
    public void bfs(String start, String target) {

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        System.out.println("\nProses BFS:");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println("Mengunjungi node : " + current);

            if (current.equals(target)) {
                System.out.println("Target ditemukan : " + target);
                return;
            }

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // ================= MAIN =================
    public static void main(String[] args) {

        DfsBfsGraph g = new DfsBfsGraph();

        // Membuat hubungan antar node
        g.addEdge("a0", "a1");
        g.addEdge("a0", "a2");
        g.addEdge("a1", "a3");
        g.addEdge("a1", "a4");
        g.addEdge("a2", "a5");
        g.addEdge("a2", "a6");
        g.addEdge("a3", "a7");
        g.addEdge("a4", "a8");
        g.addEdge("a5", "a9");

        // Target pencarian
        String target = "a9";

        // DFS
        g.dfs("a0", target);

        // BFS
        g.bfs("a0", target);
    }
}
