package dataStructure;

/**
 * 单向链表的结点定义
 * @author Amei
 *
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode head;
	

	public ListNode(int val) {
		this.val = val;
	}
	public ListNode(int val,ListNode node) {
		this.val = val;
		this.next = node;
	}
	public ListNode() {}

}
