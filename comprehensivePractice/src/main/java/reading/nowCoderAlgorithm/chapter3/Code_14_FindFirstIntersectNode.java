package reading.nowCoderAlgorithm.chapter3;

/**
 * 两个单链表相交的一系列问
 * 在本题中，单链表可能有环，也可能无环。给定两个 单链表的头节点 head1和head2，
 * 这两个链表可能相交，也可能 不相交。请实现一个函数， 如果两个链表相交，请返回相交的 第一个节点；如果不相交，返回null 即可
 * 要求：如果链表1 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外 空间复杂度请达到O(1)。
 * @author jhmarryme.cn
 * @date 2019/7/31 13:45
 */
public class Code_14_FindFirstIntersectNode {


    /**
     * 1. 两个链表根据有环无环分成三种情况
     *      1-1 两个都无环, 可能相交
     *      1-2 两个都有环, 可能相交
     *      1-3 只有一个有环, 不可能相交
     * @param head1
     * @param head2
     * @return
     */
    public static Node getIntersectNode(Node head1, Node head2){

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }


    /**
     * 如果链表有环, 返回环点
     * @param head
     * @return
     */
    public static Node getLoopNode(Node head){
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;

        // 如果存在环点, 快慢指针一定会相遇
        while(slow != fast){
            // 任意一个指针走到空都代表没有环
            if (slow.next == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        // 当快慢指针相遇时, 快指针回到起点, 每次走一步, 再次与慢指针相遇的时候就是环点.
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 如果两个无环链表相交, 返回交点
     * 如果相交, 则是Y字型 根据两个链表长度进行判断
     * 因为是链表相交, 不可能出现X交叉的情况
     * 1. 求出两个链表的长度及长度差
     * 2. 让长链表先走长度差值
     * 3. 长短链表一起走,  如果有交点, 则一定会走到交点. 如果没有, 则一起走到空
     * 4. 返回交点值或null
     * @param head1
     * @param head2
     * @return
     */
    public static Node noLoop(Node head1, Node head2){

        int len = 0;

        Node cur1 = head1;
        Node cur2 = head2;

        //让两个链表都走到尾结点停
        while(cur1.next != null){
            len++;
            cur1 = cur1.next;
        }
        while(cur2.next != null){
            len--;
            cur2 = cur2.next;
        }

        // 两个链表的尾结点如果不是同一个, 代表没有相交
        if (cur1 != cur2){
            return null;
        }

        //选择长度大的作为先走的链表
        cur1 = len > 0 ? head1 : head2;
        cur2 = len > 0 ? head2 : head1;
        len = Math.abs(len);
        while(len-- > 0){
            cur1 = cur1.next;
        }

        // 当两个链表走到空时 或找到交点时退出循环
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return cur1;
    }


    /**
     * 两个有环链表如果相交, 返回交点
     * 1. 分为两种情况
     * 1-1 两个环点相等, 可以视为Y型进行计算
     * 1-2 两个环点不等, 任意选择一个环点绕环一圈, 如果没有碰到另一个环点, 代表没有交点, 碰到的话, 返回任意一个环点都可以作为交点
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
        Node cur1;
        Node cur2;

        // 视作Y字型
        if (loop1 == loop2){
            int len = 0;
            cur1 = head1;
            cur2 = head2;
            while(cur1 != loop1){
                len++;
                cur1 = cur1.next;
            }
            while(cur2 != loop2){
                len--;
                cur2 = cur2.next;
            }

            cur1 = len > 0 ? head1 : head2;
            cur2 = len > 0 ? head2 : head1;
            len = Math.abs(len);

            while(len-- > 0){
                cur1 = cur1.next;
            }

            while(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            // 选择loop1作为起点, 绕环一圈
            cur1 = loop1.next;

            while(cur1 != loop1){
                // 如果走回了环点之前遇到Loop2点, 返回任意一个环点即可
                if (cur1 == loop2){
                    return cur1;
                }
                cur1 = cur1.next;
            }

            // 走了一圈没有碰到, 代表没有交点
            return null;
        }
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}
