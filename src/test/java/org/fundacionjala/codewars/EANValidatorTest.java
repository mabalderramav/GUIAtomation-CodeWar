package org.fundacionjala.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test for {@link EANValidatorTest}
 */
public class EANValidatorTest {

    @Test
    public void test_01() {
        final String value = "9783815820865";
        assertTrue(EANValidator.validate(value));
    }

    @Test
    public void test_02() {
        final String value = "9783815820864";
        assertFalse(EANValidator.validate(value));
    }

    @Test
    public void test_03() {
        final String value = "9783827317100";
        assertTrue(EANValidator.validate(value));
    }
}
