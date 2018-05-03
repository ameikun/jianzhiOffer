package dataStructure;

/**
 * 关于链表的题目
 * 6/18/22/23/24/25/52
 * @author Amei
 *
 */
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
	 * 
	 * @param head
	 * @param value
	 */
	public void removeNode(ListNode head, int value) {
		if (head == null) {
			return;
		}
		ListNode tobeRemoveNode = new ListNode();

		if (head.val == value) {
			tobeRemoveNode = head;
			head = head.next;
		} else {
			ListNode pNode = head;
			while (pNode.next != null && pNode.next.val != value) {
				pNode = pNode.next;
			}
			if (pNode.next != null && pNode.next.val == value) {
				tobeRemoveNode = pNode.next;
				pNode.next = pNode.next.next;
			}
		}
	}

	/**
	 * 从尾到头打印链表 面试题6 递归实现
	 * 
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
	 * 
	 * @param head
	 */
	public void printList(ListNode head) {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.println();
	}

	/**
	 * 删除链表的结点在O（1）时间内 面试题18
	 * 
	 * @param head
	 * @param pToBeDel
	 */
	public void deleteNode(ListNode head, ListNode pToBeDel) {
		if (pToBeDel.next != null) {
			pToBeDel.val = pToBeDel.next.val;
			pToBeDel.next = pToBeDel.next.next;
		} else if (head == pToBeDel) {// 要删除的结点为头结点
			head = null;
		} else {// 要删除的结点是最后一个结点
			ListNode pNode = head;
			while (pNode.next != pToBeDel) {
				pNode = pNode.next;
			}
			pNode.next = null;
		}
	}

	/**
	 * 向链表头部添加结点
	 * 
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
	 * 
	 * @param data
	 * @return返回链表的头结点
	 */
	public ListNode addNodes(int... data) {
		for (int i = data.length - 1; i >= 0; i--) {
			ListNode node = new ListNode(data[i]);
			node.next = head;
			head = node;
		}
		return head;
	}

	/**
	 * 链表中倒数第k个结点 面试题22
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode theLastButNNode(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode p = head;
		ListNode d = head;
		for (int i = 1; i < n; i++) {
			if (p.next != null) {
				p = p.next;
			} else {
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
	 * 反转链表
	 * 面试题24
	 * @param head
	 * @return返回反转后链表的头节点
	 */
	public ListNode reverseList(ListNode head) {
		ListNode resverseHead = null;
		ListNode p = head;
		ListNode pre = new ListNode();
		while (p != null) {
			ListNode pnext = p.next;
			if (pnext == null) {
				resverseHead = p;
			}
			p.next = pre;

			pre = p;
			p = pnext;
		}
		return resverseHead;
	}

	/**
	 * 合并两个排序的链表 
	 * 输入两个递增的排序链表，合并这两个链表并使新链表中的结点仍然是递增排序的
	 * 面试题25
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode mergeSortedList(ListNode head1, ListNode head2) {
		if (head1 == null) {
			return head2;
		}
		else if (head2 == null) {
			return head1;
		}

		ListNode head = new ListNode();
		if (head1.val < head2.val) {
			head.val  = head1.val;
			head.next = mergeSortedList(head1.next, head2);
		} else {
			head.val = head2.val;
			head.next = mergeSortedList(head1, head2.next);
		}
		return head;
	}
	
	/**
	 * 面试题52
	 * 两个链表的第一个公共节点
	 * 如果两个单向链表有公共节点，那么这两个链表从某一节点开始，
	 * 它们的next都指向同一个节点，即之后的所有节点都是重合的，不可能再出现交叉
	 * @param head1
	 * @param head2
	 * @return
	 */
	public ListNode findFirstCommentNode(ListNode head1,ListNode head2) {
		int len1 = getListLength(head1);//链表1的长度
		int len2 = getListLength(head2);//链表2的长度
		int lenDif = len1 - len2;
		
		ListNode headL = head1;
		ListNode headS = head2;
		
		if (len2 > len1) {
			lenDif = len2 - len1;
			headL = head2;
			headS = head1;
		}
		//现在长的链表上走lenDif步
		for (int i = 0; i < lenDif; i++) {
			headL = headL.next;
		}
		while ((headL!=null) && (headS!=null) && (headL!=headS)) {
			headL = headL.next;
			headS = headS.next;
		}	
		return headL;
	}
	/**
	 * 链表的长度
	 * @param head
	 * @return
	 */
	public int getListLength(ListNode node) {
		int len = 0;
		ListNode t = node;
		while (t != null) {
			++len;
			t = t.next;
		}
		return len;
	}
	
	/**
	 * 链表中是否存在环
	 * 在链表中存在环的前提是找到一快一慢两个指针相遇的结点
	 * @param first
	 * @return
	 */
	public ListNode meetingNode(ListNode first) {
		if (first == null) {
			return null;
		}
		ListNode pSlow = first.next;
		if (pSlow == null) {
			return null;
		}
		ListNode pFast = pSlow.next;
		while (pFast != null && pSlow!=null) {
			if (pFast == pSlow) {
				return pFast;
			}
			pSlow = pSlow.next;//移动一步
			pFast = pFast.next;
			if (pFast != null) {
				pFast = pFast.next;//移动两步
			}
		}
		return null;
	}
	/**
	 * 链表中环的入口
	 * 面试题23
	 * @param pNode
	 * @return
	 */
	ListNode entryNodeOfLoop(ListNode pNode){
		ListNode meet = meetingNode(pNode);
		if (meet == null) {
			System.err.println("链表中不存在环！");
			return null;
		}
		int count = 1;
		ListNode t = meet;
		while (t.next != meet) {
			count++;
			t = t.next;
		}
		System.out.println("环中结点数为："+count);
		/**先移动t，次数为环中结点的数目*/
		t = pNode;
		for (int i = 0; i < count; i++) 
			t = t.next;
		/**再移动t和t2*/
		ListNode t2 = pNode;
		while (t != t2) {
			t = t.next;
			t2 = t2.next;
		}
		return t;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintListFromLast plf = new PrintListFromLast();

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		
		l1.next = l3;
		l3.next = l5;
		l5.next = l7;
		l7.next = l2;
		l2.next = l5;

		System.out.println(plf.entryNodeOfLoop(l1).val);
		//System.out.println(plf.findFirstCommentNode(l1, l5).val);	
	}
}
