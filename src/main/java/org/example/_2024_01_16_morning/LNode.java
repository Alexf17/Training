package org.example._2024_01_16_morning;

public class LNode {
    int x;
    LNode next;

    public LNode(int x) {
        this.x = x;
        this.next = null;
    }

    public static void main(String[] args) {
        LNode n1 = new LNode(1);
        LNode n2 = new LNode(2);
        LNode n3 = new LNode(3);
        LNode n4 = new LNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n4;

        System.out.println(isCyclic(n1));
    }
    public static boolean isCyclic(LNode head) {
        LNode slow = head;
        LNode fast = head.next;
        while(slow!=fast){
            if(slow == null || fast == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
    return true;
    }}