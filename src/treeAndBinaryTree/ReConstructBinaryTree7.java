package treeAndBinaryTree;

/**
 * 面试题7：重构二叉树 题目：输入某二叉树的前序遍历和中序遍历的结果， 请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建出下图的二叉树并输出他的根节点。
 */
public class ReConstructBinaryTree7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };// 前序遍历序列
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };// 中序遍历序列
		BinaryTreeNode rootNode = construct(preOrder, inOrder);
		preOrderPrint(rootNode);
		midOrderPrint(rootNode);
	}

	/**
	 * 判断输入的合法性
	 * 
	 * @param preOrder
	 * @param inOrder
	 * @return
	 */
	public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {
		if (preOrder == null || inOrder == null || preOrder.length <= 0
				|| preOrder.length != inOrder.length) {
			return null;
		}
		return constructCore(preOrder, 0, preOrder.length - 1, inOrder, 0,
				inOrder.length - 1);
	}

	/**
	 * 
	 * @param preOrder
	 *            前序遍历序列
	 * @param ps
	 *            前序遍历开始位置
	 * @param pe
	 *            前序遍历结束位置
	 * @param inOrder中序遍历序列
	 * @param is
	 *            中序遍历开始位置
	 * @param ie
	 *            中序遍历结束位置
	 * @return
	 */
	public static BinaryTreeNode constructCore(int[] preOrder, int ps, int pe,
			int[] inOrder, int is, int ie) {
		if (pe < ps)
			return null;
		/** 前序遍历的第一个数字是根节点的值 */
		int rootValue = preOrder[ps];

		BinaryTreeNode root = new BinaryTreeNode();
		root.value = rootValue;
		root.leftNode = root.rightNode = null;
		int index = is;
		while (index <= ie && inOrder[index] != rootValue) {
			index++; // index的值为根结点在中序遍历中的下标
		}
		// 如果在整个中序遍历中没有找到根节点说明输入的数据是不合法的
		if (index > ie) {
			throw new RuntimeException("invalid input" + index);
		}

		root.leftNode = constructCore(preOrder, ps + 1, ps + index - is,
				inOrder, is, index - 1);
		root.rightNode = constructCore(preOrder, ps + index - is + 1, pe,
				inOrder, index + 1, ie);

		return root;
	}

	/**
	 * 前序遍历
	 * 
	 * @param root
	 */
	public static void preOrderPrint(BinaryTreeNode root) {
		if (root == null) {
			return;
		} else {
			System.out.print(root.value + " ");
			preOrderPrint(root.leftNode);
			preOrderPrint(root.rightNode);
		}
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void midOrderPrint(BinaryTreeNode root) {
		if (root == null) {
			return;
		} else {
			midOrderPrint(root.leftNode);
			System.out.print(root.value + " ");
			midOrderPrint(root.rightNode);
		}
	}
	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static void postOrderPrint(BinaryTreeNode root) {
		if (root == null) {
			return;
		} else {
			postOrderPrint(root.leftNode);
			postOrderPrint(root.rightNode);
			System.out.print(root.value + " ");
		}
	}

}
