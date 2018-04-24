package dataStructure;

import sun.net.www.content.text.plain;

public class PrintListFromLast {
	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

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
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);

	}
}
