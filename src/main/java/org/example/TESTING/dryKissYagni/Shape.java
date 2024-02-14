package org.example.TESTING.dryKissYagni;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

// Нарушение SOLID:
class Shape {
    public enum Type {CIRCLE, SQUARE}

    private Type type;

    public Shape(Type type) {
        this.type = type;
    }

    public double calculateArea() {
        if (type == Type.CIRCLE) {
            // Вычисление площади круга
        } else if (type == Type.SQUARE) {
            // Вычисление площади квадрата
        }
        return 0.0;
    }
}

class ShapeI {

    static class Circle implements CalculateArea {

        @Override
        public double calculateArea() {
            return 0;
        }
    }

    static class Square implements CalculateArea {

        @Override
        public double calculateArea() {
            return 0;
        }
    }

}

interface CalculateArea {
    double calculateArea();
}

class ShapeITest {
    ShapeI.Circle shapeCircle = Mockito.mock(ShapeI.Circle.class);
    ShapeI.Square shapeSquare = Mockito.mock(ShapeI.Square.class);

    @Test
    void calculateAreaCircleTest() {
        shapeCircle.calculateArea();
        Mockito.verify(shapeCircle).calculateArea();
    }

    @Test
    void calculateAreaSquareTest() {
        shapeSquare.calculateArea();
        Mockito.verify(shapeSquare).calculateArea();
    }

}
