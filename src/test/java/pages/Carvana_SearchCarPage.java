package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Carvana_SearchCarPage extends Carvana_BasePage{

    public Carvana_SearchCarPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = "a[data-cv-test*='headerSearchLink']")
    public WebElement searchCarsLink;

    @FindBy(id = "header-facets-wrapper")
    public List<WebElement> filterOptions;

    @FindBy(css = "input[data-test='SearchBarInput']")
    public WebElement searchBarInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement go_Button;

    @FindBy(css = "div[class=‘result-tile]")
    public List<WebElement> resultTiles;

    @FindBy(css = "div[class='result-tile'] img")
    public List<WebElement> images_ResultTile;

    @FindBy(css = "div[class='result-tile'] svg")
    public List<WebElement> add_FavouriteButton_ResultTile;


    public void routeToCars() {
        searchCarsLink.click();
    }
}