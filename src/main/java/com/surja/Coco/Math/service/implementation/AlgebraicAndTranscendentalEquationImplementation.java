package com.surja.Coco.Math.service.implementation;

import com.surja.Coco.Math.service.AlgebraicAndTranscendentalEquationService;
import org.mariuszgromada.math.mxparser.*;
import org.springframework.stereotype.Service;

@Service
public class AlgebraicAndTranscendentalEquationImplementation implements AlgebraicAndTranscendentalEquationService
{
    @Override
    public double[] calculateRootInBisectionMethod(String equation, double a, double b, double n, double[][] table) {
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        Function f = new Function("f",equation,"x");
        if(f.calculate(a)>f.calculate(b)){
            double c = a;
            a = b;
            b = c;
        }
        for(int i = 0;i<n;i++){
            double mid = (a+b)/2;
            double functionValueInMid = f.calculate(mid);
            if(functionValueInMid<0)a = mid;
            else b = mid;

            table[i][0] = a; table[i][1] = b; table[i][2] = f.calculate(a); table[i][3] = f.calculate(b);
            table[i][4] = mid; table[i][5] = f.calculate(mid);
        }
        return new double[]{f.calculate((a+b)/2),(a+b)/2};
    }

    @Override
    public double[] calculateRootInNewtonRaphsonMethod(String equation, double a, double n, double[][] table) {
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        Function f = new Function("f",equation,"x");
        String derivativeOfF = "der("+equation+",x)";

        double nextPoint = a;
        System.out.println(derivativeOfF);
        for(int i = 0;i<n;i++) {
            Argument arg = new Argument("x = "+Double.toString(nextPoint));
            Expression derivativeOfFunctionF = new Expression(derivativeOfF,arg);

            double x = f.calculate(nextPoint);
            double y = derivativeOfFunctionF.calculate();
            table[i][0] = nextPoint; table[i][1] = x; table[i][2] = y;
            nextPoint -= x/y;
        }
        return new double[]{f.calculate(nextPoint),nextPoint};
    }

    @Override
    public double[] calculateRootInRegulaFalsiMethod(String equation, double a, double b, double n, double[][] table) {
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        Function f = new Function("f",equation,"x");

        if(f.calculate(a)>f.calculate(b)) {
            double c = a;
            a = b;
            b = c;
        }

        double nextPoint= 0;
        for(int i = 0;i<n;i++) {
            double fa = f.calculate(a),fb = f.calculate(b);
            nextPoint += (Math.abs(fa)*(b-a))/(Math.abs(fa)+Math.abs(fb));
            if(f.calculate(nextPoint)>0)b = nextPoint;
            else a = nextPoint;

            table[i][0] = a; table[i][1] = b; table[i][2] = f.calculate(a); table[i][3] = f.calculate(b);
            table[i][4] = nextPoint; table[i][5] = f.calculate(nextPoint);
        }

        return new double[]{f.calculate(nextPoint),nextPoint};
    }
}
