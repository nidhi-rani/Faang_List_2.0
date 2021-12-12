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
        return slow;//tc=O(n)
    }
    public static ListNode reverse(ListNode head){
        ListNode prev=null,curr=head;
        while(curr!=null){
            ListNode backup=curr.next;
            curr.next=prev;
            prev=curr;
            curr=backup;
        }
        return prev;//tc=O(n)
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
            return true;
        }
        ListNode mid=midNode(head);
        ListNode nh=mid.next;mid.next=null;
        nh=reverse(nh);
        ListNode temp=head;
        while(temp!=null&&nh!=null){//or nh!=null,compursory to apply case on nh and optional on temp
           if(temp.val!=nh.val){
                return false;
            }else{
                temp=temp.next;
                nh=nh.next;
            }
        }
        nh=reverse(nh);
        mid.next=nh;
        return true;//tc=O(n)
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
        scn.close();
        System.out.println(isPalindrome(dummy.next));
    }
}