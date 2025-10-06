import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.offer(i);
        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for (int next : graph.get(curr)) {
                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        CourseSchedule cs = new CourseSchedule();
        
        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Can finish courses? " + cs.canFinish(numCourses1, prerequisites1));
        // Output: true

        // Example 2
        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Can finish courses? " + cs.canFinish(numCourses2, prerequisites2));
        // Output: false
    }
}
