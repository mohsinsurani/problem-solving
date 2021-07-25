import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Vector;

class KFrequentHeap {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 2, 2, 4};
        int k = 2;
        kSortFrequent(arr, k);
        kSortFrequentArrays(arr);
    }

    static void kSortFrequentArrays(int[] arr) {

        HashMap<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> maxH = new PriorityQueue<>(new MinFirstComparator());
        Vector<Integer> closestArr = new Vector<Integer>();

        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1); //storing frequences
        }

        for (Map.Entry<Integer,Integer> mapVal : mp.entrySet()) {
            Pair<Integer, Integer> p = new Pair<Integer,Integer>(mapVal.getValue(), mapVal.getKey());
            maxH.add(p);
        }

        while (maxH.size() > 0) {
            closestArr.addElement(maxH.poll().getSecond());
        }

        System.out.println(closestArr); 
    }

    static void kSortFrequent(int[] arr, int k) {

        HashMap<Integer,Integer> mp = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> minH = new PriorityQueue<>(new MaxFirstComparator());
        Vector<Integer> closestArr = new Vector<Integer>();

        for (int i = 0; i < arr.length; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1); //storing frequences
        }

        for (Map.Entry<Integer,Integer> mapVal : mp.entrySet()) {
            Pair<Integer, Integer> p = new Pair<Integer,Integer>(mapVal.getValue(), mapVal.getKey());
            minH.add(p);

            if (minH.size() > k) {
                minH.poll();
            }
        }

        while (minH.size() > 0) {
            closestArr.addElement(minH.poll().getSecond());
        }

        System.out.println(closestArr);   
    }
}

class MaxFirstComparator implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> number1, Pair<Integer, Integer> number2) {
        int value =  number1.getFirst().compareTo(number2.getFirst());

        // elements are sorted in reverse order
        if (value > 0) {
            return 1;
        }
        else if (value < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

class MinFirstComparator implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> number1, Pair<Integer, Integer> number2) {
        int value =  number1.getFirst().compareTo(number2.getFirst());

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