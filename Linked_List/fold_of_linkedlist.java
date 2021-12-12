package Linked_List;

import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode midNode(ListNode head){
        ListNode slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode backup=curr.next;
            curr.next=prev;
            prev=curr;
            curr=backup;
        }
        return prev;
    }
    public static void fold(ListNode head) {
        if(head==null||head.next==null){
            return ;
        }
        ListNode mid=midNode(head);
        ListNode nh=mid.next;
        mid.next=null;
        nh=reverse(nh);
        while(head!=null){
            ListNode temp1=head.next;
            ListNode temp2=nh.next;
            head.next=nh;
            nh.next=temp1;
            head=temp1;
            nh=temp2;
        }
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = dummy.next;
        fold(head);
        printList(head);
        scn.close();
    }
}