package lab1;

import java.io.IOException;
import java.security.SecureRandom;

class Stove extends Range {
    Stove(int amountBurner) throws IOException {
        super(amountBurner);
        SecureRandom randomNumbers = new SecureRandom();
        setHeight(getHeight() + 70 + randomNumbers.nextInt(10));
    }

    protected void printRange() {
        printRangeBody();
        System.out.println("amount of burners - " + getAmountBurner());
        System.out.println("with stove!\n");
    }

    protected int getCountPerson() {
        return getAmountBurner() * 2 + 6;
    }
}
