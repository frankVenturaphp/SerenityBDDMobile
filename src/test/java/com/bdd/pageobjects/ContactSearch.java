package com.bdd.pageobjects;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactSearch extends Page {

    public ContactSearch(WebDriver driver) { super (driver); }

    @FindBy(id = "main_search")
    public WebElement searchField;

    @FindBy(id = "name")
    public WebElement firstSearchResultName;

    @Step
    public void search(String name) {
        searchField.sendKeys(name);
    }

    @Step
    public String getFirstSearchResult() {
        return firstSearchResultName.getText();
    }

}
