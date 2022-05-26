Feature: Guest Navigation Flow
  As a user, I want to browse the site, execute adding and removing products from the bag , and validate the impact in
  selected items and total amount

Scenario:
  Given I access "Homepage" page
  When I select the category menu "Harvey Nichols"
  And I select the category sub-menu "Beauty"
  And I select the item at position 1 in list of products
  And I add "1" product to cart by pressing button "ADD TO CART"
  And I close the success message notification
  And I select the category menu "Beauty"
  And I select the category sub-menu "VaVaVoom"
  And I select the item at position 1 in list of products
  And I add "1" product to cart by pressing button "ADD TO CART"
  And I close the success message notification
  And I select the shopping bag button
  And I click "GO TO SHOPPING BAG"
  And validate that I am at "Shopping Bag" page
  And I validate the number of selected products corresponds to my previous selections
  And I validate the total amount corresponds to the sum of my previous selections
  And I remove all products asserting there is no total value or items selected
  Then I access back to "Homepage" page
  And I validate that I am at at the website homepage
