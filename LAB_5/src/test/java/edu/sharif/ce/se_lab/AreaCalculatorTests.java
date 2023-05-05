package edu.sharif.ce.se_lab;

import org.junit.Assert;
import org.junit.Test;

public class AreaCalculatorTests {

    @Test
    public void testAreaCalculation_1() {
        double length = 5;
        double width = 3;
        Rectangle rectangle = new Rectangle(length, width);
        double area = rectangle.computeArea();
        Assert.assertEquals(15d, area, 0.001d);
    }
}
