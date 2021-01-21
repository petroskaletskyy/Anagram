package com.example.task1_anagrams;

import android.Manifest;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.rule.GrantPermissionRule;

import com.squareup.spoon.Spoon;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class, false, true);

    @Rule
    public GrantPermissionRule permissionRule = GrantPermissionRule.grant(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    );

    @Test
    public void enterFirstStringToReverse() {
        Spoon.screenshot(mActivityRule.getActivity(), "initial_state_first_test");
        onView(withId(R.id.edit_text_ignored_characters)).perform(typeText("0123456789"), closeSoftKeyboard());
        onView(withId(R.id.edit_text_string_for_reverse)).perform(typeText("Foxminded cool 24/7"), closeSoftKeyboard());
        Spoon.screenshot(mActivityRule.getActivity(), "enter_all_strings_first_test");
        onView(withId(R.id.text_view_reversed_text)).check(matches(withText("dednimxoF looc 24/7")));
    }

    @Test
    public void enterSecondStringToReverse() {
        Spoon.screenshot(mActivityRule.getActivity(), "initial_state_second_test");
        onView(withId(R.id.edit_text_ignored_characters)).perform(typeText("0123456789"), closeSoftKeyboard());
        onView(withId(R.id.edit_text_string_for_reverse)).perform(typeText("abcd efgh"), closeSoftKeyboard());
        Spoon.screenshot(mActivityRule.getActivity(), "enter_all_strings_second_test");
        onView(withId(R.id.text_view_reversed_text)).check(matches(withText("dcba hgfe")));
    }

    @Test
    public void enterThirdStringToReverse() {
        Spoon.screenshot(mActivityRule.getActivity(), "initial_state_third_test");
        onView(withId(R.id.edit_text_ignored_characters)).perform(typeText("xl"), closeSoftKeyboard());
        onView(withId(R.id.edit_text_string_for_reverse)).perform(typeText("a1bcd efglh"), closeSoftKeyboard());
        Spoon.screenshot(mActivityRule.getActivity(),  "enter_all_strings_third_test");
        onView(withId(R.id.text_view_reversed_text)).check(matches(withText("dcb1a hgfle")));
    }

}