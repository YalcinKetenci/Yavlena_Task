package com.yavlena.pages;

import com.yavlena.utilities.Driver;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class Broker extends Base {

    public Broker() {
        PageFactory.initElements(Driver.get(), this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.get(), 5);

    @FindBy(xpath = "//div[@class='load-more-brokers']/a")
    public WebElement brokerExtBtn;

    @FindBy(xpath = "//div[@class='broker-list']/article")
    public List<WebElement> listOfAllDisplayedBrokers;

    @FindBy(xpath = "//*[@id=\"brokers-grid-holder\"]/div/div/article/div/div/div[1]/h3")
    public List<WebElement> listOfAllDisplayedBrokerNameElements;

    @FindBy(xpath = "//a[@class=\"c-hamburger c-hamburger--rot toggle-filter\"]")
    public WebElement brokerHamburgerEllipses;

    @FindBy(xpath = "(//input[@id=\"searchBox\"])[2]")
    public WebElement brokerSearchBox;

    @FindBy(xpath = "(//button[@type=\"submit\"])[2]/..")
    public WebElement brokerSearchButton;

    public Integer getNumberOfDisplayedBrokers() {
        return listOfAllDisplayedBrokers.size();
    }

    public Integer getNumberOfTotalBrokers() {
        return Integer.parseInt(Driver.get().findElement(By.xpath("//div[@class='broker-list-holder xteam-list-wrap']")).getAttribute("data-total-count"));
    }

    public String getNameOfTheBroker(int order) {

        WebElement element = Driver.get().findElement(By.xpath("//*[@id=\"brokers-grid-holder\"]/div/div/article[" + order + "]/div/div/div[1]/h3"));
        wait.until(ExpectedConditions.visibilityOf(element));

        return element.getText();
    }

    public void waitUntilOrderedBrokerIsDisplayed(int order, int second) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), second);

        WebElement element = Driver.get().findElement(By.xpath("//*[@id=\"brokers-grid-holder\"]/div/div/article[" + order + "]"));

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public WebElement getBroker1PhoneNumberElement(int brokerOrder) {

        return Driver.get().findElement(By.xpath("((//*[@id=\"brokers-grid-holder\"])[" + brokerOrder + "]//div[@class=\"tel-group\"]//span[@class=\"tel\"])[1]"));
    }

    public WebElement getBroker1PhoneNumberElement(String brokerName) {

        return Driver.get().findElement(By.xpath("//a[@title=\"" + brokerName + "\"]/../../div[@class=\"tel-group\"]/span[2]"));
    }

    public WebElement getBroker2PhoneNumberElement(int brokerOrder) {

        return Driver.get().findElement(By.xpath("((//*[@id=\"brokers-grid-holder\"])[" + brokerOrder + "]//div[@class=\"tel-group\"]//span[@class=\"tel\"])[2]"));
    }

    public WebElement getBroker2PhoneNumberElement(String brokerName) {

        return Driver.get().findElement(By.xpath("//a[@title=\"" + brokerName + "\"]/../../div[@class=\"tel-group\"]/span[3]"));
    }

    public WebElement getBrokerAddressElement(int brokerOrder) {

        return Driver.get().findElement(By.xpath("//*[@id=\"brokers-grid-holder\"]/div/div/article[" + brokerOrder + "]/div/div/div[1]/h3/../div[@class=\"office\"]"));
    }

    public WebElement getBrokerAddressElement(String brokerName) {

        return Driver.get().findElement(By.xpath("//a[@title=\"" + brokerName + "\"]/../../div/div[@class=\"office\"]"));
    }

    public WebElement getBrokerPropertyNumberElement(int brokerOrder) {

        return Driver.get().findElement(By.xpath("//*[@id=\"brokers-grid-holder\"]/div/div/article[" + brokerOrder + "]/div/div/div[2]/a"));
    }

    public WebElement getBrokerPropertyNumberElement(String brokerName) {

        return Driver.get().findElement(By.xpath("//a[@title=\"" + brokerName + "\"]/../../div[@class=\"position\"]/a"));
    }

    public List<String> getTheListOfAllTheDisplayedBrokerNames(){

        List<String> brokerName = new ArrayList<>();

        for (WebElement element :listOfAllDisplayedBrokerNameElements) {
            brokerName.add(element.getText());
        }

        return brokerName;
    }
}
