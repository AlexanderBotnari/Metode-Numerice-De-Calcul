package main;

public class MetodaMixtaApp {
	
   public static void main(String[] args) {
		
		float a,b,c,t,e;
	    
	    a=0; b=0.66f; //interval
	    e=0.01f;//precizie
	    
	    if (f(a)*fd2(a)>0) {  
	    	t=b; c=a;
	    }else {
	    	t=a; c=b;
	    }
		
	    while(Math.abs(t-c)>e) {//|t-c|>e
	    	t=t-(f(t)/fd1(t));
	    	c=c-(f(c))/(f(t)-f(c))*(t-c); 
	    	System.out.println("t= "+t+" f(t)= "+f(t)+" c= "+c+" f(c)= "+f(c));	//afisarea valorilor
	    }
	    
    	System.out.println("Solutie >> "+(t+c)/2); //afisarea solutiei
	    
	}
	
   //functia x^3+3x-2
	static float f(float x){
	     return x*x*x + 3*x - 2;
	}

	//functia prima derivata(3x^2-3)
	static float fd1(float x){
	     return 3*x*x-3;
	}
	
	//a doua derivata(6x)
	static float fd2(float x){
	     return 6*x;
	}

}
