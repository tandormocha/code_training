package com.kouyy.training.algorithm.mianshi;
//交替打印 奇偶数
public class Test{
    public static void main(String args[]){
        Num num = new Num(0);
    Thread thOdd = new Thread(new ThOdd(num));
    Thread thEdd = new Thread(new ThEdd(num));
        thOdd.setName("odd");
        thEdd.setName("edd");
        thOdd.start();
        thEdd.start();

    }
}

class Num {
    private int num = 0;

    public Num(int num){
        this.num = num ;
    }

    public synchronized void printOdd(){
        System.out.println(Thread.currentThread().getName()+"------->"+(num++));
        try{
            this.notifyAll();//唤醒等待线程
            this.wait();    //唤醒线程释放锁
            Thread.sleep(1000);//唤醒线程休眠1s
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void printEdd(){
        System.out.println(Thread.currentThread().getName()+"------->"+(num++));
        try{
            this.notifyAll();
            this.wait();
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class ThOdd implements Runnable{
    private Num num ;
    public ThOdd(Num num){
        this.num = num ;
    }
    public void run(){
        while(true){
            num.printOdd();
        }
    }
}

class ThEdd implements Runnable{
    private Num num ;
    public ThEdd(Num num){
        this.num = num ;
    }
    public void run(){
        while(true){
            num.printEdd();
        }
    }
}

