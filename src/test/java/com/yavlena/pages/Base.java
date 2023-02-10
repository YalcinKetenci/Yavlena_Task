package com.yavlena.pages;

import com.yavlena.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Base {

    public Base(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement searchButton;


}
