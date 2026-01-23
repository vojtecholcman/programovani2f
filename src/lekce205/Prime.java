/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

/**
 *
 * @author vojtech.holcman.s
 */
public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime4(25));
        long c = 0;
        for(long i = 0; i <= 1000000; i++){
            if(isPrime4(i)){
                c++;
                System.out.println(i);
            }
            //porovnavani dvou method isPrime()
//            if(isPrime(i) != isPrime4(i)){
//                System.out.println(i);
//            }
        }
        System.out.println(c);
    }
    public static boolean isPrime(long n){
        if(n<2){
            return false;
        }
        boolean isPrime = true;
        for(long i = 2; i < n; i++){
            if(n % i == 0)
                isPrime = false;
        }
        return isPrime;
    }
    public static boolean isPrime2(long n){
        if(n==2){
            return true;
        }
        if(n<2 || n%2==0){
            return false;
        }
        boolean isPrime = true;
        for(long i = 3; i < n; i+=2){
            if(n % i == 0)
                isPrime = false;
        }
        return isPrime;
    }
    public static boolean isPrime3(long n){
        if(n==2){
            return true;
        }
        if(n<2 || n%2==0){
            return false;
        }
        for(long i = 3; i < n; i+=2){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public static boolean isPrime4(long n){
        if(n==2){
            return true;
        }
        if(n<2 || n%2==0){
            return false;
        }
        for(long i = 3; i <= Math.sqrt(n); i+=2){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
