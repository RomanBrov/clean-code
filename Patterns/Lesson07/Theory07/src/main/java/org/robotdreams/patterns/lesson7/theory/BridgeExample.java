package org.robotdreams.patterns.lesson7.theory;

abstract class Shape {
    abstract public void draw();
}

abstract class Rectangle extends Shape {
    private double _x1;
    private double _y1;
    private double _x2;
    private double _y2;

    Rectangle(double x1, double y1, double x2, double y2) {
        _x1 = x1;
        _y1 = y1;
        _x2 = x2;
        _y2 = y2;
    }

    public void draw() {
        drawLine(_x1, _y1, _x2, _y1);
        drawLine(_x2, _y1, _x2, _y2);
        drawLine(_x2, _y2, _x1, _y2);
        drawLine(_x1, _y2, _x1, _y1);
    }

    abstract protected void drawLine(
            double x1, double y1,
            double x2, double y2);
}

class ExcelRectangle extends Rectangle {
    ExcelRectangle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    protected void drawLine(
            double x1, double y1,
            double x2, double y2) {
        ExcelApi.draw_a_line(x1, y1, x2, y2);
    }
}

class PdfRectangle extends Rectangle {
    PdfRectangle(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    protected void drawLine(
            double x1, double x2,
            double y1, double y2) {
        PdfApi.drawline(x1, x2, y1, y2);
    }
}

abstract class Circle extends Shape {
    private double x;
    private double y;
    private double r;

    Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public void draw() {
        drawCircle(x, y, r);
    }

    abstract protected void drawCircle(double x, double y, double r);
}

class ExcelCircle extends Circle {
    ExcelCircle(double x, double y, double r) {
        super(x, y, r);
    }

    protected void drawCircle(double x, double y, double r) {
        ExcelApi.draw_a_circle(x, y, r);
    }
}

class PdfCircle extends Circle {
    PdfCircle(double x, double y, double r) {
        super(x, y, r);
    }

    protected void drawCircle(double x, double y, double r) {
        PdfApi.drawcircle(x, y, r);
    }
}
