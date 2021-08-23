package com.vikydroid.mylib.oldIntel.practice.practice5.ll;

public class LLOperations {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.head = new Node<>(1);
        list.head.next = new Node<>(2);
        list.head.next.next = new Node<>(3);
        list.head.next.next.next = new Node<>(4);
//        list.head.next.next.next.next = new Node<>(5);
//        list.head.next.next.next.next.next = list.head.next;
        System.out.println(list);
        list = list.rearrange(list);
        System.out.println(list);

//        list.head = list.reverseLL(list.head);
//        System.out.println(list);

//        System.out.println(list.isPalindrome(list));
//        System.out.println(list);


//        LinkedList<Integer> lla = new LinkedList<>(), llb = new LinkedList<>();
//        for (int i = 1; i < 9; i++) {
//            lla.add(new Node<>(i));
//        }
//        System.out.println(lla);
//        llb.head = lla.reverseInGroup2(lla.head, 5, llb);
//        System.out.println(llb);
    }


}
