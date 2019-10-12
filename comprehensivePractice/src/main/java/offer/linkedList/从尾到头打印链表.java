package offer.linkedList;

import java.util.ArrayList;

/**
 * @author jhmarryme.cn
 * @date 2019/9/6 13:27
 */
public class 从尾到头打印链表 {
    ArrayList<Integer> res = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            res.add(listNode.val);
        }

        return res;
    }
}
