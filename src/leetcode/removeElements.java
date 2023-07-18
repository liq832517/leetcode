package leetcode;

public class removeElements {
    public static void main(String[] args) {
        removeElements removeElements=new removeElements();

        ListNode h=new ListNode(1);
        h.next=new ListNode(2);
        h.next.next=new ListNode(2);
        h.next.next.next=new ListNode(1);
        h=removeElements.removeElements(h,2);

        while (h!=null){
            System.out.println(h.val);
            h=h.next;
        }

    }

    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        if(head.val==val) return removeElements(head.next,val);

        ListNode temp=head;

        while(temp.next!=null){
            if(temp.next.val==val) {
                remove(temp);
            }else {
                temp=temp.next;
            }
            if(temp.next==null) break;

        }
        return head;
    }

    public void remove(ListNode pre){
        ListNode rm=pre.next;
        if(rm!=null){
            pre.next=rm.next;
        }
    }
}
