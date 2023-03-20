package com.surja.Coco.Math.controller;

import com.surja.Coco.Math.entity.Integration;
import com.surja.Coco.Math.payload.IntegrationDto;
import com.surja.Coco.Math.service.implementation.NumericalIntegrationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/numericalIntegration")
public class NumericalIntegrationController {
    @Autowired
    NumericalIntegrationImplementation numericalIntegrationImplementation;

    //Trapezoidal rule
    @PostMapping("/trapezoidalRule")
    public ResponseEntity<IntegrationDto> trapezoidalRuleController(@RequestBody Integration integration) {
        String expr = integration.getExpression();
        double a = integration.getLowerBound();
        double b = integration.getUpperBound();
        double n = integration.getPartitionNumber();

        double result = this.numericalIntegrationImplementation.trapezoidalRule(a,b,n,expr);
        IntegrationDto newResult = new IntegrationDto();
        newResult.setExpression(expr);
        newResult.setLowerBound(a);
        newResult.setUpperBound(b);
        newResult.setPartitionNumber(n);
        newResult.setResult(result);

        return new ResponseEntity<>(newResult, HttpStatus.OK);
    }

    // Simpson's One Third Rule
    @PostMapping("/simpsonsOneThirdRule")
    public ResponseEntity<IntegrationDto> simpsonsOneThirdRuleController(@RequestBody Integration integration) {
        String expr = integration.getExpression();
        double a = integration.getLowerBound();
        double b = integration.getUpperBound();
        double n = integration.getPartitionNumber();

        double result = this.numericalIntegrationImplementation.simpsons_one_third_rule(a,b,n,expr);
        IntegrationDto newResult = new IntegrationDto();
        newResult.setExpression(expr);
        newResult.setLowerBound(a);
        newResult.setUpperBound(b);
        newResult.setPartitionNumber(n);
        newResult.setResult(result);

        return new ResponseEntity<>(newResult, HttpStatus.OK);
    }

    // Simpson's Three By Eight Rule
    @PostMapping("/simpsonsThreeByEightRule")
    public ResponseEntity<IntegrationDto> simpsonsThreeByEightRuleController(@RequestBody Integration integration) {
        String expr = integration.getExpression();
        double a = integration.getLowerBound();
        double b = integration.getUpperBound();
        double n = integration.getPartitionNumber();

        double result = this.numericalIntegrationImplementation.simpsons_three_eight_rule(a,b,n,expr);
        IntegrationDto newResult = new IntegrationDto();
        newResult.setExpression(expr);
        newResult.setLowerBound(a);
        newResult.setUpperBound(b);
        newResult.setPartitionNumber(n);
        newResult.setResult(result);

        return new ResponseEntity<>(newResult, HttpStatus.OK);
    }

    // Boole's rule
    @PostMapping("/boolesRule")
    public ResponseEntity<IntegrationDto> boolesRuleController(@RequestBody Integration integration) {
        String expr = integration.getExpression();
        double a = integration.getLowerBound();
        double b = integration.getUpperBound();
        double n = integration.getPartitionNumber();

        double result = this.numericalIntegrationImplementation.boolesRule(a,b,n,expr);
        IntegrationDto newResult = new IntegrationDto();
        newResult.setExpression(expr);
        newResult.setLowerBound(a);
        newResult.setUpperBound(b);
        newResult.setPartitionNumber(n);
        newResult.setResult(result);

        return new ResponseEntity<>(newResult, HttpStatus.OK);
    }
}
