package main;

public class MetodaCramerApp {

	public static void main(String[] args) {
		//Varianta 4
		//6*x1 + 2*x2 + 4*x3 = 16
		//2*x1 + 6*x2 + 2*x3 = 2
		//5*x1 + 5*x2 + 3*x3 = 15
		
		// stocarea coeficienților liniari
		// ecuații în matricea coeff 
	    double coeff[][] = {{ 6, 2, 4 ,16},
	                        { 2, 6, 2 ,2},
	                        { 5, 5, 3 ,15}};
	    findSolution(coeff);

	}
	
	// Această funcție găsește determinantul Matrix 
	static double determinantOfMatrix(double mat[][]){
	    double ans;
	    ans = mat[0][0] * (mat[1][1] * mat[2][2] - mat[2][1] * mat[1][2])
	        - mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0])
	        + mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
	    return ans;
	}
	 
	// Această funcție găsește soluția sistemului de
	// ecuații liniare folosind regula lui Cramer 
	static void findSolution(double coeff[][]){
		// Matrix d folosind coeff așa cum este dat în regula lui Cramer
	    double d[][] = {
	        { coeff[0][0], coeff[0][1], coeff[0][2] },
	        { coeff[1][0], coeff[1][1], coeff[1][2] },
	        { coeff[2][0], coeff[2][1], coeff[2][2] },
	    };
	     
	    // Matrix d1 folosind coeff așa cum este dat în regula lui Cramer
	    double d1[][] = {
	        { coeff[0][3], coeff[0][1], coeff[0][2] },
	        { coeff[1][3], coeff[1][1], coeff[1][2] },
	        { coeff[2][3], coeff[2][1], coeff[2][2] },
	    };
	     
	    // Matrix d2 folosind coeff așa cum este dat în regula lui Cramer 
	    double d2[][] = {
	        { coeff[0][0], coeff[0][3], coeff[0][2] },
	        { coeff[1][0], coeff[1][3], coeff[1][2] },
	        { coeff[2][0], coeff[2][3], coeff[2][2] },
	    };
	     
	   // Matrix d3 folosind coeff așa cum este dat în regula lui Cramer 
	    double d3[][] = {
	        { coeff[0][0], coeff[0][1], coeff[0][3] },
	        { coeff[1][0], coeff[1][1], coeff[1][3] },
	        { coeff[2][0], coeff[2][1], coeff[2][3] },
	    };
	 
	    // calculam determinantii matricelor d, d1, d2, d3
	    double D = determinantOfMatrix(d);
	    double D1 = determinantOfMatrix(d1);
	    double D2 = determinantOfMatrix(d2);
	    double D3 = determinantOfMatrix(d3);
	    System.out.printf("D este : %.6f \n", D);
	    System.out.printf("D1 este : %.6f \n", D1);
	    System.out.printf("D2 este : %.6f \n", D2);
	    System.out.printf("D3 este : %.6f \n", D3);
	 
	    // Cazul 1
	    if (D != 0){
	    	// Coeff are o soluție unică. Aplicam regula lui Cramer 
	        double x = D1 / D;
	        double y = D2 / D;
	        double z = D3 / D; 
	        System.out.printf("Valoarea lui x este : %.6f\n", x);
	        System.out.printf("Valoarea lui y este : %.6f\n", y);
	        System.out.printf("Valoarea lui z este : %.6f\n", z);
	    }
	     
	    // Cazul 2
	    else{
	        if (D1 == 0 && D2 == 0 && D3 == 0)
	            System.out.printf("Solutie infinita\n");
	        else if (D1 != 0 || D2 != 0 || D3 != 0)
	            System.out.printf("NU este solutie\n");
	    }
	}

}
