package UI.step_definitions;

import UI.pages.AddDeletePage;
import UI.pages.LoginPage;
import UI.utilities.BrowserUtils;
import UI.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddDelete_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    AddDeletePage addDeletePage = new AddDeletePage();


    @When("User enter the valid {string} and {string}")
    public void userEnterTheValidAnd(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        BrowserUtils.waitFor(1);
    }

    @When("User click on the login button with valids data")
    public void user_clic_on_the_locin_button_with_valid_data() {
        loginPage.loginButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("can see Swag Labs title at the top in the middle of the page")
    public void can_see_swag_labs_title_at_the_top_in_the_middle_of_the_page() {
        String title = Driver.getDriver().getTitle();
        System.out.println("title  =  " + title);
    }

    @When("User click on the Add to Cart button")
    public void user_click_on_the_add_to_cart_button() {
        addDeletePage.addToCartBttn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("User must see the product added in the Cart and the related specifications")
    public void user_must_see_the_product_added_in_the_cart_and_the_related_specifications() {
        System.out.println("cartIcon.getText() = " + addDeletePage.cartIcon.getText());
    }

    @When("User click on the cart icon")
    public void user_click_on_the_cart_icon() {
        addDeletePage.cartIcon.click();
        BrowserUtils.waitFor(1);
    }

    @Then("User can see cart page")
    public void user_can_see_cart_page() {
        System.out.println("add_deletePage.cartPageHeader.isDisplayed() = " + addDeletePage.cartPageHeader.isDisplayed());
    }

    @Then("can see specifications related with the product added last time,about: name product,specifications,price")
    public void can_see_specifications_related_with_the_product_added_last_time_about_name_product_specifications_price() {
        System.out.println("add_deletePage.prodName.isDisplayed() = " + addDeletePage.prodName.isDisplayed());
        System.out.println("add_deletePage.prodDescription.isDisplayed() = " + addDeletePage.prodDescription.isDisplayed());
        System.out.println("add_deletePage.prodPrice.isDisplayed() = " + addDeletePage.prodPrice.isDisplayed());
        BrowserUtils.waitFor(1);
    }

    @When("User click on checkout button")
    public void userClickOmCheckoutButton() {
        addDeletePage.checkOutButton.click();
        BrowserUtils.waitFor(1);
    }

    @And("verifies Checkout: Your Information is displayed")
    public void verifiesCheckoutYourInformationIsDisplayed() {
        System.out.println("add_deletePage.CheckoutYourInformation.isDisplayed() = " + addDeletePage.CheckoutYourInformation.isDisplayed());
    }

    @And("will verify all boxes on the page and fill with data")
    public void willVerifyAllBoxesOnThePageAndFillWithData() {
        addDeletePage.checkOutButtonFirstNume.sendKeys("Glitia");
        addDeletePage.checkOutButtonLastName.sendKeys("Madalin");
        addDeletePage.checkOutButtonZipCode.sendKeys("420222");
        BrowserUtils.waitFor(1);
    }

    @And("click on Continue button")
    public void clickOnContinueButton() {
        addDeletePage.continueBttn.click();
    }

    @And("verifies checkoutPageHeader is displayed")
    public void verifiesCheckoutPageHeaderIsDisplayed() {
        System.out.println("add_deletePage.checkoutPageHeader.isDisplayed() = " + addDeletePage.checkoutPageHeader.isDisplayed());
    }

    @And("click on Finish button")
    public void clickOnFinishButton() {
        addDeletePage.finishBttn.click();
        BrowserUtils.waitFor(1);
    }

    @Then("checkOut Complete page wil be displayed")
    public void checkoutCompletePageWilBeDisplayed() {
        System.out.println("add_deletePage.checkoutPageComplete.isDisplayed() = " + addDeletePage.checkoutPageComplete.isDisplayed());
    }

    @And("a succes message will be displayed")
    public void succesMessageWillBeDisplayed() {
        addDeletePage.succesMessage.isDisplayed();
    }

    @When("User delete the product from the cart")
    public void userDeleteTheProductFromTheCart() {
        addDeletePage.removeProdBtn1.click();
        BrowserUtils.waitFor(1);
    }

    @Then("can t see no one product in the cart")
    public void canTSeeProductInTheCart() {
        System.out.println("add_deletePage.cartIcon.getText() = " + addDeletePage.cartIcon.getText());
    }

    @When("User enter a valid {string} and {string}")
    public void user_enter_a_valid_and(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
        BrowserUtils.waitFor(1);
    }

    @When("User click on the login button with valid data")
    public void user_click_on_the_login_button_with_valid_data() {
        loginPage.loginButton.click();
    }

    @When("User click another Add to Cart button")
    public void user_click_another_add_to_cart_button() {
        //Driver.getDriver().navigate()
        addDeletePage.addToCartBttn2.click();
        BrowserUtils.waitFor(1);
    }

    @Then("must see another added product added and it s related specifications")
    public void must_see_another_added_product_added_and_it_s_related_specifications() {
        System.out.println("add_deletePage.cartIcon2.getText() = " + addDeletePage.cartIcon.getText());
    }

    @When("User click the cart icon")
    public void user_click_the_cart_icon() {
        addDeletePage.cartIcon.click();
    }

    @Then("User will be transferred to the cart page")
    public void user_will_be_transferred_to_the_cart_page() {
        addDeletePage.cartHeader2.isDisplayed();
        BrowserUtils.waitFor(1);
    }

    @Then("User can see two products and the related specifications of latest added product and bag specifications")
    public void user_can_see_two_products_and_the_related_specifications_of_latest_added_product_and_bag_specifications() {
        System.out.println("add_deletePage.nameProd1.isDisplayed() = " + addDeletePage.nameProd1.isDisplayed());
        System.out.println("add_deletePage.specificationsProd1.isDisplayed() = " + addDeletePage.specificationsProd1.isDisplayed());
        System.out.println("add_deletePage.priceProd2.isDisplayed() = " + addDeletePage.priceProd1.isDisplayed());
        BrowserUtils.waitFor(1);
    }

    @Then("User can see two products and the related specifications of latest added product and bike specifications")
    public void user_can_see_two_products_and_the_related_specifications_of_latest_added_product_and_bike_specifications() {
        System.out.println("add_deletePage.nameProd1.isDisplayed() = " + addDeletePage.nameProd2.isDisplayed());
        System.out.println("add_deletePage.specificationsProd1.isDisplayed() = " + addDeletePage.specificationsProd2.isDisplayed());
        System.out.println("add_deletePage.priceProd2.isDisplayed() = " + addDeletePage.priceProd2.isDisplayed());
        BrowserUtils.waitFor(1);
    }

    @When("User delete second product from cart")
    public void userDeleteSecondProductFromCart() {
        addDeletePage.removeProdBtn2.click();
        // add_deletePage.removeProdBtn2.isSelected();
        BrowserUtils.waitFor(1);
    }

    @And("User delete first product from cart")
    public void userDeleteFirstProductFromCart() {
        addDeletePage.removeProdBtn1.click();
        //add_deletePage.removeProdBtn2.isSelected();
        BrowserUtils.waitFor(1);
    }


    @Then("User can t see product in the cart")
    public void userCanTSeeProductInTheCart() {
        // BrowserUtils.verifyElementDisplayed(add_deletePage.deletenameProd1);
        System.out.println("add_deletePage.cartIcon.getText() = " + addDeletePage.cartIcon.getText());

    /**
     How to check the object existance

     //Max_TimeOut variable holds the time in seconds for the maximum time to wait
     before the control flows toNoSuchElementException block.

     int Max_TimeOut=60;
     public boolean isObjExists(WebDriver driver,By locator)
     {
       //I am putting the code in try catch because if the object does not exist,
     //it throws exception.

     try
      {
     //Before throwing exception, it will wait for the Max_timeout specified

     WebDriverWait wait=new WebDriverWait(driver,Max_TimeOut);
     wait.until(ExpectedConditions.elementToBeClickable(locator));
     //If the element found, then it returns true
     return true;
     }
     catch(NoSuchElementException exception)
     {
     //If the element is not found, then it returns false
     return false;
      }
     }

    */

    }
}

