// A recursive solution for subset sum
// problem
class GFG {

	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum(int set[],
							   int n, int sum)
	{
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			return isSubsetSum(set, n - 1, sum);

		/* else, check if sum can be obtained
		by any of the following
			(a) including the last element
			(b) excluding the last element */
		boolean a = isSubsetSum(set, n - 1, sum);
		boolean b = isSubsetSum(set, n - 1, sum - set[n - 1]);
		return a || b;
	}

	static boolean[][] cache;
	static boolean isSubsetMemoization(int set[], int n, int sum) {
		if(cache[n][sum] != false ) return cache[n][sum];
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			return cache[n][sum] = isSubsetSum(set, n - 1, sum);

		/* else, check if sum can be obtained
		by any of the following
			(a) including the last element
			(b) excluding the last element */
		boolean a = isSubsetSum(set, n - 1, sum);
		boolean b = isSubsetSum(set, n - 1, sum - set[n - 1]);
		return cache[n][sum] = a || b;
	}

	/* Driver code */
	public static void main(String args[])
	{
		int set[] = { 1,2,3 };
		int sum = 4;
		cache = new boolean[set.length+1][sum+1];
		for(int i =0; i<=set.length; i++) {
			for(int j = 0; j <= sum; j++) {
				cache[i][j] = false;
			}
		}
		int n = set.length;
		if (isSubsetMemoization(set, n, sum) == true)
			System.out.println("Found a subset"
					+ " with given sum");
		else
			System.out.println("No subset with"
					+ " given sum");
					for(int i =0; i<cache.length; i++) {
						for(int j = 0; j < cache[i].length; j++) {
							System.out.println(cache[i][j]);
						}
					}
	}
}
