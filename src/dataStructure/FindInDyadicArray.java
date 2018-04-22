package dataStructure;

/**
 * 在一个二维数组中，每一行都按照从左到右的递增的顺序排序， 
 * 每一列都按照从上到下递增的顺序排序，请查找给定整数是否在数组中 
 * 在二位数组中查找
 */
public class FindInDyadicArray {
	
	public static boolean Find(int[][] matrix, int tar) {
		int row = matrix.length;// 行
		int col;
		if (row > 0)
			col = matrix[0].length; // 列
		else
			return false;// 矩阵为空
		int i = 0;
		int j = col - 1;
		while (i < row && j >= 0) {
			if (matrix[i][j] > tar) {
				j -= 1;
			}else if (matrix[i][j] < tar) {
				i += 1;
			}else {
				return true;
			}
			
		}
		return false;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		System.out.println(Find(nums, 19));
	}

}
