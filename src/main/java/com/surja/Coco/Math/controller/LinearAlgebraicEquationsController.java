package com.surja.Coco.Math.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.surja.Coco.Math.entity.LinearAlgebraicEquations;
import com.surja.Coco.Math.payload.LinearAlgebraicEquationsDto;
import com.surja.Coco.Math.service.implementation.LinearAlgebraicEquationsImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/linearAlgebraicEquations")
public class LinearAlgebraicEquationsController {
    @Autowired
    LinearAlgebraicEquationsImplementation linearAlgebraicEquationsImplementation;
    // Gauss elimination method
    @PostMapping("/gaussElimination")
    public ResponseEntity<LinearAlgebraicEquationsDto> gaussEliminationMethodController(@RequestBody LinearAlgebraicEquations linearAlgebraicEquations) {

        double[][] input = linearAlgebraicEquations.getInputMatrix();
        double[] solution = this.linearAlgebraicEquationsImplementation.gaussEliminationMethod(input);
        LinearAlgebraicEquationsDto outputResult = new LinearAlgebraicEquationsDto();

        outputResult.setInputMatrix(input);
        outputResult.setSolutions(solution);
        return new ResponseEntity<>(outputResult, HttpStatus.OK);
    }

    @PostMapping("/gaussJordan")
    public ResponseEntity<LinearAlgebraicEquationsDto> gaussJordanMethodController(@RequestBody LinearAlgebraicEquations linearAlgebraicEquations) {

        double[][] input = linearAlgebraicEquations.getInputMatrix();
        double[] solution = this.linearAlgebraicEquationsImplementation.gaussJordanMethod(input);
        LinearAlgebraicEquationsDto outputResult = new LinearAlgebraicEquationsDto();

        outputResult.setInputMatrix(input);
        outputResult.setSolutions(solution);
        return new ResponseEntity<>(outputResult, HttpStatus.OK);
    }

    @PostMapping("/gaussSeidal")
    public ResponseEntity<LinearAlgebraicEquationsDto> gaussSeidalMethodController(@RequestBody LinearAlgebraicEquations linearAlgebraicEquations) {

        double[][] input = linearAlgebraicEquations.getInputMatrix();
        double allowedError = linearAlgebraicEquations.getAllowedError();
        int iteration = linearAlgebraicEquations.getMaximumIteration();
        double[] solution = this.linearAlgebraicEquationsImplementation.gaussSeidalIterationMethod(input,allowedError,iteration);
        LinearAlgebraicEquationsDto outputResult = new LinearAlgebraicEquationsDto();

        outputResult.setInputMatrix(input);
        outputResult.setSolutions(solution);
        outputResult.setAllowedError(allowedError);
        outputResult.setMaximumIteration(iteration);
        outputResult.setConvergeIteration((solution.length<input.length-1)?"Iterations not sufficient":"Converges with in the iteration number"+Integer.toString(iteration));
        return new ResponseEntity<>(outputResult, HttpStatus.OK);
    }

    @PostMapping("/lUDecomposition")
    public ResponseEntity<LinearAlgebraicEquationsDto> lUDecompositionMethodController(@RequestBody LinearAlgebraicEquations linearAlgebraicEquations) {

        double[][] input = linearAlgebraicEquations.getInputMatrix();
        double[] solution = this.linearAlgebraicEquationsImplementation.lUFactorizatonMrthod(input);
        LinearAlgebraicEquationsDto outputResult = new LinearAlgebraicEquationsDto();

        outputResult.setInputMatrix(input);
        outputResult.setSolutions(solution);
        return new ResponseEntity<>(outputResult, HttpStatus.OK);
    }
}
