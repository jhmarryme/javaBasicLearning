package chapter2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author jhmarryme.cn
 * @date 2019/8/30 16:12
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    }

public class Code6_printListNodeFromTail {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> helpStack = new Stack<Integer>();
        while(listNode != null){
            helpStack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!helpStack.isEmpty()){
            list.add(helpStack.pop());
        }

        return list;
    }
}
