import java.util.PriorityQueue;

public class connectRopes {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        PriorityQueue<Integer> minh = new PriorityQueue<>(); //min heap default implementation
        int totalCost = 0;
        for (int i = 0; i < arr.length; i++) {
            minh.add(arr[i]);
        }

        while (minh.size() >= 2) {
            int first = minh.poll();
            int second = minh.poll();
            totalCost += first + second;
            minh.add(first + second);
        }

        System.out.println("Total Optimal Cost of ropes is " + totalCost);
    }
}
