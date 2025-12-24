
Feature: login feature
We need validate the login feature of facebook

    @sanity
      Scenario: Validate the login functionality with valid username and password
    Given User should be login page
    When  user enters valid username "Testing@gmail.com"
    And user enters valid password "P2442"
    And Clicks on submit
    
  @regresion
 Scenario Outline: Validate the login functionality with invalid username and password
      Given User should be login page
    When  user enters valid usernameParameter "<username>"
    And user enters valid passwordParameter "<password>"
     And Clicks on submit
     Then System should generate the error message
    And close the browser
    
    Examples: 
      | username  | password |
      | Testing@gmail.com | P23543|
      | Mahesh@gmail.com |  Pfh3738 |
      
      