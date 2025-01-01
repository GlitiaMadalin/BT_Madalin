package UI.pages;

import UI.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtraReqAtoZPage {
    public ExtraReqAtoZPage() {
         PageFactory.initElements(Driver.getDriver(),this); }

   @FindBy(xpath = "//select[@data-test='product_sort_container']")
   public WebElement btAtoZ;
}
