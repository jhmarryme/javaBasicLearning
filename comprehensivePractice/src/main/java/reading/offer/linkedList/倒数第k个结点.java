package reading.offer.linkedList;

/**
 * @author jhmarryme.cn
 * @date 2019/9/8 22:53
 */
public class 倒数第k个结点 {
    public ListNode FindKthToTail(ListNode head,int k) {

        if(head == null){
            return head;
        }
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        ListNode fast = dumy;
        while(k-- > 0){
            fast = fast.next;
            if(fast == null){
                return null;
            }
        }

        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
