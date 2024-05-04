package org.robotdreams.patterns.lesson7.theory;

public class ExcelApi {
    public static void draw_a_line(double x1, double y1, double x2, double y2) {
        System.out.printf("Drawing line using Excel: (%s,%s), (%s,%s)%n", x1, x2, y1, y2);
    }

    public static void draw_a_circle(double x, double y, double r) {
        System.out.printf("Drawing circle using Excel: (%s,%s), radius %s%n", x, y, r);
    }
}
