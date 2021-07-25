import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

class closestHeap {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int k = 3;
        Vector<Integer> closestArr = new Vector<Integer>();
        int x = 7;
        PriorityQueue<Pair<Integer, Integer>> maxH = new PriorityQueue<Pair<Integer, Integer>>(new ClosestComparator());

        for (int i = 0; i < arr.length; i++) {
            Pair<Integer, Integer> p = new Pair<Integer,Integer>(Math.abs(arr[i] - x), arr[i]);
            maxH.add(p);

            if(maxH.size() > k) {
                maxH.poll();
            }
        }

        while (maxH.size() > 0) {
            closestArr.addElement(maxH.poll().getSecond());
        }
        System.out.println(closestArr);
    }
}

class ClosestComparator implements Comparator<Pair<Integer, Integer>> {

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