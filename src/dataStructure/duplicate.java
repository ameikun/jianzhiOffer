package dataStructure;

/**
 * 数组中重复的数字 在一个长度为n的数组中所有的数字都在0——n-1的范围内。 请找出数组中任意一个重复的数字 时间复杂度为O(n) 空间复杂度为O(1)
 */
public class duplicate {
	/** 修改了原数组 */
	public static boolean isExitDuplicate(int[] number) {
		int len = number.length;
		if (number == null || len <= 0) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			if (number[i] < 0 || number[i] >= len) {// 长度为n的数组中所有的数字都在0——n-1的范围内
				return false;// 如果不在范围内说明数组不合法
			}
		}
		for (int i = 0; i < len; i++) {
			while (number[i] != i) {
				/** 如果数字m不在number[m]位置，但是数字m与number[m]位置的数字相等，则说明数字重复 */
				if (number[i] == number[number[i]]) {
					System.out.println("找到重复的数字：" + number[i]);
					return true;
				}
				/** 如果数字m不在number[m]位置，将其与number[m]位置的数字交换 */
				int temp = number[i];
				number[i] = number[temp];
				number[temp] = temp;
			}
		}
		return false;
	}

	/**
	 * 不能修改原数组，找出重复的数字 长度为n+1的数组里面所有的数字都在1——n范围内
	 * 方案一：创建一个长度为n+1的辅助数组，这样需要O（n）的辅助空间；
	 * 方案二：如果没有重复的数字，那么在1-n的范围内只有n个数字，如果数组里面包含超过n个数字，
	 * 则一定存在重复的数字。使用二分法时间复杂度为O(nlogn)
	 * */
	public static int isExitDuplicateNoModify(int[] number) {
		int len = number.length;
		if (number == null || len <= 0) {
			return -1;
		}
		int start = 1;
		int end = len - 1;
		
		while (start <= end) {
			int middle = ((end - start) >> 1) + start;
			int count = countRange(number, len, start, middle);
			if (start == end) {
				if (count > 1)
					return start;
				else
					break;
			}
			if (count > (middle - start + 1))
				end = middle;
			else
				start = middle + 1;
		}
		
		return -1;
	}

	public static int countRange(int[] number, int length, int start, int end) {
		if (number == null) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < length; i++)
			if (number[i] >= start && number[i] <= end)
				count++;
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] number = { 2, 3, 1, 0, 2, 5, 3 };
		System.out.println(isExitDuplicate(number));
		
		int[] numberx = {2,3,5,4,3,2,6,7};
		System.out.println(isExitDuplicateNoModify(numberx));

	}

}
