package com.surja.Coco.Math.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LinearAlgebraicEquationsDto {
    private double[][] inputMatrix;
    private double[] solutions;
    private double allowedError;
    private int maximumIteration;
    private String convergeIteration;

}
