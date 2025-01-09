/**
*20.02.24 
*author@ aralmuftuoglu
*PolynomialTester class
*/
package CS102_Sec1_Asgn2_Müftüoğlu_Aral;

public class PolynomialTester {
    
    public static void main (String[]args)
    {
        double [] first_polynomial = {10};//an array for first polynomial

        double [] second_polynomial={10};

        polynomial polynomial_1= new polynomial(first_polynomial);//first polynomial
        
        polynomial polynomial_2= new polynomial(second_polynomial);//second polynomial
    
        System.out.println(polynomial_1.toStringOutput());//test for to string method
       
        System.out.println(polynomial_2.toStringOutput());//test for to string method
        
        System.out.println();
        System.out.println();

        for(int x=0;x<polynomial_1.findEqual(polynomial_2).length;x++)
        {
            System.out.print(polynomial_1.findEqual(polynomial_2)[x]+",");
        }
    
    }   

}
