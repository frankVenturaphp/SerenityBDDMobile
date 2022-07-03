package com.bdd.stepdefinitions;

import com.bdd.pageobjects.ContactDetail;
import com.bdd.pageobjects.ContactSearch;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

public class MyUserSteps {

    @Steps
    ContactDetail contactDetail;
    ContactSearch contactSearch;

    public MyUserSteps(WebDriver driver) {
        contactDetail = new ContactDetail(driver);
        contactSearch = new ContactSearch(driver);

    }

    @Step
    public void searchFor(String searchText) {
        contactSearch.search(searchText);
    }

    @Step
    public String getResult() {
        String searchResult = contactSearch.getFirstSearchResult();
        return searchResult;
    }
}
