package efficiency5;

/**
 * 面试题42
 * 连续子数组的最大和*/
public class FindMaxSumofArray42 {
	public int MaxSumofSubArray(int[] array) {
		if (array.length<=0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (sum <= 0)
				sum = array[i];
			else
				sum = sum + array[i];
			if (max < sum)
				max = sum;
		}
		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMaxSumofArray42 maxSumofArray = new FindMaxSumofArray42();
		int[] array = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(maxSumofArray.MaxSumofSubArray(array));
	}

}
