package UI.step_definitions;

import UI.pages.LoginPage;
import UI.utilities.BrowserUtils;
import UI.utilities.ConfigurationReader;
import UI.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;



public class Login_StepDefinitions {

      LoginPage loginPage = new LoginPage();

    @Given("User has navigated to the Swag Labs URL")
    public void user_has_navigated_to_the_swag_labs_url() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @Given("User verifies login page is displayed")
    public void userVerifiesLoginPageIsDisplayed() {
        String expectedTitle = "Swag Labs";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("User enter valid {string} and {string}")
    public void userEnterValidAnd(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
    }

    @And("User click the login button for valid data")
    public void userClickTheLoginButtonForValidData() {
        loginPage.loginButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("can see Swag Labs title at the top and in the middle of the page")
    public void can_see_swag_labs_title_at_the_top_and_in_the_middle_of_the_page() {
        // String expectedTitle= "Swag Labs";
        // String actualTitle =Driver.getDriver().getTitle();
        // Assert.assertEquals(actualTitle,expectedTitle);// BrowserUtils.waitFor(3);
        String title = Driver.getDriver().getTitle();
        System.out.println("title  =  " + title);
        BrowserUtils.waitFor(3);
    }

    @When("User enter invalid {string} and {string}")
    public void userEnterInvalidAnd(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
    }

    @And("User click the login button for invalid data")
    public void userClickTheLoginButtonForInvalidData() {
        loginPage.loginButton.click();
    }

    @Then("can see message: Epic sadface: Sorry, this user has been locked out.")
    public void canSeeMessageEpicSadfaceSorryThisUserHasBeenLockedOut() {
        loginPage.errMesage.isDisplayed();
        System.out.println("Is displayed: Epic sadface: Sorry, this user has been locked out.");
        BrowserUtils.waitFor(2);
    }

    @When("User enter problem {string} and {string}")
    public void userEnterProblemAnd(String username, String password) {
        loginPage.inputUsername.sendKeys(username);
        loginPage.inputPassword.sendKeys(password);
    }

    @And("User click the login button for problem data")
    public void userClickTheLoginButtonForProblemData() {
        loginPage.loginButton.click();
    }

    @Then("the images corresponding to the products cannot be seen")
    public void the_images_corresponding_to_the_products_cannot_be_seen() {

        //  Assert.assertEquals(loginPage.actualImage, loginPage.expectedImage);
        BrowserUtils.waitFor(2);

        // loginPage.expectedImage.isDisplayed();

        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        Boolean imgPresent = (Boolean) (js.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", loginPage.expectedImage));

        if (!imgPresent) {
            System.out.println("Image is present");
        } else {
            System.out.println("Image is not present");
        }


        /**  Conclusions
         *    Logging in can also be done using configuration.properties,
         *    by using data from it in json format...
         *    being the most used and accepted mode of operation:
         *    using loginWithConfig() method;
         */

       Driver.getDriver().close();

    }
}
