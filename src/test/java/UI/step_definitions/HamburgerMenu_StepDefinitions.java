package UI.step_definitions;

import UI.pages.AddDeletePage;
import UI.pages.HamburgerMenuPage;
import UI.pages.LoginPage;
import UI.utilities.BrowserUtils;
import UI.utilities.ConfigurationReader;
import UI.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HamburgerMenu_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    HamburgerMenuPage hamburgerMenuPage = new HamburgerMenuPage();

    AddDeletePage addDeletePage = new AddDeletePage();


    //BrowserUtils browserUtils =new BrowserUtils();

    @When("User enter valid username")
    public void user_enter_valid_username() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("swag.labs.username"));
    }

    @When("User enter valid password")
    public void user_enter_valid_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("swag.labs.password"));
    }

    @When("User click on the login button")
    public void user_click_on_the_login_button() {
        loginPage.loginButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("User should verify the home page title")
    public void user_should_verify_the_home_page() {
        String expectedTitle = "Swag Labs";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("User click on the Hamburger Menu button")
    public void userClickOnTheHamburgerMenuButton() {
        hamburgerMenuPage.hamburgerBtn.click();
        BrowserUtils.waitFor(1);
    }

    @Then("can see Hamburger menu")
    public void canSeeHamburgerMenu() {
        System.out.println("hamburgerMenuPage.menulist.isDisplayed() = " + hamburgerMenuPage.menulist.isDisplayed());
        BrowserUtils.waitFor(2);
    }

    @When("User click on X button")
    public void userClickOnXButton() {
        hamburgerMenuPage.xbtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("can t see Hamburger menu")
    public void canTSeeHamburgerMenu() {
        // BrowserUtils.verifyElementDisplayed(hamburgerMenuPage.menulist);
        // hamburgerMenuPage.hamburgerBtn.isDisplayed();
        //...............de revazut...................................................
    }

    @When("User click on Hamburger Menu button")
    public void userClickOnHamburgerMenuButton() {
        hamburgerMenuPage.hamburgerBtn.click();
        BrowserUtils.waitFor(2);
    }

    @Then("can see All Items link")
    public void canSeeAllItemsLink() {
        hamburgerMenuPage.allItemsLink.isDisplayed();
    }

    @When("User click on the All Items links")
    public void userClickOnTheAllItemsLinks() {
        hamburgerMenuPage.allItemsLink.click();
    }

    @Then("User can see Swag Labs")
    public void userCanSeeSwagLabs() {
        hamburgerMenuPage.swagLab.isDisplayed();
    }

    @Then("can see About link")
    public void canSeeAboutLink() {
        hamburgerMenuPage.abautLink.isDisplayed();
    }

    @When("User click on the About links")
    public void userClickOnTheAboutLinks() {
        hamburgerMenuPage.abautLink.click();
    }

    @Then("User can see SauceLabs")
    public void userCanSeeSauceLabs() {
        hamburgerMenuPage.sauceLabs.isDisplayed();
    }

    @Then("can see Logout link")
    public void canSeeLogoutLink() {
        hamburgerMenuPage.logoutink.isDisplayed();
    }

    @When("User click on the Logout link")
    public void userClickOnTheLogoutLink() {
        hamburgerMenuPage.logoutink.click();
        BrowserUtils.waitFor(2);
    }

    @Then("User can see Swag Labs title")
    public void userCanSeeSwagLabsTitle() {
        hamburgerMenuPage.swagLabLogoo.isDisplayed();
    }

    @Then("can see Reset App State")
    public void canSeeResetAppState() {
        hamburgerMenuPage.resetAppStorelink.isDisplayed();
    }

    @When("User click on the Reset App State")
    public void userClickOnTheResetAppState() {
        hamburgerMenuPage.resetAppStorelink.click();
    }

    @Then("User can see cart has no one product")
    public void userCanSeeCartHasNoOneProduct() {
        System.out.println("addDeletePage.cartIcon.getText() = " + addDeletePage.cartIcon.getText());
    }
}
