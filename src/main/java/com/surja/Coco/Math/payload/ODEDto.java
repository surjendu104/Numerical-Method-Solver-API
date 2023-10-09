package com.surja.Coco.Math.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ODEDto {
    private String equation;
    private double height;
    private double valueOfX;
    private double valueOfY;
    private double valuePoint;
    private double[][] result;
    private double resultAtPoint;
}
