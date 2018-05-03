package treeAndBinaryTree;


public class BinaryTreeNode {
	int value;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
	
	BinaryTreeNode parentNode;//父节点

	/**空构造函数*/
	public BinaryTreeNode() {
	}

	/**
	 * 带参构造函数
	 * @param value
	 * @param leftNode
	 * @param rightNode
	 */
	public BinaryTreeNode(int value, BinaryTreeNode leftNode,
			BinaryTreeNode rightNode) {
		super();
		this.value = value;
		this.leftNode = leftNode;
		this.rightNode = rightNode;
	}
	
	public BinaryTreeNode(int value) {
		super();
		this.value = value;
	}
}
