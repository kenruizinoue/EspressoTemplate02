package com.kenruizinoue.espressotemplate02

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

    private lateinit var stringToBeTyped: String

    @get: Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Before
    fun initValidString() {
        stringToBeTyped = "Hello world!"
    }

    @Test
    fun sendText() {
        onView(withId(R.id.editText)).perform(typeText(stringToBeTyped), closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText(stringToBeTyped)))
    }
}