package reading.nowCoderAlgorithm.chapter4;

/**
 * @author jhmarryme.cn
 * @date 2019/8/9 17:11
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class Test {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode dumy = new ListNode(0);
        dumy = dumy.next;
        ListNode newHead = dumy;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                dumy = new ListNode(p1.val);
                dumy = dumy.next;
                p1 = p1.next;
            } else if(p1.val == p2.val){
                dumy = new ListNode(p1.val);
                dumy = dumy.next;
                dumy = new ListNode(p2.val);
                dumy = dumy.next;
                p1 = p1.next;
                p2 = p2.next;
            } else{
                dumy = new ListNode(p2.val);
                dumy = dumy.next;
                p2 = p2.next;
            }
        }

        while(p1 != null){
            dumy = new ListNode(p1.val);
            p1 = p1.next;
            dumy = dumy.next;
        }
        while(p2 != null){
            dumy = new ListNode(p2.val);
            p2 = p2.next;
            dumy = dumy.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        mergeTwoLists(head1, head2);
    }
}
