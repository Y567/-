/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class 环形链表起始节点 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针找相遇点
        ListNode meet = null;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }else{
                //无环
                return null;
            }
            if(fast == slow){
                meet = fast;
                break;
            }
        }
        //找到meet指针后
        if(meet == null){
            return null;
        }
        //走到这里说明有环
        while(head != null && meet != null){
            //这个必须放在前面
            if(head == meet){
                return meet;
            }
            head = head.next;
            meet = meet.next;
        }
        return null;
    }
}