package reading.nowCoderAlgorithm.chapter3;

/**
 * 判断一个链表是否为回文结构
 *【题目】 给定一个链表的头节点head，请判断该链表是否为回 文结构。
 * 例如： 1->2->1，返回true。 1->2->2->1，返回true。 15->6->15，返回true。 1->2->3，返回false
 * 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂 度达到O(1)
 * @author jhmarryme.cn
 * @date 2019/7/29 14:08
 */
public class Code_11_IsPalindrome {

    public static boolean isPalindrome(Node head){

        if (head == null || head.next == null) {
            return true;
        }
        // 链表逆序用的辅助节点
        Node curNode;
        Node preNode;
        Node nextNode;

        // 快指针和慢指针
        Node fastNode = head;
        Node slowNode = head;

        //找到中点的位置
        while(fastNode.next != null && fastNode.next.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        // 此时慢节点指向的位置就是中点的位置,  可以暂时先不考虑奇偶的问题


        // 中点以后的部分逆序
        // 逆序的主要思路就是 先让首个节点指向空, 作为逆序后的尾结点. 再将这个节点作为前置节点
        // 找到当前节点, 保留当前节点的下一个节点, 再让当前节点指向前置节点, 完成交换, 最后前置节点=当前节点, 当前节点=后一个节点, 继续下一次交换
        // 当前节点为空时逆序完成, 此时当前节点的上一个节点, 也就是前置节点就是逆序后的链表的head节点
        preNode = slowNode;
        curNode = preNode.next;
        preNode.next = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        // 从逆序后的链表首尾开始向中间靠拢, 对比值, 如果有不同的就不是回文链表
        // 因为同时考虑了两个节点不为空, 所以可以不必考虑链表的奇偶性
        // 当为偶时, 左边过来的会先到空
        // 当为奇时, 两边同时到空节点
        Node endHead = preNode;
        Node startHead = head;
        boolean res = true;

        while(endHead != null && startHead != null){
            if (endHead.value != startHead.value){
                res = false;
                break;
            }
            endHead = endHead.next;
            startHead = startHead.next;
        }


        // 将右边的链表再次逆序, 恢复原链表.
        curNode = preNode.next;
        preNode.next = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }



    public static void main(String[] args) {
        Node head = null;
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head));
        printLinkedList(head);
        System.out.println("=========================");
    }
}
