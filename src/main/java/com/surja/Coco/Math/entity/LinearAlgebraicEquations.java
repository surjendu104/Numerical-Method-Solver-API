package com.surja.Coco.Math.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class LinearAlgebraicEquations {
    private double[][] inputMatrix;
    private double allowedError;
    private int maximumIteration;
}
