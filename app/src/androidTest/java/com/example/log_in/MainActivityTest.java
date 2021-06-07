package com.example.log_in;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule <MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    MainActivity mainActivity;
    String username;
    String password;

    @Before
    public void setUp() throws Exception {
        mainActivity = activityActivityTestRule.getActivity();
        username = "Admin";
        password = "1234";
    }

    @Test
    public  void  testLogInFunction(){
        onView(withId(R.id.username)).perform(typeText(username));
        onView(withId(R.id.password)).perform(typeText(password));
        closeSoftKeyboard();
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.menuActivity_Layout)).check(matches(isDisplayed()));

    }

    @After
    public void tearDown() throws Exception {
        mainActivity = null;
    }
}