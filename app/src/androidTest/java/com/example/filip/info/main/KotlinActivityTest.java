package com.example.filip.info.main;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.filip.info.R;
import com.example.filip.info.display.CoinListActivity;
import com.example.filip.info.display.DisplayInfoActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Filip on 2017-08-03.
 */
@RunWith(AndroidJUnit4.class)
public class KotlinActivityTest {

    @Rule
    public final IntentsTestRule<KotlinActivity> main = new IntentsTestRule<>(KotlinActivity.class);
    private KotlinActivity kotlinActivity;

    @Before
    public void setKotlinActivity() {
        kotlinActivity = main.getActivity();
    }

    @Test
    public void testStartActivityCoin() {
        onView(withId(R.id.button_coin)).perform(click());
        intending(hasComponent(CoinListActivity.class.getName()));
    }

    @Test
    public void testStartActivityBarcode() {
        kotlinActivity.startActivityHandler(DisplayInfoActivity.class, "");
        intending(hasComponent(DisplayInfoActivity.class.getName()));
    }


}