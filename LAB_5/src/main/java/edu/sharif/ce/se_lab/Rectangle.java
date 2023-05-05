package edu.sharif.ce.se_lab;

public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double computeArea() {
        return length * width;
    }

    public double getLength() {
        return 0;
    }

    public double getWidth() {
        return 0;
    }

    public void setLength(double length) {
    }

    public void setWidth(double width) {
    }
}
