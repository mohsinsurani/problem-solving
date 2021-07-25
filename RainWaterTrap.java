public class RainWaterTrap {
    public static void main(String[] args) {
        int[] arr = { 3, 0, 0, 2, 0, 4 };
        // Get MXR, Get MXL, Get min(MXR, MXL), width[i] = min(MXR, MXL) - arr, Sigma of Width is the answer

        int[] MXR = new int[arr.length];// Max Right -> Absolute Max (not nearest)
        int[] MXL = new int[arr.length];// MAx left

        MXR[arr.length - 1] = arr[arr.length - 1];
        MXL[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            MXL[i] = Math.max(MXL[i - 1], arr[i]);
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            MXR[i] = Math.max(MXR[i + 1], arr[i]);
        }

        int[] width = new int[arr.length];
        int area = 0;
        for (int i = 0; i < arr.length; i++) {
            width[i] = Math.min(MXL[i], MXR[i]) - arr[i];
            area += width[i];
        }

        System.out.println("Rain Water Trap Area = " + area);
    }
}
