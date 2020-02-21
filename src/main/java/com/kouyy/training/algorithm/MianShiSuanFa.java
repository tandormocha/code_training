package com.kouyy.training.algorithm;

public class MianShiSuanFa {
    //单向链表
    class Node {
        int val;
        Node next;
        Node(int x) {
            val = x;
            next = null;
        }
    }

    //栈(Stack)
    class Stack{
        Node top;

        public Node peek(){
            if(top != null){
                return top;
            }
            return null;
        }
        public Node pop(){
            if(top == null) {
                return null;
            }else {
                Node temp = new Node(top.val);
                top = top.next;
                return temp;
            }
        }
        public void push(Node n){
            if(n != null){
                n.next = top;
                top = n;
            }
        }
    }

    //队列(Queue)
    class Queue{
        Node first, last;
        //入队
        public void enqueue(Node n){
            if(first == null){
                first = n;
                last = first;
            }else{
                last.next = n;
                last = n;
            }
        }
        //出队
        public Node dequeue(){
            if(first == null){
                return null;
            }else{
                Node temp = new Node(first.val);
                first = first.next;
                return temp;
            }
        }
    }

    //树，堆
    class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }



}
