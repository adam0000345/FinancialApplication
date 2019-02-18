package com.example.finance.googlesheetsexample;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FirstScreenToShowMenuTest {

    @Rule
    public ActivityTestRule<FirstScreenToShowMenu> mActivityTestRule = new ActivityTestRule<>(FirstScreenToShowMenu.class);

    @Test
    public void firstScreenToShowMenuTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.content_frametitle),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction WACCDetailedTest  = onView(withText("WACCDetailed"));
        WACCDetailedTest.perform(click());

        ViewInteraction appCompatEditText0  = onView(withText("WACCDetailed"));
        appCompatEditText0.perform(click());



        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                        1),
                                0),
                        isDisplayed()));
        floatingActionButton.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.content_frametitle),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsCompanyNameInput),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                1)));
        appCompatEditText.perform(scrollTo(), replaceText("test"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                6)));
        appCompatEditText2.perform(scrollTo(), replaceText("4"));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue), withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText3.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearValue), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        appCompatEditText4.perform(scrollTo(), replaceText("1990"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearValue), withText("1990"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearRevenueValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                8)));
        appCompatEditText6.perform(scrollTo(), replaceText("100.00"));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearRevenueValue), withText("100.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                10)));
        appCompatEditText8.perform(scrollTo(), replaceText("4.00"));

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue), withText("4.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                10),
                        isDisplayed()));
        appCompatEditText9.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsInitialEBITValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                24)));
        appCompatEditText10.perform(scrollTo(), replaceText(".00"));

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsInitialEBITValue), withText(".00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                24),
                        isDisplayed()));
        appCompatEditText11.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsInitialEBITValue), withText(".00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                24)));
        appCompatEditText12.perform(scrollTo(), replaceText("3.00"));

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsInitialEBITValue), withText("3.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                24),
                        isDisplayed()));
        appCompatEditText13.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatTextView = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsOperatingNWC), withText("Operating NWC (Non-cash working capital) as % revenue"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                19)));
        appCompatTextView.perform(scrollTo(), click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsStraightLineValue), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                28)));
        appCompatEditText14.perform(scrollTo(), replaceText(""));

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsStraightLineValue),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                28),
                        isDisplayed()));
        appCompatEditText15.perform(closeSoftKeyboard());

        pressBack();

        pressBack();

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsStraightLineValue),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                28)));
        appCompatEditText16.perform(scrollTo(), replaceText("3"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsTaxRateValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                29)));
        appCompatEditText17.perform(scrollTo(), replaceText("5.00"));

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsTaxRateValue), withText("5.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                29),
                        isDisplayed()));
        appCompatEditText18.perform(closeSoftKeyboard());

        pressBack();

        pressBack();

        ViewInteraction appCompatTextView2 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsTaxRate), withText("Tax rate (T; %)"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                21)));
        appCompatTextView2.perform(scrollTo(), click());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsCapitalExpenditureValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                26)));
        appCompatEditText19.perform(scrollTo(), replaceText("5.00"));

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsCapitalExpenditureValue), withText("5.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                26),
                        isDisplayed()));
        appCompatEditText20.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                30)));
        appCompatEditText21.perform(scrollTo(), replaceText("1.00"));

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue), withText("1.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                30),
                        isDisplayed()));
        appCompatEditText22.perform(closeSoftKeyboard());

        pressBack();

        pressBack();

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue), withText("1.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                30)));
        appCompatEditText23.perform(scrollTo(), replaceText("10.00"));

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue), withText("10.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                30),
                        isDisplayed()));
        appCompatEditText24.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction floatingActionButton2 = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main_content),
                                        1),
                                0),
                        isDisplayed()));
        floatingActionButton2.perform(click());

        ViewInteraction appCompatImageButton3 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.content_frametitle),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton3.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}