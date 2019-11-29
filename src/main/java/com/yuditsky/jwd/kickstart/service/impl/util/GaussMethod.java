package com.yuditsky.jwd.kickstart.service.impl.util;

public class GaussMethod {
    private static final float E = 0.0001f;
    private static boolean solution_exist = true;

    public double[] calculate(double[][] matrix) {
        double[] root = null;

        matrixForward(matrix);
        matrixCheck(matrix);
        if (solution_exist) {
            root = matrixReverse(matrix);
        }

        return root;
    }

    private void matrixCheck(double[][] matrix) {
        if (Math.abs(matrix[matrix.length - 1][matrix.length - 1]) < E) {
            solution_exist = false;
        }
    }

    private double[][] matrixForward(double[][] matrix) {
        for (int k = 0; k < matrix.length - 1; k++) {
            if (matrix[k][k] != 0) {
                for (int j = k + 1; j < matrix.length; j++) {
                    double m = matrix[j][k] / matrix[k][k];//Коэффициент М
                    for (int i = k; i < matrix.length + 1; i++)
                        matrix[j][i] = matrix[j][i] - matrix[k][i] * m;
                    matrix[j][k] = 0;
                }
            } else {
                solution_exist = false;
            }
        }

        return matrix;
    }

    private double[] matrixReverse(double[][] matrix) {
        double[] root = new double[matrix[0].length - 1];

        for (int k = matrix.length - 1; k >= 0; k--) {
            double s = matrix[k][matrix.length];
            int j = k + 1;
            if (j != matrix.length) {
                s = s - matrix[k][j] * root[j];
            }
            root[k] = s / matrix[k][k];
        }

        return root;
    }

}
