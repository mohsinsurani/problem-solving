
class countSubset {
    public static void main(String args[]) {
        int set[] = {2, 3, 5, 8, 10};
        int sum = 10;
        int n = set.length;
        System.out.println("subset count is "+ getCountSubsetSum(set, n, sum));
    }

    public static int getCountSubsetSum(int[] set, int n, int sum) {
        if (n == 0) return 0;
        if (sum == 0) return 1;

        if (set[n - 1] > sum) {
            return getCountSubsetSum(set, n - 1, sum);
        }

        int a = getCountSubsetSum(set, n - 1, sum);
        int b = getCountSubsetSum(set, n - 1, sum - set[n - 1]);
        return a + b;
    }
}