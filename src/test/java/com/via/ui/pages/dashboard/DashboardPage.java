package com.via.ui.pages.dashboard;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.via.ui.pages.base.BaseAuthenticatedPage;

public class DashboardPage extends BaseAuthenticatedPage<DashboardPage> {
    public static final String STATS_CARD_TOTAL_REVENUE_TITLE = "//h2[text() = 'Total revenue']";
    public static final String STATS_CARD_TOTAL_SUBSCRIBERS_TITLE = "//h2[text() = 'Total subscribers']";
    public static final String STATS_CARD_TOTAL_MESSAGES_SENT_TITLE = "//h2[text() = 'Total messages sent']";
    public static final String STATS_CARD_ORDERS_GENERATED_TITLE = "//h2[text() = 'Orders generated']";
    public static final String STATS_CARD_NEW_SUBSCRIBERS_TITLE = "//h2[text() = 'New subscribers']";
    public static final String STATS_CARD_RECENT_CAMPAIGNS_TITLE = "//h2[text() = 'Recent campaigns']";
    public static final String STATS_CARD_TOP_JOURNEYS_TITLE = "//h2[text() = 'Top journeys']";

    public DashboardPage(Page page) {
        initialize(page, environmentConfiguration.stageAccountPath());
    }

    @Override
    public DashboardPage navigate() {
        page.navigate(url);
        return this;
    }

    @Override
    public String getCurrentUrl() {
        return page.url();
    }

    @Override
    public Locator getPageElement(String elementLocatorString) {
        return getPageElementWithWait(page, elementLocatorString);
    }
}
