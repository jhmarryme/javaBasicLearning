package reading.nowCoderAlgorithm.chapter3;

/**
 * 打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 * @author jhmarryme.cn
 * @date 2019/7/29 16:35
 */
public class Code_10_PrintCommonPart {


    /**
     * 利用外排的思路即可
     * @param head1
     * @param head2
     */
    public static void printCommonPart(Node head1, Node head2){
        Node p1 = head1;
        Node p2 = head2;

        while(p1 != null && p2 != null){
            if (p1.value < p2.value){
                p1 = p1.next;
            } else if (p1.value > p2.value){
                p2 = p2.next;
            } else {
                System.out.print(p1.value + " ");
                p1 = p1.next;
                p2 = p2.next;
            }
        }
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
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);
        printCommonPart(node1, node2);
    }
}
