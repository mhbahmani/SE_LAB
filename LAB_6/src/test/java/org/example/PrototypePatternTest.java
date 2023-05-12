package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PrototypePatternTest {

    @Test
    public void testShapeCache() {
        ShapeCache.loadCache();

        Shape clonedShape1 = ShapeCache.getShape("1");
        Shape clonedShape2 = ShapeCache.getShape("2");

        assertNotSame(clonedShape1, clonedShape2);
        assertEquals(clonedShape1.getType(), "Circle");
        assertEquals(clonedShape2.getType(), "Rectangle");
    }

    @Test
    public void testCircleClone() {
        Circle circle = new Circle();
        circle.setId("1");

        Circle clonedCircle = (Circle) circle.clone();

        assertNotSame(circle, clonedCircle);
        assertEquals(circle.getType(), clonedCircle.getType());
        assertEquals(circle.getId(), clonedCircle.getId());
    }

    @Test
    public void testRectangleClone() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");

        Rectangle clonedRectangle = (Rectangle) rectangle.clone();

        assertNotSame(rectangle, clonedRectangle);
        assertEquals(rectangle.getType(), clonedRectangle.getType());
        assertEquals(rectangle.getId(), clonedRectangle.getId());
    }
}