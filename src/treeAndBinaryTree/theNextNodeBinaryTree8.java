package treeAndBinaryTree;
/**面试题8：二叉树的下一个节点
 * 找出中序遍历的下一个节点，树中节点除了有两个分别指向左、右子节点的指针，
 * 还有一个指向父节点的指针*/
public class theNextNodeBinaryTree8 {

	/**
	 * 中序遍历的下一个节点
	 * @param node
	 * @return
	 */
	public static BinaryTreeNode  theNextNodeOfinOrder(BinaryTreeNode node) {
		if (node == null) {
			return null;
		}
		BinaryTreeNode nextNode = new BinaryTreeNode();
		/**如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点*/
		if (node.rightNode != null) {
			BinaryTreeNode pRight = node.rightNode;
			while (pRight.leftNode != null)
				pRight = pRight.leftNode;
			
			nextNode = pRight;
		}
		/**如果一个节点没有右子树，（1）并且它还是父节点的右子节点，那么沿着父节点的指针一直向上遍历，
		 * 直到找到一个是它的父节点的左子节点的结点，这个节点的父节点就是我们要找的下一个节点
		 * （2）如果节点是它父节点的左子节点，那么它的下一个节点就是它的父节点*/
		else if (node.parentNode != null) {
			BinaryTreeNode currentNode = node;
			BinaryTreeNode parentNode = node.parentNode;
			while (parentNode!=null && currentNode == parentNode.rightNode) {
				currentNode = parentNode;
				parentNode = parentNode.parentNode;
			}
			nextNode = parentNode;
		}
		return nextNode;	
	}
	/**
	 * @param args
	 *     		  a
	 *   		/   \
	 *  	   b     c
	 * 		 /	\   / \
	 *      d   e  f   g
	 *         / \
	 *        h   i
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode a = new BinaryTreeNode(1);
		BinaryTreeNode b = new BinaryTreeNode(2);
		BinaryTreeNode c = new BinaryTreeNode(3);
		BinaryTreeNode d = new BinaryTreeNode(4);
		BinaryTreeNode e = new BinaryTreeNode(5);
		BinaryTreeNode f = new BinaryTreeNode(6);
		BinaryTreeNode g = new BinaryTreeNode(7);
		BinaryTreeNode h = new BinaryTreeNode(8);
		BinaryTreeNode i = new BinaryTreeNode(9);
		a.leftNode = b;a.rightNode = c;
		b.leftNode = d;b.rightNode = e;b.parentNode = a;
		c.leftNode = f;c.rightNode = g;c.parentNode = a;
		d.parentNode = b;
		e.leftNode = h;e.rightNode = i;e.parentNode = b;
		f.parentNode = c;
		g.parentNode = c;
		h.parentNode = e;
		i.parentNode = e;
		System.out.println(theNextNodeOfinOrder(d).value);		
		
	}

}
