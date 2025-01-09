/**
*20.02.24 
*author@ aralmuftuoglu
*PolynomialTester class
*/
package CS102_Sec1_Asgn1_Müftüoğlu_Aral;

public class PolynomialTester {
    
    public static void main (String[]args)
    {
        double [] first_polynomial = {2,3,2,4,1};//an array for first polynomial

        polynomial polynomial_1= new polynomial(first_polynomial);//first polynomial
        
        polynomial polynomial_2= new polynomial(2,3);//second polynomial
    
        System.out.println(polynomial_1.toStringOutput());//test for to string method
        
        System.out.println(polynomial_1.eval(2));//test for eval method
        System.out.println(polynomial_1.eval2(2));//test for eval2 method
    
        System.out.println(polynomial_1.getDegree());//test for get degree method
        System.out.println(polynomial_1.getCoefficient(3));//test for get coefficient method
       
        System.out.println(polynomial_2.toStringOutput());//test for to string method
    
        System.out.println(polynomial_2.getDegree());//test for get degree method
        System.out.println(polynomial_2.eval(2));//test for eval method
        System.out.println(polynomial_2.eval2(2));//test for eval2 method

    }

}
