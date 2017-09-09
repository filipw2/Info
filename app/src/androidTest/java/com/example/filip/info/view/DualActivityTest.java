package com.example.filip.info.view;

import android.content.pm.ActivityInfo;
import android.support.test.rule.ActivityTestRule;

import com.example.filip.info.dual.AddressBook;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Filip on 2017-09-09.
 */
public class DualActivityTest {

    @Rule
    public ActivityTestRule<DualActivity> mActivityActivityTestRule = new ActivityTestRule<DualActivity>(DualActivity.class);
    private AddressBook mAddressBook = AddressBook.getInstance();

    @Before
    public void setTest() {
        mAddressBook.insertAddress("TestName", "TestCity", "TestStreet", "TestDCode");
    }

    @Test
    public void testPortraitDetailActivity() {
        mActivityActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mActivityActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        onView(withText("TestName")).perform(click());

        onView(withText("TestCity")).check(matches(isDisplayed()));
    }

    @Test
    public void testScreenOrientationChange() {
        mActivityActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        onView(withText("TestName")).perform(click());

        onView(withText("TestCity")).check(matches(isDisplayed()));
    }


}