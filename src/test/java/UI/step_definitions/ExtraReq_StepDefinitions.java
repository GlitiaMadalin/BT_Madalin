package UI.step_definitions;

import UI.pages.ExtraReqAtoZPage;
import UI.pages.LoginPage;
import UI.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class ExtraReq_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    ExtraReqAtoZPage extraReqAtoZPage = new ExtraReqAtoZPage();


    @When("User enter valid {string} and {string} and login")
    public void user_enter_valid_and_and_login(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("User should see if url contains inventory")
    public void userShouldSeeIfUrlContainsInventory() {
        BrowserUtils.verifyURLContains("inventory");
    }

    @And("User analyze A to Z button functionality")
    public void analyzeAToZButton() {
        Select stateDropdown = new Select(extraReqAtoZPage.btAtoZ);
        stateDropdown.selectByIndex(0);
        BrowserUtils.waitFor(2);
        stateDropdown.selectByVisibleText("Name (A to Z)");
        BrowserUtils.waitFor(2);
        stateDropdown.selectByVisibleText("Name (Z to A)");
        BrowserUtils.waitFor(2);
        stateDropdown.selectByVisibleText("Price (low to high)");
        BrowserUtils.waitFor(2);
        stateDropdown.selectByVisibleText("Price (high to low)");
        BrowserUtils.waitFor(2);

        String expectedOptionText = "Price (high to low)";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOptionText, expectedOptionText);
         }
}
