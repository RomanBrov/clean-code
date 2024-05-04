package org.robotdreams.patterns.lesson8.homework;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public class Homework {
    public static void main(String[] args) throws IOException {


        Color BLUE = new Color(0, 87, 183);
        Color YELLOW = new Color(255, 221, 0);
        Color WHITE = Color.white;
        Color BLACK = Color.black;

        int width = 640;
        int height = 480;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        g2d.setColor(BLUE);
        g2d.setBackground(BLUE);
        g2d.fillRect(0, 0, width, height / 2);

        g2d.setColor(YELLOW);
        g2d.fillRect(0, height / 2, width, height / 2);

        int bigTextSize = 48;
        Font font = new Font("Arial", Font.BOLD, bigTextSize);
        g2d.setFont(font);
        g2d.setColor(WHITE);
        String text = "Centered Text";
        FontMetrics fontMetrics = g2d.getFontMetrics(font);
        int x = (width - fontMetrics.stringWidth(text)) / 2;
        int y = height / 4 + fontMetrics.getAscent() / 2;
        g2d.drawString(text, x, y);

        int mediumTextSize = 24;
        font = new Font("Arial", Font.BOLD, mediumTextSize);
        g2d.setFont(font);
        g2d.setColor(BLACK);
        text = "Slava Ukraini";
        fontMetrics = g2d.getFontMetrics(font);
        x = width - mediumTextSize - fontMetrics.stringWidth(text);
        y = height * 7 / 8 + fontMetrics.getAscent() / 2;
        g2d.drawString(text, x, y);

        g2d.dispose();

        Path pathToFile = Path.of(
                new File("").getAbsolutePath(),
                "Patterns/Lesson08/Homework08/src/main/java/",
                "drawnImage.png");
        File outputFile = new File(pathToFile.toString());
        ImageIO.write(image, "png", outputFile);
    }
}
