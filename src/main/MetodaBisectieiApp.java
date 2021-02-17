package main;

import java.util.Scanner;

public class MetodaBisectieiApp {

	public static void main(String[] args) {
		
		//Program Java pentru implementarea metodei injumatatirii
		//pentru rezolvarea ecuațiilor algebrice
		
	    @SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
	    
	    double intervalBegin;
	    double intervalEnd;
	    double middle = 0;
	    double precision;
	    
	    //Datele intervalului si preciziei
	    System.out.print("Introduceti inceputul intervalului : ");    
	    intervalBegin = reader.nextDouble();
	    
	    System.out.print("Introduceti sfirsitul itervalului : ");    
	    intervalEnd = reader.nextDouble();
	    
	    System.out.print("Introduceti precizia metodei : ");    
	    precision = reader.nextDouble();
	    
	   //Tipărim rădăcina func (x) cu eroare EPSILON 
	    if(Function(intervalBegin) * Function(intervalEnd) > 0.0D) { 
	      System.out.println("Interval invalid !");
	      return;
	    }
	    
	    while(Math.abs(intervalBegin - intervalEnd) > precision) {
	      middle = (intervalBegin + intervalEnd) / 2.0D;
	      
	      System.out.println("X: " + middle);
	      
	      if(Function(intervalBegin) * Function(middle) < 0.0D) {
	        intervalEnd = middle;
	     } else {
	        intervalBegin = middle;
	      }
	      
	    }
	    
	    // imprimăm valoarea c până la 4 zecimale
	    System.out.printf("Valoarea rădăcinii este  : %.4f",middle);

	}
	//Un exemplu de funcție a cărui soluție este determinată folosind
	// Metoda de bisectare. Funcția este x^3 + 3x - 2 
	static double Function(double x) { 
	     return x*x*x + 3*x - 2; 
	 } 

}

