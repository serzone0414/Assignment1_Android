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
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.PickerActions.setDate;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;




public class Activity3Test {

    @Rule
    public ActivityTestRule<Activity3> activityActivityTestRule = new ActivityTestRule<>(Activity3.class);
    Activity3 activity3;
    String firstName,lastName, DOB;
    double weight, height;


    @Before
    public void setUp() throws Exception {
        activity3 = activityActivityTestRule.getActivity();
        firstName = "TestFN";
        lastName = "TestLN";
    }

    @Test
    public  void  testCreatingResident(){


        onView(withId(R.id.et_firstName)).perform(typeText(firstName));
        onView(withId(R.id.et_lastName)).perform(typeText(lastName));

        onView(withId(R.id.datePickerButton)).perform(click());
        onView(isAssignableFrom(DatePicker.class)).perform(setDate(1970, 11, 15));
        onView(withId(android.R.id.button1)).perform(click());

        // Old codes did not work:
        //onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(setDate(year, month, day));


        onView(withId(R.id.et_height)).perform(typeText(String.valueOf("170")));
        onView(withId(R.id.et_weight)).perform(typeText(String.valueOf("80")));

        onView(withId(R.id.et_gender))
                .perform(click());
        onData(hasToString(startsWith("Male")))
                .perform(click());


        closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.activity4_Layout)).check(matches(isDisplayed()));

    }

    @Test
    public  void  testCreateButton(){


        closeSoftKeyboard();
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.activity3_Layout)).check(matches(isDisplayed()));

    }


    @After
    public void tearDown() throws Exception {
        activity3 = null;
    }
}