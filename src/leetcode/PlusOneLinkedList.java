package leetcode;

import java.util.List;

public class PlusOneLinkedList {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
    public ListNode plusOne(ListNode head) {
        // Write your code here

        if(head==null)
            return head;
        int count=1;
        ListNode res=head;
        while (head.next!=null){
            head=head.next;count++;
        }
        if(head.val!=9){
            head.val++;return res;
        }
        head=res;
        int []num=new int[count];
        while (head!=null){
            num[--count]=head.val;
            head=head.next;
        }
        return res;
    }

}
