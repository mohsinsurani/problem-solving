import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

class NearestGreaterRight {
    public static void printSmall(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];

        // Greater to Left --> Start from Left for (int i = 0; i <= arr.length - 1; i++)
        // {
        // Greater to Right --> Start from Right
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!s.empty()) {
                while (!s.empty() && s.peek() >= arr[i]) {
                    s.pop();
                }
            }
            if (s.empty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " --> " + result[i]);
    }

    public static void printGrt(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int[] result = new int[arr.length];

        // Greater to Left --> Start from Left for (int i = 0; i <= arr.length - 1; i++)
        // {
        // Greater to Right --> Start from Right
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!s.empty()) {
                while (!s.empty() && s.peek() <= arr[i]) {
                    s.pop();
                }
            }
            if (s.empty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(arr[i]);
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " --> " + result[i]);
    }

    // StockSpan -> Consecutive smaller or equal to --> Get NGL Index --> i - NGL --> Answer
    // NGLIndex --> Solved
    public static void printStockSpan(int[] arr) {
        Stack<Map.Entry<Integer, Integer>> s = new Stack<>();
        int[] result = new int[arr.length];
        //key -> Value, Value --> Index
        //Greater to left
        for (int i = 0; i <= arr.length - 1; i++) {
            if (!s.empty()) {
                while (!s.empty() && s.peek().getKey() <= arr[i]) {
                    s.pop();
                }
            }
            if (s.empty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek().getValue(); 
            }
            Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleImmutableEntry<>(arr[i], i);
            s.push(entry);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] =  i - result[i]; // index - NGL Index 
        }

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i] + " --> " + result[i]);
    }

    public static void main(String[] args) {
        int[] arr = { 10, 4, 5, 90, 120, 80 };
        // printSmall(arr); // Smallest left or right
        // printGrt(arr); // Greatest left or right
        printStockSpan(arr);
    }
}