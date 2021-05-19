package com.example.log_in;

import android.widget.DatePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;

public class Activity2Test {
    @Rule
    public ActivityTestRule <Activity2> activity2ActivityTestRule = new ActivityTestRule<>(Activity2.class);
    Activity2 activity2;


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public  void  test_to_activity3(){
        onView(withId(R.id.newResident)).perform(click());
        onView(withId(R.id.activity3_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_backPresstoActivity2FromActivity3(){
        onView(withId(R.id.newResident)).perform(click());
        onView(withId(R.id.activity3_Layout)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.activity2_Layout)).check(matches(isDisplayed()));
    }



    @Test
    public  void  test_to_activity4(){
        onView(withId(R.id.existResident)).perform(click());
        onView(withId(R.id.activity4_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_backPresstoActivity2FromActivity4(){
        onView(withId(R.id.existResident)).perform(click());
        onView(withId(R.id.activity4_Layout)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.activity2_Layout)).check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
        activity2 = null;
    }
}