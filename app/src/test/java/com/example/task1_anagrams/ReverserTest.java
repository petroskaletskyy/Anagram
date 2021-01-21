package com.example.task1_anagrams;

import android.os.Build;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28, manifest = Config.NONE)
public class ReverserTest {

    @Test
    public void whenAssertingReverseString_thenEqual() {
        assertEquals("dednimxoF looc 24/7", Reverser.reverse("Foxminded cool 24/7", "0123456789"));
        assertEquals("dcba hgfe", Reverser.reverse("abcd efgh", "0123456789"));
        assertEquals("dcb1a hgfle", Reverser.reverse("a1bcd efglh", "xl"));
        assertEquals("dcba hgfe", Reverser.reverse("abcd efgh", "xl"));
    }

    @Test
    public void whenAssertingIgnoredCharacters_thenVerified() {
        assertTrue(Reverser.ignoredCharactersCheck('2', "0123456789"));
        assertTrue(Reverser.ignoredCharactersCheck('x', "xl"));
        assertFalse(Reverser.ignoredCharactersCheck('a', "0123456789"));
        assertFalse(Reverser.ignoredCharactersCheck('m', "xl"));
    }
}