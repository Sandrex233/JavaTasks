import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println(addBinaryString("1010", "1011"));
        System.out.println(minSplit(11));
    }

    // Task N1
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
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

    // Task N2
    public static int minSplit(int amount) {
        int[] coins = {1,5,10,20,50};

        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        
        minCoins[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
            }
        }

        return minCoins[amount] > amount ? -1 : minCoins[amount];
    }

    // Task N3
    public int notContains(int[] array) {
        if (array == null || array.length == 0) return 1;
        int n = array.length;

        HashSet<Integer> set = new HashSet<>();

        for (int num : array) {
            if (num > 0) {
                set.add(num);
            }
        }
        for (int i = 1; i <= n + 1; i++) {
            System.out.println(i);
            if (!set.contains(i)) {
                return i;
            }
        }

        return n + 1; // If all integers from 1 to n are present, return n + 1
    }

    // Task N4 - Solution 1
//    public static String addBinaryString(String a, String b) {
//        int aToDecimal = Integer.parseInt(a, 2);
//        int bToDecimal = Integer.parseInt(b, 2);
//
//        String res = Integer.toBinaryString(aToDecimal + bToDecimal);
//        return res;
//    }

    // Task N4 - Solution 2
    public static String addBinaryString(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;

            sum += a.charAt(i) - '0';
            sum += b.charAt(j) - '0';

            result.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        if (carry != 0) result.append(carry);
        return result.reverse().toString();
    }

    // Task N5
    public int countVariants(int stearsCount) {
        if (stearsCount == 1) return 1;
        if (stearsCount == 2) return 2;

        int[] steps = new int[stearsCount + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= stearsCount; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[stearsCount];
    }

}
