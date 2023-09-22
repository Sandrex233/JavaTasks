import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    // Task N1
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if(!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // Task N3
    public static int notContains(int[] array) {
        if(array == null || array.length == 0) return 1;
        int n = array.length;

        HashSet<Integer> set = new HashSet<>();

        for (int num : array) {
            if (num > 0) {
                set.add(num);
            }
        }
        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return n + 1; // If all integers from 1 to n are present, return n + 1
    }

}