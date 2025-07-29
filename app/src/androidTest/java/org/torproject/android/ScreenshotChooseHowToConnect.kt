package org.torproject.android


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import tools.fastlane.screengrab.Screengrab
import tools.fastlane.screengrab.locale.LocaleTestRule

class ScreenshotChooseHowToConnect : BaseScreenshotTest() {

    @get:Rule
    var mActivityScenarioRule = ActivityScenarioRule(OrbotActivity::class.java)


    @Test
    fun screenshotChooseHowToConnect() {
        onView(withId(R.id.tvConfigure)).perform(click())
        onView(withId(R.id.rbDirect)).isVisible()
        Screengrab.screenshot("B-choose-how")
    }
}
