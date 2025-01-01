package UI.pages;

import UI.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDeletePage extends BasePage {
    public AddDeletePage() {
        PageFactory.initElements(Driver.getDriver(), this);  }

    @FindBy(xpath = "/html//button[@id='add-to-cart-sauce-labs-backpack']")
    public WebElement addToCartBttn;
    @FindBy(css = "a#item_4_title_link > .inventory_item_name")
    public WebElement prodName;
    @FindBy(css = ".inventory_item_desc")
    public WebElement prodDescription;
    @FindBy(css = ".inventory_item_price")
    public WebElement prodPrice;
    @FindBy(xpath = "//div[@id='shopping_cart_container']/a[@class='shopping_cart_link']")
    public WebElement cartIcon;
    @FindBy(css = ".title")
    public WebElement cartPageHeader;
    @FindBy(css = "button#checkout")
    public WebElement checkOutButton;
    @FindBy(css = "input#first-name")
    public WebElement checkOutButtonFirstNume;
    @FindBy(css = "input#last-name")
    public WebElement checkOutButtonLastName;
    @FindBy(css = "input#postal-code")
    public WebElement checkOutButtonZipCode;
    @FindBy(css = ".title")
    public WebElement CheckoutYourInformation;
    @FindBy(css = "input#continue")
    public WebElement continueBttn;
    @FindBy(css = ".title")
    public WebElement checkoutPageHeader;
    @FindBy(xpath= "/html//button[@id='finish']")
    public WebElement finishBttn;
    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    public WebElement checkoutPageComplete;
    @FindBy(xpath = "//div[@id='checkout_complete_container']/h2[@class='complete-header']")
    public WebElement succesMessage;
    @FindBy(xpath = "//a[@id='item_4_title_link']/div[@class='inventory_item_name']")
    public WebElement deletenameProd1;
    @FindBy(xpath = "/html//button[@id='add-to-cart-sauce-labs-bike-light']")
    public WebElement addToCartBttn2;
    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    public WebElement cartHeader2;
    @FindBy(xpath = "/html//div[@id='cart_contents_container']//div[@class='cart_list']/div[3]/div[@class='cart_item_label']/a[@href='#']/div[@class='inventory_item_name']")
    public WebElement nameProd1;
    @FindBy(xpath = "/html//div[@id='cart_contents_container']//div[@class='cart_list']/div[3]/div[@class='cart_item_label']/div[@class='inventory_item_desc']")
    public WebElement specificationsProd1;
    @FindBy(xpath = "/html//div[@id='cart_contents_container']//div[@class='cart_list']/div[3]/div[@class='cart_item_label']/div[@class='item_pricebar']/div[@class='inventory_item_price']")
    public WebElement priceProd1;
    @FindBy(xpath = "/html//div[@id='cart_contents_container']//div[@class='cart_list']/div[4]/div[@class='cart_item_label']/a[@href='#']/div[@class='inventory_item_name']")
    public WebElement nameProd2;
    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    public WebElement specificationsProd2;
    @FindBy(xpath = "//div[@id='header_container']//span[@class='title']")
    public WebElement priceProd2;
    @FindBy(xpath = "/html//button[@id='remove-sauce-labs-bike-light']")
    public WebElement removeProdBtn2;
    @FindBy(xpath = "/html//button[@id='remove-sauce-labs-backpack']")
    public WebElement removeProdBtn1;
}
