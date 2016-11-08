package br.com.vs.monostate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TurnstileTest {

    @Before
    public void init() {
        Turnstile turnstile = new Turnstile();
        turnstile.reset();
    }

    @Test
    public void Must_start_locked_and_with_no_alarm() {
        Turnstile turnstile = new Turnstile();
        assertTrue(turnstile.locked());
        assertFalse(turnstile.alarm());
    }

    @Test
    public void After_insert_coint_must_be_unlocked_and_with_a_coin() {
        Turnstile turnstile = new Turnstile();
        turnstile.coin();
        Turnstile other = new Turnstile();
        assertFalse(other.locked());
        assertFalse(other.alarm());
        assertEquals(1, other.getCoins());
    }

    @Test
    public void Insert_a_coin_and_pass() {
        Turnstile turnstile = new Turnstile();
        turnstile.coin();
        turnstile.pass();

        Turnstile other = new Turnstile();
        assertTrue(other.locked());
        assertFalse(other.alarm());
        assertEquals(1, other.getCoins());
    }

    @Test
    public void Inserted_two_coins() {
        Turnstile turnstile = new Turnstile();
        turnstile.coin();
        turnstile.coin();

        Turnstile other = new Turnstile();
        assertFalse(other.locked());
        assertEquals(1, other.getCoins());
        assertEquals(1, other.getRefunds());
        assertFalse(other.alarm());
    }

    @Test
    public void Pass_without_inserting_coins() {
        Turnstile turnstile = new Turnstile();
        turnstile.pass();

        Turnstile other = new Turnstile();
        assertTrue(other.alarm());
        assertTrue(other.locked());
    }

    @Test
    public void Pass_after_alarm_of_no_coins() {
        Turnstile turnstile = new Turnstile();
        turnstile.pass();
        turnstile.coin();

        Turnstile other = new Turnstile();
        assertFalse(other.alarm());
        assertFalse(other.locked());
        assertEquals(1, other.getCoins());
        assertEquals(0, other.getRefunds());
    }

    @Test
    public void Two_operataions() {
        Turnstile turnstile = new Turnstile();
        turnstile.coin();
        turnstile.pass();
        turnstile.coin();
        assertFalse(turnstile.locked());
        assertEquals(2, turnstile.getCoins());
        turnstile.pass();
        assertTrue(turnstile.locked());
    }
}
