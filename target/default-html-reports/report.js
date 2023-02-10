$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Brokers.feature");
formatter.feature({
  "name": "Brokers",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@brokersAll"
    }
  ]
});
formatter.scenario({
  "name": "Check the scenario2 and scenario3 for all the brokers",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@brokersAll"
    },
    {
      "name": "@scenario4"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user on the brokers page",
  "keyword": "Given "
});
formatter.match({
  "location": "com.yavlena.step_definitions.Brokers.the_user_on_the_brokers_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user tap on the Зареди още button to see all the brokers",
  "keyword": "When "
});
formatter.match({
  "location": "com.yavlena.step_definitions.Brokers.the_user_tap_on_the_Зареди_още_button_to_see_all_the_brokers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "only the searched broker should be displayed along with the address, two phone numbers, property number information - for all the brokers",
  "keyword": "Then "
});
formatter.match({
  "location": "com.yavlena.step_definitions.Brokers.only_the_searched_broker_should_be_displayed_along_with_the_address_two_phone_numbers_property_number_information_for_all_the_brokers()"
});
