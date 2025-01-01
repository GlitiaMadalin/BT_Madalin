package UI.pages;

import UI.utilities.ConfigurationReader;
import UI.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement inputUsername;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement inputPassword;
    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@id='login_button_container']//form//h3")
    public WebElement errMesage;
    @FindBy(css = ".inventory_list .inventory_item:nth-of-type(1) .inventory_item_img:nth-of-type(1) .inventory_item_img")
    //     "/html//div[@id='inventory_container']/div/div[@id='inventory_container']/div/div[1]/div[@class='inventory_item_img']/a[@href='#']/img[@alt='Sauce Labs Backpack']")
    public WebElement expectedImage;
    @FindBy(xpath = "/html//div[@id='inventory_container']/div/div[@id='inventory_container']/div/div[1]/div[@class='inventory_item_img']/a[@href='#']/img[@alt='Sauce Labs Backpack']")
    public WebElement actualImage;


    /**
     * Without params
     * The method will directly log in using:
     * Username:  standard_user
     * Password:  secret_sauce
     */
    public void login() {
        this.inputUsername.sendKeys("standard_user");
        this.inputPassword.sendKeys("secret_sauce");
        this.loginButton.click();
    }

    /**
     * The method accept 2 args and login
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    /**
     * The method Will log in using credentials
     * from configuration.properties
     */
    public void loginWithConfig() {
        inputUsername.sendKeys(ConfigurationReader.getProperty("swag.labs.username"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("swag.labs.password"));
        loginButton.click();
    }
}