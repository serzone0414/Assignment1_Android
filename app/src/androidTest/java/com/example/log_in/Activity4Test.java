package com.example.log_in;

import androidx.test.rule.ActivityTestRule;

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
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;

public class Activity4Test {

    @Rule
    public ActivityTestRule<Activity4> activityActivityTestRule = new ActivityTestRule<>(Activity4.class);
    Activity4 activity4;

    @Before
    public void setUp() throws Exception {
        activity4 = activityActivityTestRule.getActivity();
    }




    @Test
    public  void  test_Activity5Questionair(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.questionair)).perform(click());
        onView(withId(R.id.activity7_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_Activity5QuestionairToActivity8(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.questionair)).perform(click());

        for (int i = 0 ; i < 16; i++) {
            onView(withId(R.id.choiceYes)).perform(click());
        }
        onView(withId(R.id.activity8_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_Activity5Note(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.writeNote)).perform(click());
        onView(withId(R.id.activity9_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_Activity5Details(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.details)).perform(click());
        onView(withId(R.id.activity6_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_selectResidentFromList(){

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
        onView(withId(R.id.activity5_Layout)).check(matches(isDisplayed()));

    }

    @Test
    public  void  test_Activity5Delete(){
        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(1).perform(click());
        onView(withId(R.id.deleteResidentButton)).perform(click());
        onView(withId(R.id.activity4_Layout)).check(matches(isDisplayed()));
    }


    @After
    public void tearDown() throws Exception {
        activity4 = null;
    }


}