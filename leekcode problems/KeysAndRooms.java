import java.util.*;

public class KeysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        
        // Check if all rooms are visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    private static void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }
    
    public static void main(String[] args) {
        List<List<Integer>> rooms1 = new ArrayList<>();
        rooms1.add(Arrays.asList(1));
        rooms1.add(Arrays.asList(2));
        rooms1.add(Arrays.asList(3));
        rooms1.add(new ArrayList<>());
        
        System.out.println(canVisitAllRooms(rooms1)); // Output: true
        
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1,3));
        rooms2.add(Arrays.asList(3,0,1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));
        
        System.out.println(canVisitAllRooms(rooms2)); // Output: false
    }
}
