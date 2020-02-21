package com.kouyy.training.algorithm.dataStructure;

import java.util.Stack;

/**
 * java实现两个栈实现一个队列的功能
 * @author kouyy
 */
public class Stack2Queue<E> {

    public Stack2Queue() {
    }

    /**
     * stack1作为乘放元素的容器
     */
    private Stack<E> stack1=new Stack<E>();
    /**
     * stack2作为倾倒元素的容器
     */
    private Stack<E> stack2=new Stack<E>();

    /**
     * 入队
     */
    public synchronized void pushE(E e){
        //将元素push到队列的前提是Stack2为空,如果不为空，将stack2元素依次弹入stack1
        if(!stack2.empty()){
            while (!stack2.empty()){
                E pop = stack2.pop();
                stack1.push(pop);
            }
        }
        stack1.push(e);
    }



    /**
     * 出队
     */
    public  synchronized  E getE() throws Exception {
        //先将stack1中元素全部倒入stack2,再从stack2弹栈
        if(stack1.empty()&&stack2.empty()){
            throw new Exception("栈为空");
        }

        while(!stack1.empty()){
            E pop = stack1.pop();
            stack2.push(pop);
        }

        E pop = stack2.pop();

        //stack2弹栈之后再将stack2元素倒入stack1
        while (!stack2.empty()){
            E e =stack2.pop();
            stack1.push(e);
        }

        return pop;
    }


}
