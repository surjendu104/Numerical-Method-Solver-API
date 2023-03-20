package com.surja.Coco.Math.service.implementation;

import com.surja.Coco.Math.service.LinearAlgebraicEquationsService;
import org.springframework.stereotype.Service;

@Service
public class LinearAlgebraicEquationsImplementation implements LinearAlgebraicEquationsService {

    @Override
    public double[] gaussEliminationMethod(double[][] inputMatrix) {
        int n = inputMatrix.length;
        //if(n<inputMatrix[0].length-1)

        // Form upper triangular matrix
        for(int j = 0;j<n-1;j++) {
            for(int i = j+1;i<n;i++) {
                double t = inputMatrix[i][j]/inputMatrix[j][j];

                for(int k = 0;k<n+1;k++) {
                    inputMatrix[i][k] -= inputMatrix[j][k]*t;
                }
            }
        }

        // Back substitution
        double[] result = new double[n];
        for(int i = n-1;i>=0;i--) {
            double s = 0;
            for(int j = i+1;j<n;j++)s+=inputMatrix[i][j]*result[j];
            result[i] = (inputMatrix[i][n]-s)/inputMatrix[i][i];
        }

        return result;
    }

    @Override
    public double[] gaussJordanMethod(double[][] inputMatrix) {
        int n = inputMatrix.length;

        for(int j = 0;j<n;j++) {
            for(int i =0;i<n;i++) {
                if(i!=j) {
                    double t = inputMatrix[i][j]/inputMatrix[j][j];
                    for(int k = 0;k<n+1;k++) {
                        inputMatrix[i][k]-= inputMatrix[j][k]*t;
                    }
                }
            }
        }
        double[] result = new double[n];
        for(int i = 0;i<n;i++) {
            result[i] = inputMatrix[i][n]/inputMatrix[i][i];
        }
        return result;
    }

    @Override
    public double[] gaussSeidalIterationMethod(double[][] inputMatrix,double allowedError,int maximumIteration) {
        int n = inputMatrix.length;
        double[] result = new double[n];
        for(int itr = 1;itr<=maximumIteration;itr++) {
            double maxErr = 0;
            for(int i = 0;i<n;i++) {
                double s = 0;
                for(int j = 0;j<n;j++) {
                    if(j!=i) {
                        s+=inputMatrix[i][j]*result[j];
                    }
                }
                double t = (inputMatrix[i][n]-s)/inputMatrix[i][i];
                double err = Math.abs(result[i]-t);
                if(err>maxErr){
                    maxErr = err;
                }
                result[i] = t;
            }

            if(maxErr<allowedError) {
                return result;
            }
        }
        return new double[0];
    }

    @Override
    public double[] lUFactorizatonMrthod(double[][] inputMatrix) {
        int n = inputMatrix.length;
        double[][] A = new double[n][n];
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];
        double[] V = new double[n];double[] B = new double[n];double[] X = new double[n];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++)A[i][j] = inputMatrix[i][j];
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++) {
                System.out.print(A[i][j]+" ");
            }
            System.out.print("\n");
        }
        int k = n;
        for(int i = 0;i<n;i++)B[i] = inputMatrix[i][k];
        for(int j = 0;j<n;j++) {
            System.out.print(B[j]+" ");
        }
        System.out.print("\n");

        // calculating l and u matrix
        for(int i = 0;i<n;i++)L[i][i] = 1;
        for(int m = 0;m<n;m++) {
            uRow(n,m,L,U,A);
            if(m<n-1)lCol(n,m,L,U,A);
        }

        // LV = B forward substitution
        for(int i = 0;i<n;i++) {
            double s = 0;
            for(int j = 0;j<=i-1;j++)s+=L[i][j]*V[j];
            V[i] = B[i]-s;
        }

        // UX = V backward substitution
        for(int i = n-1;i>=0;i--) {
            double s = 0;
            for(int j = i+1;j<n;j++) {
                s+=U[i][j]*X[j];
            }
            X[i] = (V[i]-s)/U[i][i];
        }
        return X;
    }

    public void uRow(int n,int i,double[][] l,double[][] u,double[][] a) {
        for(int j = i;j<n;j++) {
            double s = 0;
            for(int k = 0;k<n-1;k++)s+=u[k][j]*l[i][k];
            u[i][j] = a[i][j]-s;
        }
    }

    public void lCol(int n,int j,double[][] l,double[][] u,double[][] a) {
        for(int i = j+1;i<n;i++) {
            double s = 0;
            for(int k = 0;k<=j-1;k++)s+=u[k][j]*l[i][k];
            l[i][j] = (a[i][j]-s)/u[j][j];
        }
    }

}
