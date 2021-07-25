public class miniSubsetDiff {
    public static void main(String args[]) {
        int[] set = { 1, 2, 7 };
        int sum = 10;
        int n = set.length;
        cache = new boolean[set.length + 1][sum + 1];
        /* initialization */
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                cache[i][j] = false;
            }
        }

        /* recursion */
        // isSubsetSum(set, n, sum);
        boolean result = isSubsetSum(set, n, sum);
        System.out.println(result);
        /* print matrix */
        for (int i = cache.length - 2; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                System.out.print(cache[i][j]);
                System.out.println(" " + i + " and " + j);
            }
        }
    }

    static boolean[][] cache;

    public static boolean isSubsetSum(int[] set, int n, int sum) {
        if (cache[n][sum] != false)
            return cache[n][sum];

        // Base Cases
        if (sum == 0)
			return true;
		if (n == 0 || sum < 0)
			return false;
      
        // if (set[n - 1] < sum) {
            boolean a = isSubsetSum(set, n - 1, sum);
            boolean b = isSubsetSum(set, n - 1, sum - set[n - 1]);
            return cache[n][sum] = a || b;
        // } else {
        //     return cache[n][sum] = isSubsetSum(set, n - 1, sum);
        // }
    }

    static boolean isSubsetSumTabular(int set[], int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        boolean subset[][] = new boolean[n + 1][sum + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= sum; i++)
            subset[0][i] = true;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= n; i++)
            subset[i][0] = false;

        // Fill the subset table in botton
        // up manner
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                subset[i][j] = subset[i][j - 1];
                if (j >= set[i - 1])
                    subset[i][j] = subset[i][j] || subset[i - 1][j - set[i - 1]];
            }
        }

        // uncomment this code to print table
        for (int i = n; i <= n; i++) {
            for (int j = 0; j <= sum; j++)
                System.out.println(subset[i][j]);
        }

        return subset[n][sum];
    }
}
