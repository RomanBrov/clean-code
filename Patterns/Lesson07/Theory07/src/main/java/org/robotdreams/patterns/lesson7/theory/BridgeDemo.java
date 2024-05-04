package org.robotdreams.patterns.lesson7.theory;

public class BridgeDemo {
    public void start() {
        System.out.println("Starting Bridge Demo");

        new ExcelRectangle(1, 2, 3, 4).draw();
        new PdfRectangle(1, 2, 3, 4).draw();
        new ExcelCircle(1, 2, 3).draw();
        new PdfCircle(1, 2, 3).draw();

        System.out.println();
    }
}
