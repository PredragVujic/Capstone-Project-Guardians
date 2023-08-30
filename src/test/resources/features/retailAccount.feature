@Regression
Feature: Retail Account Page
​
Background:
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'predrag.vujic@tekschool.us' and password 'Pistaci2023!'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option

@updatePI    
Scenario: Verify User can update Profile Information
    And User update Name 'DragonSODD' and Phone '1937654321'
    And User click on Update button
    Then user profile information should be updated
    
@addPaymentMethod    
Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
    |cardNumber|nameOnCard|expirationMonth|expirationYear|securityCode|
    |9999123443210001|JojoMaTheChmar|12|2025|984|
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added sucessfully'

@editCard 
Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
    |cardNumber|nameOnCard|expirationMonth|expirationYear|securityCode|
    |2222333344441111|JojoMaTheChmar|10|2029|221|
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

@removeCard
Scenario: Verify User can remove Debit or Credit card
    And User click on remove option of card section
    Then payment details should be removed

@addAddress
Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
    |country|fullName|phoneNumber|streetAddress|apt       |city     | state |zipCode   |
    |countryValue|fullNameValue|PhoneValue|stAddress|aptValue|cityValue|stateValue|zipCodeValue|
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

@editAddress
Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And user edit address form with below information
    |country|fullName|phoneNumber|streetAddress|apt       |city     | state |zipCode   |
    |Serbia|Predrag|222-111-2222|34532 Michael Sigma|Suite 543|Hoshimin|Colorado|34432|
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

@removeAddress
Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed