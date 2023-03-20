package com.surja.Coco.Math.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ODE {
    private String equation;
    private double height;
    private int partitions;
    private double valueOfX;
    private double valueOfY;
    private double valuePoint;
}
