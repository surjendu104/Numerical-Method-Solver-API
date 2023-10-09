package com.surja.Coco.Math.service.implementation;

import com.surja.Coco.Math.service.SolutionOfODEService;
import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.License;
import org.springframework.stereotype.Service;

@Service
public class SolutionOfODEImplementation implements SolutionOfODEService {
    @Override
    public double[][] eulersMethod(String equation, double valueOfX, double valueOfY, double height, double valuePoint) {
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        Function f = new Function("f(x, y) = "+equation);
        int partitions = (int) Math.ceil((valuePoint - valueOfX) / height);
        System.out.println("dbg : " + equation+" "+partitions);

        double[][] result = new double[partitions+1][2];
        result[0][0] = valueOfX;
        result[0][1] = valueOfY;
        for(int i = 1;i<partitions+1;i++) {
            result[i][0] = height+result[i-1][0];
            result[i][1] = result[i-1][1] + height*f.calculate(result[i-1][0],result[i-1][1]);
        }
        return result;
    }

    @Override
    public double[][] eulersModifiedMethod(String equation, double valueOfX, double valueOfY, double height, double valuePoint) {
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Person 1");
        Function f = new Function("f(x, y) = "+equation);
        int partitions = (int) Math.ceil((valuePoint - valueOfX) / height);
        double[][] result = new double[partitions + 1][2];
        result[0][0] = valueOfX;
        result[0][1] = valueOfY;
        for(int i = 1;i<partitions + 1;i++) {
            result[i][0] = height+result[i-1][0];
            double temp = result[i-1][1] + height*f.calculate(result[i-1][0],result[i-1][1]);
            result[i][1] = result[i-1][1]+ (0.5*height)*(f.calculate(result[i-1][0],result[i-1][1]) + f.calculate(result[i][0],temp));
        }
        return result;
    }
}
