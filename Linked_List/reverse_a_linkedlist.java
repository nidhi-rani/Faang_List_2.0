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
  //1st way
  /*  public static ListNode reverse(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode backup=curr.next;
            curr.next=prev;
            prev=curr;
            curr=backup;
        }
        head=prev;
        return head;
    }*/
    //2nd way
    static ListNode tailnode=null;
    static ListNode headnode=null;
    public static void addFirst(ListNode temp){
        if(headnode==null){
            tailnode=headnode=temp;
        }else{
            temp.next=headnode;
            headnode=temp;
        }
    }
    public static ListNode reverse(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode curr=head,backup=null;
        while(curr!=null){
           backup=curr.next;
           curr.next=null;
           addFirst(curr);
           curr=backup;
        }
        return headnode;
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

        ListNode head = reverse(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
head = head.next;
        }
        scn.close();
    }
}