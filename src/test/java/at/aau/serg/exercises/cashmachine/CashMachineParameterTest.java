package at.aau.serg.exercises.cashmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CashMachineParameterTest {
    CashMachine cm=new CashMachine();
    @ParameterizedTest
    @ValueSource(strings = {"12300","13400","10000"}) // multiple values
    public void insertCardTest(String cardNr) {
        cm.insertCard(cardNr);
        Assertions.assertEquals(CashMachineState.CARD_INSERTED,cm.getCurrentState());
    }
    @ParameterizedTest
    @ValueSource(strings = {"0000","1337","1234"}) // six numbers
    public void inputPINTest(String pin) {
        cm.insertCard("12300");
        cm.inputPIN(pin);
        if(cm.getCurrentState()==CashMachineState.PIN_NOT_OK)
            Assertions.assertEquals(CashMachineState.PIN_NOT_OK,cm.getCurrentState());
        else
            Assertions.assertTrue(cm.getCurrentState()==CashMachineState.PIN_OK,"PIN ok");
    }
    @ParameterizedTest
    @ValueSource(ints = {100,1200,152}) // six numbers
    public void amountTest(Integer amount) {
        cm.insertCard("validCardNumber");
        cm.inputPIN("1337");
        cm.selectAmount(amount);
        if(cm.getCurrentState()==CashMachineState.AMOUNT_VALID)
            Assertions.assertEquals(CashMachineState.AMOUNT_VALID,cm.getCurrentState());
        else
            Assertions.assertTrue(cm.getCurrentState()==CashMachineState.AMOUNT_NOT_VALID,"AMOUNT_NOT_VALID");
    }
    @Test
    public void takeCashTest() {
        cm.insertCard("validCardNumber");
        cm.inputPIN("1337");
        cm.selectAmount(100);
        cm.takeCash();
        Assertions.assertEquals(CashMachineState.CASH_GIVEN,cm.getCurrentState());
    }
    @Test
    public void removeCardTest() {
        cm.insertCard("validCardNumber");
        cm.inputPIN("1337");
        cm.selectAmount(100);
        cm.takeCash();
        cm.removeCard();
        Assertions.assertEquals(CashMachineState.CARD_TAKEN,cm.getCurrentState());
    }
}
