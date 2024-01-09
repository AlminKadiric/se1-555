package at.aau.serg.exercises.cashmachine;

public enum CashMachineState {
	START, CARD_INSERTED, PIN_NOT_OK, PIN_OK, CARD_RETAINED, AMOUNT_VALID, AMOUNT_NOT_VALID, CASH_GIVEN, CARD_TAKEN;
}
