package com.surja.Coco.Math;

import org.junit.jupiter.api.Test;
import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CocoMathApplicationTests {

	@Test
	void contextLoads() {
		Argument x = new Argument("x = 1");
		Expression e = new Expression("der(cos(x),x)", x);
		mXparser.consolePrintln("Res: " + e.getExpressionString() + " = " + e.calculate());

	}

}
