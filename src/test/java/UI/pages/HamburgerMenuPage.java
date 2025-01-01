package UI.pages;

import UI.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HamburgerMenuPage {

    public HamburgerMenuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "react-burger-menu-btn")
    public WebElement hamburgerBtn;
    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;
    @FindBy(id = "about_sidebar_link")
    public WebElement abautLink;
    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutink;
    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppStorelink;
    @FindBy(xpath ="//*[@id=\"menu_button_container\"]/div/div[2]/div[1]")
    public WebElement menulist;
    @FindBy(xpath = "//*[@id=\"react-burger-cross-btn\"]")
    public WebElement  xbtn;
    @FindBy(xpath = "//*[@id=\"header_container\"]/div[1]/div[2]/div")
    public WebElement  swagLab;
    @FindBy(xpath = "//*[@id=\"__next\"]/header/div/div/div[1]/div[1]/a/div[1]/span/img")
    public WebElement  sauceLabs;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]")
    public WebElement swagLabLogoo;
}
