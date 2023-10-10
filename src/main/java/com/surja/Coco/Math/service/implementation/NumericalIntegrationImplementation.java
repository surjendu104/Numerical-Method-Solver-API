package com.surja.Coco.Math.service.implementation;

import com.surja.Coco.Math.service.NumericalIntegrationService;
import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.License;
import org.springframework.stereotype.Service;

@Service
public class NumericalIntegrationImplementation implements NumericalIntegrationService {

    @Override
    public double trapezoidalRule(double a, double b, double n, String expr, double[][] table) {
        if(License.iConfirmCommercialUse("Person 1")==false){
            boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        }
        Function f = new Function("f",expr,"x");
        double h = (b-a)/n;
        double fa = f.calculate(a);
        double fb = f.calculate(b);
        double result = (fa+fb)/2;

        table[0][0] = a; table[0][1] = fa;
        for(int i = 1;i<n;i++) {
            table[i][0] = a+i*h;
            table[i][1] = f.calculate(a+i*h);
            result += table[i][1];
        }
        table[(int)n][0] = b; table[(int)n][1] = fb;
        return h*result;
    }

    @Override
    public double simpsons_one_third_rule(double a, double b, double n, String expr, double[][] table) {
        if(License.iConfirmCommercialUse("Person 1")==false){
            boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        }
        Function f = new Function("f",expr,"x");
        double h = (b-a)/n;
        double fa = f.calculate(a);
        double fb = f.calculate(b);
        double part1 = fa+fb;
        table[0][0] = a; table[0][1] = fa;

        double part2 = 0.0,part3 = 0.0;
        for(int i = 1;i<n;i++) {
            double x = f.calculate(a+i*h);
            if(i%2==1)part2+=x;
            else part3+=x;
            table[i][0] = a+i*h;
            table[i][1] = x;
        }
        table[(int)n][0] = b; table[(int)n][1] = fb;
        return (h/3)*(part1+(4*part2)+(2*part3));
    }

    @Override
    public double simpsons_three_eight_rule(double a, double b, double n, String expr, double[][] table) {
        if(License.iConfirmCommercialUse("Person 1")==false){
            boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        }
        Function f = new Function("f",expr,"x");
        double h = (b-a)/n;
        double fa = f.calculate(a);
        double fb = f.calculate(b);
        double part1 = fa+fb;
        table[0][0] = a; table[0][1] = fa;

        double part2 = 0.0,part3 = 0.0;
        for(int i = 1;i<n;i++) {
            double x = f.calculate(a+i*h);
            if(i%3==0)part2+=x;
            else part3+=x;
            table[i][0] = a+i*h;
            table[i][1] = x;
        }
        table[(int)n][0] = b; table[(int)n][1] = fb;
        return (3*h/8)*(part1+(2*part2)+(3*part3));
    }

    @Override
    public double boolesRule(double a, double b, double n, String expr, double[][] table) {
        if(License.iConfirmCommercialUse("Person 1")==false){
            boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        }
        Function f = new Function("f",expr,"x");
        double h = (b-a)/n;
        double fa = f.calculate(a);
        double fb = f.calculate(b);
        double part1 = 7*(fa+fb);
        table[0][0] = a; table[0][1] = fa;

        double part2 = 0.0,part3 = 0.0,part4 = 0.0;
        for(int i = 1;i<n;i++) {
            double x = f.calculate(a+i*h);
            if(i%4==0) part4+=x;
            else if(i%2==0)part3+=x;
            else part2+=x;
            table[i][0] = a+i*h;
            table[i][1] = x;
        }
        table[(int)n][0] = b; table[(int)n][1] = fb;
        return (2*h/45)*(part1+(32*part2)+(12*part3)+(14*part4));
    }
}
