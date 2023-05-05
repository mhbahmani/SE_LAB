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

    @Test
    public void setterAndGetterTests() {
        Rectangle rectangle = new Rectangle(4, 3);
        Assert.assertEquals(12d, rectangle.computeArea(), 0.001d);
        Assert.assertEquals(4d, rectangle.getLength(), 0.001d);
        Assert.assertEquals(3d, rectangle.getWidth(), 0.001d);
        rectangle.setLength(8);
        rectangle.setWidth(5);
        Assert.assertEquals(40d, rectangle.computeArea(), 0.001d);
        Assert.assertEquals(8d, rectangle.getLength(), 0.001d);
        Assert.assertEquals(5d, rectangle.getWidth(), 0.001d);
    }

    @Test
    public void squareTest() {
        Rectangle square = new Square(5);
        Assert.assertEquals(square.getLength(), square.getWidth(), 0.001d);
        Assert.assertEquals(25d, square.computeArea(), 0.001d);
        square.setLength(6);
        Assert.assertEquals(6, square.getWidth(), 0.001d);
        Assert.assertEquals(36d, square.computeArea(), 0.001d);
        square.setWidth(8);
        Assert.assertEquals(8, square.getLength(), 0.001d);
        Assert.assertEquals(64d, square.computeArea(), 0.001d);
    }
}
