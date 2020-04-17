package lab1;

/*
19. Создайте иерархию классов Корпус - Плита - Плита с духовкой.
В методе MAIN создаются 2 плиты и определяется на какой плите
можно приготовить обед на большее число персон

Корпус  - RangeBody
Плита   - Range
Духовка - Stove

20x20x5 - 1 конфорка
40x20x5 - 2 конфорки
45х25х5 - 3 конфорки
60х50х5 - 4 конфорки
75х50х5 - 5 конфорок
80х50х5 - 6 конфорок
 */

import java.io.IOException;

import static lab1.Range.compare;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("You need to compare 2 kitchen-ranges");
        compare();
    }
}
