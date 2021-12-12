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
    public static void unfold(ListNode head) {
       if(head==null||head.next==null){
           return ;
       }
       ListNode oprev=head;
       ListNode two=head.next,tprev=two;
       while(tprev!=null&&tprev.next!=null){
           ListNode backup=tprev.next;
           oprev.next=backup;
           tprev.next=backup.next;
           oprev=oprev.next;
           tprev=tprev.next;
       }
       oprev.next=null;
       two=reverse(two);
       oprev.next=two;
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
        unfold(head);
        printList(head);
        scn.close();
    }
}