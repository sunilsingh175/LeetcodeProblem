import java.util.*;

public class AccountMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name);
                parent.put(email, email);
            }
        }

        for (List<String> acc : accounts) {
            String first = acc.get(1);
            for (int i = 2; i < acc.size(); i++) {
                union(parent, first, acc.get(i));
            }
        }

        Map<String, TreeSet<String>> unions = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));
            merged.addAll(unions.get(root));
            result.add(merged);
        }
        return result;
    }

    private static String find(Map<String, String> parent, String s) {
        if (!parent.get(s).equals(s))
            parent.put(s, find(parent, parent.get(s)));
        return parent.get(s);
    }

    private static void union(Map<String, String> parent, String a, String b) {
        parent.put(find(parent, a), find(parent, b));
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        List<List<String>> result = accountsMerge(accounts);
        for (List<String> acc : result) {
            System.out.println(acc);
        }
    }
}
