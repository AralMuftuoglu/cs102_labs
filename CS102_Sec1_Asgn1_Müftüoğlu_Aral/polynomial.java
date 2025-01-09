/**
*20.02.24 
*author@ aralmuftuoglu
*polynomial class
*/
package CS102_Sec1_Asgn1_Müftüoğlu_Aral;

import java.lang.Math;

public class polynomial {

    //instance variables
    private double coefficients[];
    private int powers[];
    private int number_of_terms;

    //first constructor
    public polynomial(int a, double b) {
        
        this.coefficients = new double[a+1];
        this.powers = new int[a+1];
        this.number_of_terms = a+1;

        for(int i=0;i<this.number_of_terms-1;i++)
        {
            this.coefficients[i]=0;
            this.powers[i]=0;
        }

        this.powers[a]=a;
        this.coefficients[a]=b;
    }

    //second constructor
    public polynomial(double new_coefficients[]) {
        
        this.coefficients = new_coefficients;
        this.number_of_terms = new_coefficients.length;
        this.powers = new int[this.number_of_terms];
        
        for(int i=0;i<this.number_of_terms;i++)
        {
            this.powers[i]=i;
        }
    }

    // getter methods
    public int getNumberOfTerms() 
    {
        return this.number_of_terms;
    }
    public double[] getCoefficients() 
    {
        return this.coefficients;
    }

    public int[] getPowers() 
    {
        return this.powers;
    }

    // get coefficient method
    public double getCoefficient(int a) {
        
        int current_term = 0;

        for (int i = 0; i < this.coefficients.length; i++) {
            if (this.powers[i] == a) {
                current_term = i;
            }
        }

        return this.coefficients[current_term];
    }

    // get degree method
    public int getDegree() {
        
        int max_power = 0;

        for (int i = 0; i < this.powers.length; i++) {
            if (this.powers[i] > max_power) {
                max_power = this.powers[i];
            }
        }

        return max_power;
    }

    //toString method
    public String toStringOutput() {

        int number_of_term = this.coefficients.length;

        String output_string = "";

        for (int i = 0; i < number_of_term; i++) {
            if (this.coefficients[i] != 0) {

                if (this.powers[i]!= 0 && this.coefficients[i] > 0 && i == 0) 
                {
                    output_string = output_string + this.coefficients[i] + "x^" + this.powers[i] + " ";
                } 
                else if(this.powers[i]==0 && this.coefficients[i]>0 && i==0)
                {
                    output_string=output_string+this.coefficients[i]+ " ";
                }
                else if (this.powers[i] != 0 && this.coefficients[i] < 0 && i == 0) 
                {
                    output_string = output_string + this.coefficients[i] + "x^" +this.powers[i] + " ";
                } 
                else if (this.powers[i] != 0 && this.coefficients[i]> 0) 
                {
                    output_string = output_string + "+" +this.coefficients[i] + "x^" + this.powers[i] + " ";
                } 
                else if (this.powers[i] != 0 && this.coefficients[i] < 0) 
                {
                    output_string = output_string +this.coefficients[i] + "x^" +this.powers[i] + " ";
                } 
                else 
                {
                    output_string = output_string + "+ " + this.coefficients[i] + "";
                }
            }
        }

        return output_string;
    }

    //eval_1 method
    public double eval(double x)
    {
        double total=0;
        
        int number_of_term=this.coefficients.length;


        for(int i=0;i<number_of_term;i++)
        {
            total=total + Math.pow(x, this.powers[i])*this.coefficients[i];
        }
    
        return total;
    }

    //eval_2 method
    public double eval2(double x)
    {
        double total=coefficients[number_of_terms-1];

        for(int i=this.number_of_terms-2;i>=0;i--)
        {
            total=total*x+this.coefficients[i];
        }
        
        return total;
    }   
}
