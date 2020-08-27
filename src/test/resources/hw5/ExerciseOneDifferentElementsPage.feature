Feature: Different Elements Page Select elements feature
  In order to select different elements
  As a logged in user
  I want to press selection buttons and see the result in log window


  Scenario: Different Elements Page Test
    Given I open JDI GitHub site
    And I check page title
    And I login as user "Roman Iovlev"
    And I check userName
    And I click on "Service" button in Header
    And I click on 'Different elements' button in Service dropdown
    When I select 'Water' checkbox on the Different Elements Page
    And I select 'Wind' checkbox on the Different Elements Page
    And I select 'Selen' radiobutton on the Different Elements Page
    And I click on color dropdown menu on the Different Elements Page
    And I click on 'Yellow' button in color dropdown on the Different Elements Page
    Then log rows should consist of the following values:
      |water: condition changed to true |
      |wind: condition changed to true  |
      |metal: value changed to selen    |
      |colors: value changed to yellow  |



