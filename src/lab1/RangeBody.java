package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RangeBody {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private double height;  // Z    высота
    private double length;  // X    длина
    private double width;   // Y    ширина

    void printRangeBody() {
        System.out.println(" range has:\nheight - " +
                getHeight() + " cm\nlength - " +
                getLength() + " cm\nwidth - " +
                getWidth() + " cm");
    }

    double getHeight() {
        return height;
    }

    private double getLength() {
        return length;
    }

    private double getWidth() {
        return width;
    }

    void setHeight(double height) throws IOException {
        while (height <= 0) {
            System.out.print("Wrong height size!\n-> ");
            height = Double.parseDouble(reader.readLine());
        }
        this.height = height;
    }

    void setLength(double length) throws IOException {
        while (length <= 0) {
            System.out.print("Wrong length size!\n-> ");
            length = Double.parseDouble(reader.readLine());
        }
        this.length = length;
    }

    void setWidth(double width) throws IOException {
        while (width <= 0) {
            System.out.print("Wrong width size!\n-> ");
            width = Double.parseDouble(reader.readLine());
        }
        this.width = width;
    }
}
