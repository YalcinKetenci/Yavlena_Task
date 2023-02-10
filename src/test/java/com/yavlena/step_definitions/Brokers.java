package com.yavlena.step_definitions;

import com.yavlena.pages.Broker;
import com.yavlena.utilities.BrowserUtils;
import com.yavlena.utilities.ConfigurationReader;
import com.yavlena.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Brokers {

    Broker broker = new Broker();
    private String brokerName;
    private List<String> brokerNames;

    WebDriverWait wait = new WebDriverWait(Driver.get(),10);
    @Given("the user on the brokers page")
    public void the_user_on_the_brokers_page() {
        //Launch the browser that defined in the configuration.properties file
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user tap on the Зареди още button to see all the brokers")
    public void the_user_tap_on_the_Зареди_още_button_to_see_all_the_brokers() throws InterruptedException {

        //Click "Зареди още" button to load/display all the brokers
        BrowserUtils.waitFor(2);
        broker.brokerExtBtn.click();

        //Wait until last broker displayed
        broker.waitUntilOrderedBrokerIsDisplayed(broker.getNumberOfTotalBrokers(),3);

    }

    @Then("the user should be able to see all the brokers")
    public void the_user_should_be_able_to_see_all_the_brokers() {

        //Verify the total number of brokers matches the number of displayed brokers
        Assert.assertEquals(broker.getNumberOfTotalBrokers(),broker.getNumberOfDisplayedBrokers());

    }


    @When("the user search {string}. broker")
    public void the_user_search_broker(String brokerName) {


        //get broker name and assign as instance variable
        this.brokerName = brokerName;

        //paste the broker name to the search box
        broker.brokerSearchBox.sendKeys(brokerName);

        //press search button
        broker.brokerSearchButton.click();


        BrowserUtils.waitFor(1);

        //clear the search box
        broker.brokerSearchBox.clear();
    }


    @Then("only the searched broker should be displayed")
    public void only_the_searched_broker_should_be_displayed() {

        int displayedBrokers_actualResult = broker.getNumberOfDisplayedBrokers();
        int expectedBrokers = 1;

        String searchedBroker_expectedResult = brokerName;
        BrowserUtils.waitFor(1);
        String returningBroker_actualResult = broker.getNameOfTheBroker(broker.listOfAllDisplayedBrokers.size());

        //Verify number of displayed brokers - it should be only one
        Assert.assertEquals(expectedBrokers,displayedBrokers_actualResult);

        //Verify the returning broker should be the searched broker
        Assert.assertEquals(searchedBroker_expectedResult,returningBroker_actualResult);


    }


    @Then("the address, two phone numbers, property number information should be displayed")
    public void the_address_two_phone_numbers_property_number_information_should_be_displayed() {

        //Verify the 1. phone number should be displayed for the searched broker
        Assert.assertTrue(broker.getBroker1PhoneNumberElement(broker.getNameOfTheBroker(broker.listOfAllDisplayedBrokers.size())).isDisplayed());

        //Verify the 2. phone number should be displayed for the searched broker.
        Assert.assertTrue(broker.getBroker2PhoneNumberElement(broker.getNameOfTheBroker(broker.listOfAllDisplayedBrokers.size())).isDisplayed());

        //Verify the address should be displayed for the searched broker
        Assert.assertTrue(broker.getBrokerAddressElement(broker.getNameOfTheBroker(broker.listOfAllDisplayedBrokers.size())).isDisplayed());

        //Verify the property number should be displayed for the searched broker
        Assert.assertTrue(broker.getBrokerPropertyNumberElement(broker.getNameOfTheBroker(broker.listOfAllDisplayedBrokers.size())).isDisplayed());


    }


    @Then("only the searched broker should be displayed along with the address, two phone numbers, property number information - for all the brokers")
    public void only_the_searched_broker_should_be_displayed_along_with_the_address_two_phone_numbers_property_number_information_for_all_the_brokers() {
       int totalNumberOfBlockers = broker.getNumberOfTotalBrokers();
       int checkedBrokers = 0;

       //for look to check all the displayed broker
                                        //this method stores the names of displayed brokers
        for (String brokerName :broker.getTheListOfAllTheDisplayedBrokerNames()) {

            //search a specific broker by passing broker name
            the_user_search_broker(brokerName);

            //Verify the returning broker should be the searched broker
            only_the_searched_broker_should_be_displayed();

            //Verify the 2 phone numbers, address and property number should be displayed for the searched broker
            the_address_two_phone_numbers_property_number_information_should_be_displayed();

        ++checkedBrokers;
        }
        //Verify all the brokers have been checked
        Assert.assertEquals(totalNumberOfBlockers,checkedBrokers);
        System.out.println(checkedBrokers+"/"+totalNumberOfBlockers + " brokers have been checked successfully");
    }

}
