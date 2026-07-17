package com.learnautomation.playwright.base;

import com.microsoft.playwright.Page;

public class BasePage {
	
	protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

}
