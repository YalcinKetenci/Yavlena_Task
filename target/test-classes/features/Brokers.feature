@brokersAll
Feature: Brokers

     @scenario1
     Scenario: Display all the brokers
      Given the user on the brokers page
      When the user tap on the Зареди още button to see all the brokers
      Then the user should be able to see all the brokers


     @scenario2
     Scenario: Search a broker and verify address, 2 phone numbers, property number are displayed.
      Given the user on the brokers page
      When the user tap on the Зареди още button to see all the brokers
      And the user search "Александър Андреев". broker
      Then only the searched broker should be displayed

     @scenario3
     Scenario: Verify the address, 2 phone numbers, property number information are displayed for a searched broker
      Given the user on the brokers page
      When the user tap on the Зареди още button to see all the brokers
      And the user search "Александър Андреев". broker
      Then the address, two phone numbers, property number information should be displayed

     @scenario4
     Scenario: Check the scenario2 and scenario3 for all the brokers
      Given the user on the brokers page
      When the user tap on the Зареди още button to see all the brokers
      Then only the searched broker should be displayed along with the address, two phone numbers, property number information - for all the brokers




