package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;

class Range extends RangeBody {
    private int amountBurner;

    Range(int amountBurner) throws IOException {
        setAmountBurner(amountBurner);
        setRangeSize(this.amountBurner);
    }

    protected void printRange() {
        printRangeBody();
        System.out.println("amount of burners - " + getAmountBurner());
        System.out.println("without stove!\n");
    }

    int getAmountBurner() {
        return amountBurner;
    }

    private void setAmountBurner(int amountBurner) throws IOException {
        while (amountBurner < 1 || amountBurner > 6) {
            System.out.print("Wrong amount of burners, try again! (1-6)\nBurner count -> ");
            amountBurner = Integer.parseInt(reader.readLine());
        }
        this.amountBurner = amountBurner;
    }

    private void setRangeSize(int amountBurner) throws IOException {
        SecureRandom randomNumbers = new SecureRandom();
        setHeight(5 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(5));
        switch (amountBurner) {
            case 1:
                setLength(20 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(20));
                setWidth(20);
                break;
            case 2:
                setLength(40 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(5));
                setWidth(20 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(5));
                break;
            case 3:
                setLength(45 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(15));
                setWidth(40 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(10));
                break;
            case 4:
                setLength(60 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(15));
                setWidth(50);
                break;
            case 5:
                setLength(75 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(5));
                setWidth(50);
                break;
            case 6:
                setLength(80 + randomNumbers.nextInt(10) * 0.1 + randomNumbers.nextInt(10));
                setWidth(50);
                break;
            default:
                throw new IllegalArgumentException(amountBurner + " is invaid value");
        }
    }

    protected int getCountPerson() {
        return getAmountBurner() * 2;
    }

    static void compare() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPlease enter:" +
                "\n1 - Range vs Range" +
                "\n2 - Stove vs Stove" +
                "\n3 - Range vs Stove" +
                "\n-> ");
        int switchNum = Integer.parseInt(reader.readLine());
        while (switchNum != 1 && switchNum != 2 && switchNum != 3) {
            System.out.print("\nTry again! You need to choose 1 or 2 only!" +
                    "\n-> ");
            switchNum = Integer.parseInt(reader.readLine());
        }
        switchCompare(switchNum);

    }

    private static void switchCompare(int switchNum) throws IOException {
        switch (switchNum) {
            case 1:
                Range firstRange = new Range(readBurner());
                Range secondRange = new Range(readBurner());
                System.out.print("\nFirst");
                firstRange.printRange();
                System.out.print("Second");
                secondRange.printRange();
                printCompareResult(firstRange, secondRange);
            case 2:
                Stove firstStove = new Stove(readBurner());
                Stove secondStove = new Stove(readBurner());
                System.out.print("\nFirst");
                firstStove.printRange();
                System.out.print("Second");
                secondStove.printRange();
                printCompareResult(firstStove, secondStove);
            case 3:
                Range myRange = new Range(readBurner());
                Stove myStove = new Stove(readBurner());
                System.out.print("\nFirst");
                myRange.printRange();
                System.out.print("Second");
                myStove.printRange();
                printCompareResult(myRange, myStove);
        }
    }

    private static int readBurner() throws IOException {
        int burners;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Burner count -> ");
        burners = Integer.parseInt(reader.readLine());
        return burners;
    }

    private static void printCompareResult(Range firstObj, Range secondObj) {
        if (firstObj.getCountPerson() > secondObj.getCountPerson()) {
            System.out.println("First Range is better than Second Range!" +
                    "\nIt can cook for " + firstObj.getCountPerson() + " persons " +
                    "than range, which can cook for " + secondObj.getCountPerson() + " persons");
        } else if (firstObj.getCountPerson() == secondObj.getCountPerson()) {
            System.out.println("Two Ranges are equal" +
                    "\nThey can cook for " + firstObj.getCountPerson() + " persons");
        } else {
            System.out.println("Second Range is better than First Range!" +
                    "\nIt can cook for " + secondObj.getCountPerson() + " persons " +
                    "than range, which can cook for " + firstObj.getCountPerson() + " persons");
        }
    }
}
