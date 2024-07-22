package com.example.computer_calc;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.SeekBar;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestCase() throws InterruptedException {
        String item = "Процессор AMD Athlon 3000G OEM [AM4, 2 x 3.5 ГГц, L2 - 1 МБ, L3 - 4 МБ, 2 х DDR4-2666 МГц, AMD Radeon Vega 3, TDP 35 Вт]";
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(item))).perform(click());
        onView(withId(R.id.proc_price)).check(matches(withText("4499.0 руб.")));
        onView(withId(R.id.am5)).perform(click());
        onView(withId(R.id.motherboard_price)).check(matches(withText("9899.0 руб.")));
        onView(withId(R.id.seekbar)).perform(setProgress(3));
        onView(withId(R.id.mem_price)).check(matches(withText("3299.0 руб.")));
        onView(withId(R.id.periferal)).perform(click());
        onView(withId(R.id.per_price)).check(matches(withText("15000.0 руб.")));
        onView(withId(R.id.res)).check(matches(withText("Итоговая цена: 32697.0 рублей.")));
    }

    public static ViewAction setProgress(final int progress) {
        return new ViewAction() {
            @Override
            public void perform(UiController uiController, View view) {
                ((SeekBar) view).setProgress(progress);
            }

            @Override
            public String getDescription() {
                return "Set a progress";
            }

            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(SeekBar.class);
            }
        };
    }
}
