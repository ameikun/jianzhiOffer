package treeAndBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题26、27（二叉树的镜像）、28（对称的二叉树）、32（从上到下打印二叉树） 面试题26 树的子结构 输入两个二叉树 A 和 B，判断 B 是不是
 * A 的子结构
 * 
 * @author Amei
 * 
 */
public class HasSubtree26 {

	public static boolean hasSubtree(BinaryTreeNode aRoot, BinaryTreeNode bRoot) {
		boolean result = false;
		if (aRoot != null && bRoot != null) {
			if (Equal(aRoot.value, bRoot.value))
				result = DoesTree1hasTree2(aRoot, bRoot);
			if (!result)
				result = hasSubtree(aRoot.leftNode, bRoot);
			if (!result)
				result = hasSubtree(aRoot.rightNode, bRoot);
		}
		return result;
	}

	public static boolean DoesTree1hasTree2(BinaryTreeNode aRoot,
			BinaryTreeNode bRoot) {
		if (bRoot == null)
			return true;
		if (aRoot == null)
			return false;
		/** 如果结点R的值和树B的根节点不相同，则以R为根节点的子树和树B肯定不具有相同的节点 */
		if (!Equal(aRoot.value, bRoot.value))
			return false;
		/** 如果他们的值相同，则递归的判断它们各自的左右结点的值是不是相同 */
		return DoesTree1hasTree2(aRoot.leftNode, bRoot.leftNode)
				&& DoesTree1hasTree2(aRoot.rightNode, bRoot.rightNode);
	}

	/**
	 * 判断两个小数是否相等，只能判断他们之差的绝对值是不是在一个很小的范围内
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static boolean Equal(double num1, double num2) {
		if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001))
			return true;
		else
			return false;
	}

	/**
	 * 面试题27 输入一颗二叉树，该函数输出它的镜像 8 / \ 6 10 / \ / \ 5 7 9 11 镜像为： 8 / \ 10 6 / \ /
	 * \ 11 9 7 5
	 * 
	 * @param root
	 * @return
	 */
	public static void MirrorRecursively(BinaryTreeNode root) {
		if (root == null)
			return;
		if (root.leftNode == null && root.rightNode == null)
			return;
		BinaryTreeNode temp = root.leftNode;
		root.leftNode = root.rightNode;
		root.rightNode = temp;
		if (root.leftNode != null)
			MirrorRecursively(root.leftNode);
		if (root.rightNode != null)
			MirrorRecursively(root.rightNode);
	}

	/**
	 * 28、对称的二叉树
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetrical(BinaryTreeNode root) {
		return isSymmetrical(root, root);
	}

	public static boolean isSymmetrical(BinaryTreeNode root1,
			BinaryTreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;

		return isSymmetrical(root1.leftNode, root2.rightNode)
				&& isSymmetrical(root1.rightNode, root2.leftNode);
	}

	/**
	 * 面试题32 从上到下打印二叉树 层次遍历
	 * 
	 * @param root
	 */
	private static void printTreeFromTopToBottom(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		if (root == null) {
			return;
		}
		queue.offer(root);
		while (queue.size() != 0) {
			BinaryTreeNode temp = queue.poll();
			System.out.print(temp.value + " ");
			if (temp.leftNode != null)
				queue.offer(temp.leftNode);
			if (temp.rightNode != null)
				queue.offer(temp.rightNode);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode a = new BinaryTreeNode(8);
		BinaryTreeNode b = new BinaryTreeNode(6);
		BinaryTreeNode c = new BinaryTreeNode(10);
		BinaryTreeNode d = new BinaryTreeNode(5);
		BinaryTreeNode e = new BinaryTreeNode(7);
		BinaryTreeNode f = new BinaryTreeNode(9);
		BinaryTreeNode g = new BinaryTreeNode(11);

		a.leftNode = b;
		a.rightNode = c;
		b.leftNode = d;
		b.rightNode = e;
		c.leftNode = f;
		c.rightNode = g;

		printTreeFromTopToBottom(a);
		System.out.println();
		MirrorRecursively(a);
		printTreeFromTopToBottom(a);

	}

}
