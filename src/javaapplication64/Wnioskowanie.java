
package javaapplication64;
import java.util.*;
import java.io.*;
 

 /**
 *
 * @author Dawid
 */
class Wnioskowanie{
public static String wiedza;
public static String problem;
public static ArrayList<String> fakty;
public static ArrayList<String> reguly;
public static ArrayList<Integer> liczba;
public static ArrayList<String> odpowiedz;
 
 
public Wnioskowanie(String problem, String wiedza)
{
	
	fakty  = new ArrayList<String>();
	reguly  = new ArrayList<String>();
	odpowiedz  = new ArrayList<String>();
	liczba  = new ArrayList<Integer>();
	this.wiedza = wiedza;
	this.problem = problem;
	
        String[] podziel = this.wiedza.split(";");
	for (int i=0;i<podziel.length;i++)
        {
 
		if (!podziel[i].contains("=>")) 
			fakty.add(podziel[i]);
		else
                {
			reguly.add(podziel[i]);
			liczba.add(podziel[i].split("&").length);
		}
	}
} 
public String run()
{
	String wyjscie = ""; // sciezka wnioskowania
        String wyjscie2="";
        int j = 0;
	if (forward())
        {
	 wyjscie = "Podaje sciezke: ";
	 for (int i=0;i<odpowiedz.size();i++)
         {
         j=i;
	 wyjscie += odpowiedz.get(i)+", ";// dodawanie do sciezki
         
	 }
         wyjscie2= odpowiedz.get(j);
	 wyjscie += Wnioskowanie.problem;
         
	}
	else
        {
	 wyjscie = "Nie rozpoznaję państwa";
	}
	return wyjscie2;		
}
public boolean forward()
{
            String s,wniosek;
            boolean temp;
            while(!fakty.isEmpty())
            {
	 	s=fakty.remove(0);
		odpowiedz.add(s);	
		for (int i=0;i<reguly.size();i++)
                {
 	          String warunek = reguly.get(i).split("=>")[0];
               	  String[] and = warunek.split("&");
	          if (and.length==1)
		      temp=warunek.equals(s);
	          else
		      temp=Arrays.asList(and).contains(s);                   
                        
		  if (temp)
                  {
			int x = liczba.get(i);	
			liczba.set(i,--x);	
				if (liczba.get(i)==0)
                                {	
					wniosek = reguly.get(i).split("=>")[1];		
					if (wniosek.equals(this.problem))
						return true;
					fakty.add(wniosek);					
				}
			}	
		}
	    }	
	   return false;
}
}
