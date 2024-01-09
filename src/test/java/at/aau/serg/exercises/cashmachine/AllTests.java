package at.aau.serg.exercises.cashmachine;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ CashMachineParameterTest.class, CashMachineStateTest.class,CashMachineRandomTest.class })
public class AllTests {

}
