package dataStructure;


public class PrintListFromLast {
	public ListNode head;
	
	/**
	 * 将结点添加到链表的尾部，从头到尾扫描链表直到链表的最后一个结点， 将新节点放入到此结点的后面
	 * 
	 * @param head链表的头结点指针
	 * @param value要添加的结点的值
	 */
	public void addToTail(ListNode head, int value) {
		ListNode newListNode = new ListNode(value);

		if (head == null) {
			head = newListNode;
		} else {
			ListNode pNode = head;
			while (pNode.next != null) {
				pNode = pNode.next;
			}
			pNode.next = newListNode;
		}
	}
	/**
	 * 删除第一个含有某值的结点
	 * @param head
	 * @param value
	 */
	public void removeNode(ListNode head,int value) {
		if (head == null) {
			return;
		}
		ListNode tobeRemoveNode = null;
		
		if (head.val == value) {
			tobeRemoveNode = head;
			head = head.next;
		}else {
			ListNode pNode = head;
			while (pNode.next!=null && pNode.next.val!=value) {
				pNode = pNode.next;
			}
			if (pNode.next!=null && pNode.next.val == value) {
				tobeRemoveNode = pNode.next;
				pNode.next = pNode.next.next;
			}
		}
	}
	
	/**
	 * 从尾到头打印链表
	 * 面试题6
	 * 递归实现
	 * @param head
	 */
	public void printListReverse(ListNode head) {
		if (head != null) {
			if (head.next != null) {
				printListReverse(head.next);
			}
			System.out.println(head.val);
		}
	}
	/**
	 * 从头到尾打印链表
	 * @param head
	 */
	public void printList(ListNode head) {
		ListNode p = head;
		while (p != null ) {
			System.out.print(p.val+" ");
			p = p.next;
		}
		System.out.println();
	}
	
	/**
	 * 删除链表的结点在O（1）时间内
	 * 面试题18
	 * @param head
	 * @param pToBeDel
	 */
	public void deleteNode(ListNode head,ListNode pToBeDel) {
		if (pToBeDel.next!=null) {
			pToBeDel.val = pToBeDel.next.val;
			pToBeDel.next = pToBeDel.next.next;
		}else if (head == pToBeDel) {//要删除的结点为头结点
			head = null;
		}else {//要删除的结点是最后一个结点
			ListNode pNode = head;
			while (pNode.next != pToBeDel) {
				pNode = pNode.next;	
			}
			pNode.next = null;
		}
	}
	
	/**
	 * 向链表头部添加结点
	 * @param data
	 * @return
	 */
	public ListNode addFirstNode(int data) {
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
		return head;
	}
	/**
	 * 将给定数组放入单链表
	 * @param data
	 * @return返回链表的头结点
	 */
	public ListNode addNodes(int...data) {
		for (int i = data.length-1; i >= 0; i--) {
			ListNode node = new ListNode(data[i]);
			node.next = head;
			head = node;
		}
		return head;
	}
	
	/**
	 * 链表中倒数第k个结点
	 * 面试题22
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode theLastButNNode(ListNode head,int n) {
		if (head == null) {
			return null;
		}
		ListNode p = head;
		ListNode d = head;
		for (int i = 1; i < n; i++) {
			if (p.next != null) {
				p = p.next;
			}else {
				return null;
			}
		}
		while (p.next != null) {
			p = p.next;
			d = d.next;	
		}
		return d;
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintListFromLast plf = new PrintListFromLast();
		int[] nodeval = {1,2,3,4,5,6};
		ListNode head = plf.addNodes(nodeval);
		
		//printListFromLast.removeNode(head, 3);
		plf.printList(head);
		
		System.out.println(plf.theLastButNNode(head, 3).val);
		

	}
}
