/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce202;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author vojtech.holcman.s
 */
public class FileTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Zadejte jmeno souboru: ");
            String name = null;
            try{
                name = sc.nextLine();
                String line = firstLine(name);
                System.out.println("Prvni radek: " + line);
                return;
            } catch(FileNotFoundException ex){
                System.out.println("soubor" + name + "nebyl nalezen");
            } catch(IOException ex){
                System.out.println("soubor" + name + "nebyl nalezen");
            }
        }
    }
    public static String firstLine(String fileName)throws FileNotFoundException, IOException{
        // jeste neco, nezavira atd....
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        return br.readLine();
    }
    public static String safeFirstLine(String fileName){
        try{
            return firstLine(fileName);
        } catch (IOException ex){
           throw new IllegalArgumentException("se souborem " + fileName + "nelze pracovat", ex);
        }
    }
}
