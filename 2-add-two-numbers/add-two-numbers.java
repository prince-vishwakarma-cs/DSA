class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int carry = 0;
        int total = 0;
        while(l1!=null && l2!=null){
            total = l1.val+l2.val+carry;
            carry = total/10;
            total%=10;
            temp.next=new ListNode(total);
            temp=temp.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l2!=null) {
            total = l2.val+carry;
            carry = total/10;
            total%=10;
            temp.next=new ListNode(total);
            temp=temp.next;
            l2=l2.next;
        }
        while(l1!=null) {
            total = l1.val+carry;
            carry = total/10;
            total%=10;
            temp.next=new ListNode(total);
            temp=temp.next;
            l1=l1.next;
        }
        if(carry>0) temp.next=new ListNode(carry);
        return dummy.next;
    }
}
