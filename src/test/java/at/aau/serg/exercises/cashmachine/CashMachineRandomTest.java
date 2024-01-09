package at.aau.serg.exercises.cashmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CashMachineRandomTest {
    CashMachine cm = new CashMachine();

    @Test
    public void insertCardTest() {
        Random r = new Random();
        String randomNumber = String.format("%04d", r.ints(0, 99999)
                .findFirst()
                .getAsInt());
        cm.insertCard(randomNumber);
        Assertions.assertEquals(CashMachineState.CARD_INSERTED, cm.getCurrentState());
    }

    @Test
    public void inputPINTest() {
        cm.insertCard("12300");
        Random r = new Random();
        String randomNumber = String.format("%04d", r.nextInt(9999 + 1));
        cm.inputPIN(randomNumber);
        if (cm.getCurrentState() == CashMachineState.PIN_NOT_OK)
            Assertions.assertEquals(CashMachineState.PIN_NOT_OK, cm.getCurrentState());
        else
            Assertions.assertTrue(cm.getCurrentState() == CashMachineState.PIN_OK, "PIN ok");
    }

    @Test
    public void amountTest() {
        cm.insertCard("validCardNumber");
        cm.inputPIN("1337");
        Random r = new Random();
        Integer randomNumber = r.ints(0, 99999)
                .findFirst()
                .getAsInt();
        cm.selectAmount(randomNumber);
        if (cm.getCurrentState() == CashMachineState.AMOUNT_VALID)
            Assertions.assertEquals(CashMachineState.AMOUNT_VALID, cm.getCurrentState());
        else
            Assertions.assertTrue(cm.getCurrentState() == CashMachineState.AMOUNT_NOT_VALID, "AMOUNT_NOT_VALID");
    }

    @Test
    public void takeCashTest() {
        cm.insertCard("validCardNumber");
        cm.inputPIN("1337");
        cm.selectAmount(100);
        cm.takeCash();
        Assertions.assertEquals(CashMachineState.CASH_GIVEN, cm.getCurrentState());
    }

    @Test
    public void removeCardTest() {
        cm.insertCard("validCardNumber");
        cm.inputPIN("1337");
        cm.selectAmount(100);
        cm.takeCash();
        cm.removeCard();
        Assertions.assertEquals(CashMachineState.CARD_TAKEN, cm.getCurrentState());
    }
}
