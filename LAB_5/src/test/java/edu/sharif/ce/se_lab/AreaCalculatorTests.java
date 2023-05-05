package edu.sharif.ce.se_lab;

import org.junit.Assert;
import org.junit.Test;

public class AreaCalculatorTests {

    @Test
    public void testAreaCalculation_1() {
        double length = 5;
        double width = 3;
        double area = Rectangle.computeArea(length, width);
        Assert.assertEquals(15d, area, 0.001d);
    }
}
