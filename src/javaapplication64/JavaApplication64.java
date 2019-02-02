
package javaapplication64;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Dawid
 */







public class JavaApplication64  {
    
    
    
    public static String WE(String plik) throws FileNotFoundException, IOException/// WEJSCIE
    {
     String wyjscie="";
     FileReader fileReader = new FileReader(plik);
     BufferedReader bufferedReader = new BufferedReader(fileReader);
     try 
     {
      String textLine = bufferedReader.readLine();
      wyjscie+=textLine;             
      while (textLine != null)
      {      
         textLine = bufferedReader.readLine();
         wyjscie+=textLine;
      }       
      
     } 
     finally 
     {
      bufferedReader.close();    
     } 
     wyjscie=wyjscie.substring(0,wyjscie.length()-4);
     return wyjscie;
    }
    
   
    public static void main(String[] args) throws FileNotFoundException ,IOException  {

    String wejscie1= WE("panstwo-kraj-stolica.txt");
    String wejscie2= WE("stolica-panstwo.txt");
    Scanner scan = new Scanner(System.in);
    String choice;
    Scanner scan2 = new Scanner(System.in);
    String stolica;  
    Scanner scan3 = new Scanner(System.in);
    String kraj;  
    Scanner scan4 = new Scanner(System.in);
    String kraj2;
     
     
     System.out.println("1 - Znajdz panstwo, ktorego wpisane miasto jest stolica.");
     System.out.println("2 - Wyswietl nazwę kontynentu na ktorym lezy kraj.");
     System.out.println("3 - Znajdz stolice wpisanego panstwa");
     System.out.println("q - Wyjscie");

     

     
     do {
      choice = scan.nextLine(); 
      switch (choice){
       case "1":
             System.out.println("Wpisz nazwe stolicy: ");
             stolica = scan2.nextLine();
             Wnioskowanie x = new Wnioskowanie(stolica,wejscie1);
             System.out.println(x.run());      
        break;
       case "2":
             System.out.println("Wpisz nazwe kraju: ");
             kraj = scan3.nextLine();
             Wnioskowanie x2 = new Wnioskowanie(kraj,wejscie1);
             System.out.println(x2.run()); 
        break;
       case "3":
           System.out.println("Wpisz nazwe kraju: ");
             kraj2= scan4.nextLine();
             Wnioskowanie x3 = new Wnioskowanie(kraj2,wejscie2);
             System.out.println(x3.run());

        break;
       case "?":
             System.out.println("1 - Znajdz panstwo, ktorego wpisane miasto jest stolica.");
             System.out.println("2 - Wyswietl nazwę kontynentu na ktorym lezy kraj.");
             System.out.println("3 - Znajdz stolice wpisanego panstwa");
             System.out.println("q - Wyjscie");
        break;
       default:
             
               
  
      }     
      }while (!choice.equals("q"));
     
 
     

    }
    
}
