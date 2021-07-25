import java.util.AbstractMap;
import java.util.Map;
import java.util.Stack;

public class MaxAreaHisto {
    public static void main(String[] args) {
        int[] arr = { 6, 2, 5, 4, 5, 1, 6 };

        System.out.println("MAX Area of Historgram is " + getMaxFro(0, getArea(arr)));

        System.out.println("MAX Area of Rectangle in Binary Matrix " + getMaxAreaInBinaryMatrix());
    }

    static int getMaxAreaInBinaryMatrix() {

        int b[][] = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }};
        //breaking 2d array -> 1d array
        //get MAH for each 1 d array -> get Max
        int rowLen = b.length;
        int columnLen = b[0].length;

        int[] v = new int[rowLen];
        for (int j = 0; j < columnLen; j++) {
            v[j] = b[0][j];
        }

        int max = getMaxFro(0, v);

        for (int i = 1; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                if (b[i][j] == 0)
                    v[j] = 0; // graph tile will be avoided if 0
                else
                    v[j] = v[j] + b[i][j]; // add row wise
            }
            max = getMaxFro(max, getArea(v));
        }
        return max;
    }

    static int[] getArea(int[] arr) {
        // MaxArea = Max(Area), Area = Height * width, Height array is given, width not
        // width = NSR - NSL - 1
        // get NSR and NSL (indexes)
        int[] NSR = getNSR(arr);
        int[] NSL = getNSL(arr);

        int[] width = new int[arr.length];
        int[] area = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            width[i] = NSR[i] - NSL[i] - 1;// calculate width
            area[i] = width[i] * arr[i];// calculate area
        }

        return area;
    }

    static int getMaxFro(int max, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    static int[] getNSR(int[] arr) {
        Stack<Map.Entry<Integer, Integer>> s = new Stack<>();
        // key --> Val, Val --> index
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!s.empty()) {
                while (!s.empty() && s.peek().getKey() >= arr[i]) {
                    s.pop();
                }
            }
            if (s.empty()) {
                result[i] = arr.length; // pseudo index
            } else {
                result[i] = s.peek().getValue();
            }

            Map.Entry<Integer, Integer> entry = new AbstractMap.SimpleImmutableEntry<>(arr[i], i);
            s.push(entry);
        }

        return result;
    }

    static int[] getNSL(int[] arr) {
        Stack<Map.Entry<Integer, Integer>> s = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i <= arr.length - 1; i++) {
            if (!s.empty()) {
                while (!s.empty() && s.peek().getKey() >= arr[i]) {
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
        return result;
    }
}
