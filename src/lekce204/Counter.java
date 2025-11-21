/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce204;

/**
 *
 * @author vojtech.holcman.s
 */
public class Counter {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        
        Thread[] threads = new Thread[2];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread("thread #" + i){
                @Override
                public void run() {
                    count(c, 10);
                }
                
            };
            threads[i].start();
        }
        for(int i=0; i < threads.length; i++){
            threads[i].join();
        }
        
//        count(c, 1_000_000_000);
//        count(c, 1_000_000_000);
        System.out.println(c.getCounter());
    }
    
    private static void count(Counter c, int count){
        for(int i = 0; i<1_000_000_000; i++){
            System.out.println(Thread.currentThread().getName() + ": " + c.getCounter());
            c.increment();
        }
    }
    
    private int counter = 0;

    public int getCounter() {
        return counter;
    }
    
    public void increment(){
        counter++;
    }
}
