import java.util.*;

class Heap {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

         System.out.println("\ntop is " + findSmallest(arr, k, arr.length));
        // System.out.println("\ntop is " + findLargest(arr, k, arr.length));
        // for (int a = 0; a < arr.length; a++) {
        //     System.out.println("\nsorted array is " + sortKmanner(arr, k, arr.length).elementAt(a));
        // }
    }

    static Vector<Integer> sortKmanner(int[] arr, int k, int size) {
        PriorityQueue<Integer> minh = new PriorityQueue<>(); //min heap default implementation
        Vector<Integer> sortedV = new Vector<>();

        for (int i = 0; i < size; i++) {
            minh.add(arr[i]);

            if(minh.size() > k) {
                sortedV.add(minh.poll());
            }
        }

        while(minh.size() > 0) {
            sortedV.add(minh.poll());
        }

        return sortedV;
    }

    static int findSmallest(int[] arr, int k, int size) {
        PriorityQueue<Integer> maxh = new PriorityQueue<Integer>(new CustomComparator());//max heap

        for (Integer i = 0; i < arr.length; i++) {
            maxh.offer(arr[i]);//add

            if(maxh.size() > k) {
                maxh.poll();//pop
            }
        }
        System.out.printf("heap is" +maxh);
        return maxh.peek();
    }

    static int findLargest(int[] arr, int k, int size) {
        PriorityQueue<Integer> minh = new PriorityQueue<Integer>();//default min heap --> min will be on top and max will be on bottom

        for (Integer i = 0; i < arr.length; i++) {
            minh.offer(arr[i]);//add

            if(minh.size() > k) {
                minh.poll();//pop
            }
        }
        System.out.printf("heap is" +minh);
        return minh.peek();
    }
}

class CustomComparator implements Comparator<Integer> {
 
    @Override
    public int compare(Integer number1, Integer number2) {
        int value =  number1.compareTo(number2);
       
        // elements are sorted in reverse order
        if (value > 0) {
            return -1;
        }
        else if (value < 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}