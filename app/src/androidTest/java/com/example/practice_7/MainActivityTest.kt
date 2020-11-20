package com.example.practice_7



import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
public class MainActivityTest {

    //public var activityRule = ActivityTestRule(tested::class.java)
    @get:Rule
    var activityRule: ActivityScenarioRule<tested>
            = ActivityScenarioRule(tested::class.java)



    @Test
    public fun OneRootUI() {

        onView(withId(R.id.aInput)).perform(typeText("2"));
        onView(withId(R.id.bInput)).perform(typeText("4"));
        onView(withId(R.id.cInput)).perform(typeText("2"), closeSoftKeyboard());

        onView(withId(R.id.calcButt)).perform(click());

        onView(withId(R.id.x1res)).check(matches(withText("-1.0")))

    }

    @Test
    public fun ThoRootUI() {

        onView(withId(R.id.aInput)).perform(typeText("1"));
        onView(withId(R.id.bInput)).perform(typeText("17"));
        onView(withId(R.id.cInput)).perform(typeText("-18"), closeSoftKeyboard());

        onView(withId(R.id.calcButt)).perform(click());

        onView(withId(R.id.x1res)).check(matches(withText("1.0")))
        onView(withId(R.id.x2res)).check(matches(withText("-18.0")))

    }

    @Test
    public fun NotRootUI() {

        onView(withId(R.id.aInput)).perform(typeText("1"));
        onView(withId(R.id.bInput)).perform(typeText("1"));
        onView(withId(R.id.cInput)).perform(typeText("1"), closeSoftKeyboard());

        onView(withId(R.id.calcButt)).perform(click());

        onView(withId(R.id.x1res)).check(matches(withText("")))
        onView(withId(R.id.x2res)).check(matches(withText("")))
    }

    @Test
    public fun NotSquareUI() {

        onView(withId(R.id.aInput)).perform(typeText("0"));
        onView(withId(R.id.bInput)).perform(typeText("5"));
        onView(withId(R.id.cInput)).perform(typeText("10"), closeSoftKeyboard());

        onView(withId(R.id.calcButt)).perform(click());

        onView(withId(R.id.aInput)).check(matches(withText("0")))
    }

}