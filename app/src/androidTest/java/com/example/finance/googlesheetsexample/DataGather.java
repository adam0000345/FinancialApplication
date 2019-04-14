package com.example.finance.googlesheetsexample;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DataGather {

    @Rule
    public ActivityTestRule<FirstScreenToShowMenu> mActivityTestRule = new ActivityTestRule<>(FirstScreenToShowMenu.class);

    @Test
    public void dataGather() {
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

        ViewInteraction floatingActionButton = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
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
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                1)));
        appCompatEditText.perform(scrollTo(), replaceText("test"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearValue), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                4)));
        appCompatEditText2.perform(scrollTo(), replaceText("1990"));

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearValue), withText("1990"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText3.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                6)));
        appCompatEditText4.perform(scrollTo(), replaceText("4"));

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsNumberForecastPeriodsValue), withText("4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearRevenueValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                8)));
        appCompatEditText6.perform(scrollTo(), replaceText("100.00"));

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearRevenueValue), withText("100.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText7.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                10)));
        appCompatEditText8.perform(scrollTo(), replaceText("4.00"));

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsAnnualRevenueGrowthRateValue), withText("4.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.scrollviewfreecashflow),
                                        0),
                                10),
                        isDisplayed()));
        appCompatEditText9.perform(closeSoftKeyboard());

        pressBack();

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

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalCashValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        appCompatEditText10.perform(scrollTo(), replaceText("10.00"));

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalCashValue), withText("10.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText11.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalDebtValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        appCompatEditText12.perform(scrollTo(), replaceText("3.00"));

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalDebtValue), withText("3.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText13.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalMarketCapValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                8)));
        appCompatEditText14.perform(scrollTo(), replaceText("30.00"));

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalMarketCapValue), withText("30.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText15.perform(closeSoftKeyboard());

        pressBack();

        pressBack();

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalNumberOfSharesValue), withText("0"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                20)));
        appCompatEditText16.perform(scrollTo(), replaceText(""));

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalNumberOfSharesValue),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                20),
                        isDisplayed()));
        appCompatEditText17.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalNumberOfSharesValue),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                20)));
        appCompatEditText18.perform(scrollTo(), replaceText("55"), closeSoftKeyboard());

        pressBack();

        pressBack();

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalRiskFreeRateValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                10)));
        appCompatEditText19.perform(scrollTo(), replaceText("5.00"));

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalRiskFreeRateValue), withText("5.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                10),
                        isDisplayed()));
        appCompatEditText20.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                19)));
        appCompatEditText21.perform(scrollTo(), replaceText("5.00"));

        ViewInteraction appCompatEditText22 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue), withText("5.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                19),
                        isDisplayed()));
        appCompatEditText22.perform(closeSoftKeyboard());

        pressBack();

        pressBack();

        ViewInteraction floatingActionButton3 = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.main_content),
                                        1),
                                0),
                        isDisplayed()));
        floatingActionButton3.perform(click());

        ViewInteraction appCompatImageButton4 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.content_frametitle),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton4.perform(click());

        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalROICValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText23.perform(replaceText("5.00"));

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalROICValue), withText("5.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText24.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalReinvestmentRateValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText25.perform(replaceText("5.00"));

        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalReinvestmentRateValue), withText("5.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                6),
                        isDisplayed()));
        appCompatEditText26.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalGrowthRateValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText27.perform(replaceText("3.00"));

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalGrowthRateValue), withText("3.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                7),
                        isDisplayed()));
        appCompatEditText28.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalWACCValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText29.perform(replaceText("3.00"));

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalWACCValue), withText("3.00"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.content_frame),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText30.perform(closeSoftKeyboard());

        pressBack();
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
