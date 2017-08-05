package com.example.filip.info.view;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.filip.info.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by Filip on 2017-08-03.
 */
@RunWith(AndroidJUnit4.class)
public class DisplayInfoActivityTest {
//12345679


    @Rule
    public final ActivityTestRule<DisplayInfoActivity> main = new ActivityTestRule<>(DisplayInfoActivity.class);

    public DisplayInfoActivity activity;
    String message = "12345679";


    @Before
    public void setMain() {

        activity = main.getActivity();
        activity.message = message;
    }

    @Test
    public void testCreateView() {
        activity.createView(message);
        onView(withId(R.id.editTextV)).check(matches(not(withText(""))));
    }
}