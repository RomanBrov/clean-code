package org.robotdreams.patterns.lesson7.theory;

public class PdfApi {
    public static void drawline(double x1, double x2, double y1, double y2) {
        System.out.printf("Drawing line using PDF: (%s,%s), (%s,%s)%n", x1, x2, y1, y2);
    }

    public static void drawcircle(double x, double y, double r) {
        System.out.printf("Drawing circle using PDF: (%s,%s), radius %s%n", x, y, r);
    }
}
