package leetCode;

/**
 * Created by libing on 17/6/13.
 */
public class AddTwoNumbers2 {
    public static void main(String[] args) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
//        int len1 = 0, len2 = 0, longest, i, j;
//        ListNode head1 = l1;
//        ListNode head2 = l2;
//        while(l1 != null){
//            len1++;
//            l1 = l1.next;
//        }
//        while(l2 != null){
//            len2++;
//            l2 = l2.next;
//        }
//        longest = len1 > len2 ? len1 + 1 : len2 + 1;
//        int[] res = new int[longest];
//        int[] res1 = new int[longest - 1];
//        int[] res2 = new int[longest - 1];
//        for(i = 0; i < len1; i++){
//            res1[i] = head1.val;
//            head1 = head1.next;
//        }
//        for(i = 0; i < len2; i++){
//            res2[i] = head2.val;
//            head2 = head2.next;
//        }
//        int carry = 0;
//        for(i = 0; i < longest - 1; i++){
//            res[i] = res1[i] + res2[i] + carry;
//            if(res[i] > 10){
//                res[i] = res[i] % 10;
//                carry = res[i] / 10;
//            }else{carry = 0;}
//        }
//        ListNode head = null;
//        if(carry == 0){
//            head  = new ListNode(res[0]);
//            for(i = 0; i < longest - 2; i++){
//                 new ListNode(res[i]).next = new ListNode(res[i + 1]);
//            }
//        }else{
//            head  = new ListNode(res[0]);
//            for(i = 0; i < longest - 1; i++){
//                new ListNode(res[i]).next = new ListNode(res[i + 1]);
//            }
//        }
        ListNode head = addTwoNumbersCore(l1, l2);
        ListNode preHead = new ListNode(-1), pre;
        preHead.next = head;
        pre = preHead;
        int carry = 0;
        while(head != null){
            head.val += carry;
            if(head.val >= 10){
                carry = head.val / 10;
                head.val %= 10;
            }else{carry = 0;}
            pre = head;
            head = head.next;
        }
        if(carry != 0){
            pre.next = new ListNode(carry);
        }
        return preHead.next;
    }
    public static ListNode addTwoNumbersCore(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(l1.val + l2.val);
        head.next = addTwoNumbersCore(l1.next, l2.next);
        return head;
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){ val = x;}
}