/**
*20.02.24 
*author@ aralmuftuoglu
*polynomial class
*/
package CS102_Sec1_Asgn2_Müftüoğlu_Aral;

import java.lang.Math;
import java.util.ArrayList;

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

    //add polynomial method
    public polynomial add(polynomial a)
    {
        polynomial new_polynomial;

        int sizeToSum;

        double[] new_coefficients;

        if(a.number_of_terms>this.number_of_terms)
        {
            sizeToSum=this.number_of_terms;
            
            new_coefficients= new double[a.number_of_terms];

            for(int i=0;i<sizeToSum;i++)
            {
                new_coefficients[i]=a.coefficients[i]+this.coefficients[i];
            }
            for(int x=sizeToSum;x<a.number_of_terms;x++)
            {
                new_coefficients[x]=a.coefficients[x];
            }
            new_polynomial= new polynomial(new_coefficients);

        }
        else
        {
            sizeToSum=a.number_of_terms;
            
            new_coefficients= new double[this.number_of_terms];
            
            for(int i=0;i<sizeToSum;i++)
            {
                new_coefficients[i]=this.coefficients[i]+a.coefficients[i];
            }
            for(int x=sizeToSum;x<this.number_of_terms;x++)
            {
                new_coefficients[x]=this.coefficients[x];
            }

            new_polynomial= new polynomial(new_coefficients);
        }
    
        return new_polynomial;
    }

    //sub polynomial method
    public polynomial sub(polynomial a)
    {
        for(int i=0;i<a.number_of_terms;i++)
        {
            a.coefficients[i]=-a.coefficients[i];
        }
        
        polynomial new_polynomial;

        int sizeToSum;

        double[] new_coefficients;

        if(a.number_of_terms>this.number_of_terms)
        {
            sizeToSum=this.number_of_terms;
            
            new_coefficients= new double[a.number_of_terms];

            for(int i=0;i<sizeToSum;i++)
            {
                new_coefficients[i]=a.coefficients[i]+this.coefficients[i];
            }
            for(int x=sizeToSum;x<a.number_of_terms;x++)
            {
                new_coefficients[x]=a.coefficients[x];
            }
            new_polynomial= new polynomial(new_coefficients);

        }
        else
        {
            sizeToSum=a.number_of_terms;
            
            new_coefficients= new double[this.number_of_terms];
            
            for(int i=0;i<sizeToSum;i++)
            {
                new_coefficients[i]=this.coefficients[i]+a.coefficients[i];
            }
            for(int x=sizeToSum;x<this.number_of_terms;x++)
            {
                new_coefficients[x]=this.coefficients[x];
            }

            new_polynomial= new polynomial(new_coefficients);
        }
    
        return new_polynomial;
    }

    //mul polynomial method
    public polynomial mul(polynomial a)
    {
        polynomial new_polynomial;

        double[] new_coefficients;

        int max_power_1=this.number_of_terms-1;
        int max_power_2=a.number_of_terms-1;
        int new_number_of_terms= max_power_1+max_power_2+1;

        new_coefficients= new double[new_number_of_terms];

        for(int i=0;i<this.number_of_terms;i++)
        {
            for(int m=0;m<a.number_of_terms;m++)
            {
                new_coefficients[i+m]=new_coefficients[i+m]+this.coefficients[i]*a.coefficients[m];
            }
        }
    
        new_polynomial= new polynomial(new_coefficients);

        return new_polynomial;
    }

    //compose polynomial method
    public polynomial compose(polynomial a)
    {
        polynomial  result_polynomial;

        int max_power_1=this.number_of_terms-1;
        int max_power_2=a.number_of_terms-1;

        int new_number_of_terms= max_power_1*max_power_2+1;

        double[] new_coefficients= new double[new_number_of_terms];

        result_polynomial= new polynomial(new_coefficients);
        
        for(int i=0;i<this.number_of_terms;i++)
        {
            int cuurent_power=this.powers[i];
            double current_coefficient=this.coefficients[i];

            polynomial main_coefficent= new polynomial(0,current_coefficient);
            
            polynomial b= new polynomial(0,0);

            for(int x=0;x<cuurent_power;x++)
            {
                if(x==0)
                {
                    b=a;
                }
                else
                {
                    b=b.mul(a);
                }
            
            }
            polynomial new_part=b;

            if(b.coefficients[0]==0)
            {
                new_part=main_coefficent;
            }
            else
            {
                new_part=main_coefficent.mul(new_part);
            }
            
            result_polynomial=result_polynomial.add(new_part);
        }
    
        return result_polynomial;
    }    

    //divide polynomial method
    public polynomial div(polynomial a)
    {
        
        polynomial dividend=this;
        polynomial to_divide;
        
        double[]new_terms=new double[this.number_of_terms-a.number_of_terms];
        polynomial result = new polynomial(new_terms);

        int x= dividend.number_of_terms;
       
        while(x>=a.number_of_terms)
        {
        int max_power_1=x-1;
        double max_coefficient_1=dividend.coefficients[max_power_1];
        
        int max_power_2=a.number_of_terms-1;
        double max_coefficient_2=a.coefficients[max_power_2];


        int new_power= max_power_1-max_power_2;
        double new_coefficient= max_coefficient_1/max_coefficient_2;

        to_divide = new polynomial(new_power, new_coefficient);

        dividend = dividend.sub(to_divide.mul(a));
        x--;

        result=result.add(to_divide);
        }

        return result;
    }

    //find equal method
    public int[] findEqual(polynomial a)
    {
        ArrayList<Integer> equalTerms= new ArrayList<Integer>();

        for(double i=1;i<=200;i++)
        {
            if(this.eval(i)==a.eval(i))
            {
                equalTerms.add((int)i);
            }
        } 
    
        int[]equalTermsToPrint=new int[equalTerms.size()];

        for(int x=0;x<equalTermsToPrint.length;x++)
        {
            equalTermsToPrint[x]=equalTerms.get(x);
        }
    
        return equalTermsToPrint;
    }
}
