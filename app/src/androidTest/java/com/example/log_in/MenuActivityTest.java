package com.example.log_in;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.DatePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;

public class MenuActivityTest {
    @Rule
    public ActivityTestRule<MenuActivity> menuActivityTestRule = new ActivityTestRule<>(MenuActivity.class);
    MenuActivity menuActivity;
    String firstName,lastName, DOB;
    double weight, height;


    @Before
    public void setUp() throws Exception {
        menuActivity = menuActivityTestRule.getActivity();
    }


    @Test
    public  void  testFragments(){
        onView(withId(R.id.nav_list)).perform(click());
        onView(withId(R.id.nav_new)).perform(click());
        onView(withId(R.id.nav_home)).perform(click());
    }

    @Test
    public  void  test_Activity5Questionair(){
        onView(withId(R.id.nav_list)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.fg_listview)).atPosition(0).perform(click());
        onView(withId(R.id.questionair)).perform(click());
        onView(withId(R.id.activity7_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_Activity5QuestionairToActivity8(){
        onView(withId(R.id.nav_list)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.fg_listview)).atPosition(0).perform(click());
        onView(withId(R.id.questionair)).perform(click());

        for (int i = 0 ; i < 17; i++) {
            onView(withId(R.id.choiceYes)).perform(click());
        }

        onView(withId(R.id.floatingActionButton)).perform(click());
        onView(withId(R.id.menuActivity_Layout)).check(matches(isDisplayed()));
    }

    @Test
    public  void  test_Activity5Note(){
        onView(withId(R.id.nav_list)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.fg_listview)).atPosition(0).perform(click());
        onView(withId(R.id.writeNote)).perform(click());
        onView(withId(R.id.activity9_Layout)).check(matches(isDisplayed()));
        onView(withId(R.id.goBackButton)).perform(click());
    }

    @Test
    public  void  test_Activity6Details(){
        onView(withId(R.id.nav_list)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.fg_listview)).atPosition(0).perform(click());
        onView(withId(R.id.details)).perform(click());
        onView(withId(R.id.activity6_Layout)).check(matches(isDisplayed()));
        onView(withId(R.id.detailsConfirmButton))
                .perform(scrollTo(),click());
    }

    @Test
    public  void  test_selectResidentFromList(){
        onView(withId(R.id.nav_list)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.fg_listview)).atPosition(0).perform(click());
        onView(withId(R.id.activity5_Layout)).check(matches(isDisplayed()));

    }

    @Test
    public  void  test_Activity5Delete(){
        onView(withId(R.id.nav_list)).perform(click());
        onData(anything()).inAdapterView(withId(R.id.fg_listview)).atPosition(1).perform(click());
        onView(withId(R.id.deleteResidentButton)).perform(click());
        onView(withId(android.R.id.button1)).perform((click()));
        onView(withId(R.id.menuActivity_Layout)).check(matches(isDisplayed()));
    }




    @After
    public void tearDown() throws Exception {
        menuActivity = null;
    }
}