package at.aau.serg.exercises.cashmachine;

public class CashMachine {

	private CashMachineState currentState;
	private int failedPinCount = 1;

	public CashMachine() {
		currentState = CashMachineState.START;
	}

	public void insertCard(String cardNr) {
		if (currentState != CashMachineState.START) {
			throw new IllegalStateException();
		} else {
			if (cardNr.endsWith("13")) {
				System.out.println("Card invalid. Retaining Card.");
				currentState = CashMachineState.CARD_RETAINED;
			} else {
				System.out.println("Card valid.");
				currentState = CashMachineState.CARD_INSERTED;
			}
		}
	}

	public void inputPIN(String pin) {
		if (currentState == CashMachineState.CARD_INSERTED
				|| currentState == CashMachineState.PIN_NOT_OK) {
			if (failedPinCount < 4) {
				if ("1337".equals(pin)) {
					failedPinCount++;
					currentState = CashMachineState.PIN_OK;
					System.out.println("PIN OK.");
				} else {
					failedPinCount++;
					currentState = CashMachineState.PIN_NOT_OK;
					System.out.println("PIN NOT OK. Retry.");
				}
			} else {
				currentState = CashMachineState.CARD_RETAINED;
				System.out.println("PIN NOT OK. CARD RETAINED");
			}
		} else {
			throw new IllegalStateException();
		}
	}

	public void selectAmount(Integer amount) {
		if (currentState == CashMachineState.PIN_OK
				|| currentState == CashMachineState.AMOUNT_NOT_VALID) {
			while (amount >= 100) {
				amount -= 100;
			}
			while (amount >= 50) {
				amount -= 50;
			}
			while (amount >= 10) {
				amount -= 10;
			}
			if (amount != 0) {
				System.out.println("Invalid amount. Choose another.");
				currentState = CashMachineState.AMOUNT_NOT_VALID;
			} else {
				System.out.println("Valid amount. Take the money.");
				currentState = CashMachineState.AMOUNT_VALID;
			}
		} else {
			throw new IllegalStateException();
		}
	}

	public void takeCash() {
		if (currentState == CashMachineState.AMOUNT_VALID) {
			System.out.println("Cash given.");
			currentState = CashMachineState.CASH_GIVEN;
		} else {
			throw new IllegalStateException();
		}
	}

	public void removeCard() {
		if (currentState == CashMachineState.CASH_GIVEN) {
			System.out.println("Card taken.");
			currentState = CashMachineState.CARD_TAKEN;
		} else {
			throw new IllegalStateException();
		}
	}

	public CashMachineState getCurrentState() {
		return currentState;
	}
}
