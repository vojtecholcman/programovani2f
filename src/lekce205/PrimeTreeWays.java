/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

/**
 *
 * @author vojta
 */
public class PrimeTreeWays {
    
    public static int EratosthenesWay(int size){
        if(size<2){
            return 0;
        }
        
        boolean[] sieve = new boolean[size+1];
        sieve[0] = true;
        sieve[1] = true;
        
        int max = (int) Math.sqrt(size);
        
        for (int i = 2; i <= max; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j < size; j += i) {
                    sieve[j] = true;
                }
            }
        }
        int count = 0;
        for(int i=2; i <= size; i++){
            if(!sieve[i]){
                count++;
            }
        }
        return count;
    }
    
    public static int SimpleWay(int size){
        int count = 0;
        
        for(int i = 2; i <= size; i++){
            boolean prime = true;
            
            if(i == 2){
                prime = true;
            } else if(i < 2 || i % 2 == 0){
                prime = false;
            } else{
                for(int n = 3; n <= Math.sqrt(n); n+=2){
                    if(i % n == 0){
                        prime = false;
                        break;
                    }
                }
            }
            if(prime){
                count++;
            }
        }
    
    public static int ThreadsWay(int limit, int threads){
        if (limit < 2) {
            return 0;
        }
        if (threads < 1) {
            threads = 1;
        }
        
        Thread[] t = new Thread[threads];
        
    }
    
}
