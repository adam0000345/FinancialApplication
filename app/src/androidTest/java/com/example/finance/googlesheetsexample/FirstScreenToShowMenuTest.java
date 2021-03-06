package com.example.finance.googlesheetsexample;


import android.os.SystemClock;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;

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
public class FirstScreenToShowMenuTest {

    //INPUT USED
    //first page default, 1990, 4, 100, revenuegrowth 4, initialperiod 5.00, lastperiodebit, 0.00
    //capex 3%, operating NWC 0% , depreciation rule 3 years, tax rate: 3%, base year depreciation $10.00 million,
    //Cash is $10.00 million, Debt is $2.00 million, Market Cap is $1.00 million, number of shares is 5
    // risk-free rate (%) is 2%, WACC is 2%, Terminal ROIC: 5%, Terminal Reinvestment Rate%: 5%,
    // Term. Growth: 1%, Term WACC: 2%




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

        WACCDetailedTest  = onView(withText("WACCDetailedPageTwo"));
        WACCDetailedTest.perform(click());





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

        WACCDetailedTest  = onView(withText("WACCDetailed"));
        WACCDetailedTest.perform(click());

        WACCDetailedTest  = onView(withText("WACCDetailedFreeCashFlowInputs"));
        WACCDetailedTest.perform(click());

        pressBack();

        //progress dialog is now shown
        //SystemClock.sleep(5000);

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




        //progress dialog is now shown
        //SystemClock.sleep(5000);

        Espresso.onView(ViewMatchers.withId(R.id.scrollviewfreecashflow)).perform(ViewActions.swipeUp());
        Espresso.onView(ViewMatchers.withId(R.id.scrollviewfreecashflow)).perform(ViewActions.swipeUp());
        //SystemClock.sleep(5000);

        //SystemClock.sleep(5000);


        ViewInteraction appCompatEditText12 = onView(allOf(withText("0.00"),withId(R.id.WACCDetailedFreeCashFlowInputsInitialEBITValue)));
        appCompatEditText12.perform(closeSoftKeyboard());
        appCompatEditText12.perform(replaceText("5.00"));


        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsInitialEBITValue), withText("5.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                24),
                        isDisplayed()));
        appCompatEditText13.perform(closeSoftKeyboard());

        //SystemClock.sleep(5000);



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

        //SystemClock.sleep(5000);


        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsStraightLineValue),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                28)));
        appCompatEditText16.perform(scrollTo(), replaceText("3"), closeSoftKeyboard());



        //SystemClock.sleep(5000);

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsTaxRateValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                29)));
        appCompatEditText17.perform(scrollTo(), replaceText("3.00"));

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsTaxRateValue), withText("3.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                29),
                        isDisplayed()));
        appCompatEditText18.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsCapitalExpenditureValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                26)));
        appCompatEditText19.perform(scrollTo(), replaceText("3.00"));

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsCapitalExpenditureValue), withText("3.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                26),
                        isDisplayed()));
        appCompatEditText20.perform(closeSoftKeyboard());



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



        ViewInteraction appCompatEditText23 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue), withText("1.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                30)));
        appCompatEditText23.perform(scrollTo(), replaceText("10.00"));

        //SystemClock.sleep(5000);

        ViewInteraction appCompatEditText24 = onView(
                allOf(withId(R.id.WACCDetailedFreeCashFlowInputsBaseYearDepreciationValue), withText("10.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                30),
                        isDisplayed()));
        appCompatEditText24.perform(closeSoftKeyboard());



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


        WACCDetailedTest  = onView(withText("WACCDetailed"));
        WACCDetailedTest.perform(click());


        WACCDetailedTest  = onView(withText("WACCDetailedPageTerminalValue"));
        WACCDetailedTest.perform(click());

        ViewInteraction appCompatEditText25 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalROICValue), withText("0.00")));
        appCompatEditText25.perform(replaceText("5.00"));


        ViewInteraction appCompatEditText26 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalReinvestmentRateValue), withText("0.00")));
        appCompatEditText26.perform(replaceText("5.00"));

        ViewInteraction appCompatEditText27 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalGrowthRateValue), withText("0.00")));
        appCompatEditText27.perform(replaceText("1.00"));

        ViewInteraction appCompatEditText28 = onView(
                allOf(withId(R.id.WACCDetailedPageTerminalValueTerminalWACCValue), withText("0.00")));
        appCompatEditText28.perform(replaceText("2.00"));

        ViewInteraction floatingActionButtonOne = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                0),
                        isDisplayed()));
        floatingActionButtonOne.perform(click());



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

        WACCDetailedTest  = onView(withText("WACCDetailed"));
        WACCDetailedTest.perform(click());

        WACCDetailedTest  = onView(withText("WACCDetailedPageCostOfCapitalInputs"));
        WACCDetailedTest.perform(click());

        ViewInteraction appCompatEditText29 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalCashValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2)));
        appCompatEditText29.perform(scrollTo(), replaceText("10.00"));

        ViewInteraction appCompatEditText30 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalCashValue), withText("10.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                2),
                        isDisplayed()));
        appCompatEditText30.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText31 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalDebtValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4)));
        appCompatEditText31.perform(scrollTo(), replaceText("2.00"));

        ViewInteraction appCompatEditText32 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalDebtValue), withText("2.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                4),
                        isDisplayed()));
        appCompatEditText32.perform(closeSoftKeyboard());

        ViewInteraction appCompatEditText33 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalMarketCapValue), withText("0.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                8)));
        appCompatEditText33.perform(scrollTo(), replaceText("1.00"));

        ViewInteraction appCompatEditText34 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalMarketCapValue), withText("1.00"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.ScrollView")),
                                        0),
                                8),
                        isDisplayed()));
        appCompatEditText34.perform(closeSoftKeyboard());



        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        Espresso.onView(ViewMatchers.withId(R.id.scrollviewcostofcapital)).perform(ViewActions.swipeUp());


        ViewInteraction appCompatEditText38 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalRiskFreeRateValue), withText("0.00")));
        appCompatEditText38.perform(scrollTo(), replaceText("2.00"));




        ViewInteraction appCompatEditText40 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalWeightedAverageCostOfCapitalValue), withText("0.00")));
        appCompatEditText40.perform(scrollTo(), replaceText("2.00"));

        ViewInteraction appCompatEditText35 = onView(
                allOf(withId(R.id.WACCDetailedPageCostOfCapitalNumberOfSharesValue), withText("0")));
        appCompatEditText35.perform(scrollTo(), replaceText("5"));





        ViewInteraction floatingActionButtonTwo = onView(
                allOf(withId(R.id.fab),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("androidx.coordinatorlayout.widget.CoordinatorLayout")),
                                        1),
                                0),
                        isDisplayed()));
        floatingActionButtonTwo.perform(click());

        ViewInteraction appCompatImageButton5 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withId(R.id.content_frametitle),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton5.perform(click());


        WACCDetailedTest  = onView(withText("WACCDetailed"));
        WACCDetailedTest.perform(click());



        WACCDetailedTest  = onView(withText("WACCDetailedPageResults"));
        WACCDetailedTest.perform(click());

        SystemClock.sleep(5000);

        // First, scroll to the view holder using the isInTheMiddle() matcher.
        onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.scrollToPosition(1));

        SystemClock.sleep(5000);

        // First, scroll to the view holder using the isInTheMiddle() matcher.
        onView(withId(R.id.recyclerview)).perform(RecyclerViewActions.scrollToPosition(2));


        SystemClock.sleep(15000);
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
