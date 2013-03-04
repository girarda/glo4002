package ca.ulaval.glo4002.testAcceptance;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ca.ulaval.glo4002.devices.InvalidPINException;
import ca.ulaval.glo4002.testFixtures.TestFixture;

public class TestArmViaKeypad {

    private TestFixture fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new TestFixture();
        fixture.createAlarmSystem();
    }

    @Test
    public void systemIsArmedWithFastPIN() {
        fixture.armSystemWithFastPIN();
        fixture.assertAlarmSystemIsArmed();
    }

    @Test
    public void systemIsArmedWithGoodPIN() {
        fixture.armSystemWithDefaultPIN();

        fixture.assertAlarmSystemIsArmed();
    }

    @Test(expected = InvalidPINException.class)
    public void systemIsNotArmedWithWrongPIN() {
        fixture.armSystemWithWrongPIN();

        fixture.assertAlarmSystemIsNotArmed();
    }

    @Ignore
    @Test
    public void thirtySecondsDelayAfterArmingSystemBeforeArming() {
        fixture.armSystemWithDefaultPIN();

        fixture.openMainDoor();

        fixture.waitThirtySeconds();

        fixture.assertNoIntrusion();
    }
}