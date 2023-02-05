package test_scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.Waiter;

import java.util.stream.IntStream;

public class Carvana_BaseTest extends Carvana_Base{

    @Test(priority = 1, description = "Validate Home Page title and URL")
    public void validate_PageTitle_URL() {

         Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
         Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate the Carvana logo")
    public void validate_logo() {

        Assert.assertTrue(carvana_basePage.logo.isDisplayed());
    }

    @Test(priority = 3, description = "Validation for Navigation Section Items")
    public void validate_NavigateSectionItems() {

        IntStream.range(0, carvana_basePage.navigationItems.size()).forEach(i ->
                Assert.assertTrue(carvana_basePage.navigationItems.get(i).isDisplayed()));
    }

    @Test(priority = 4, description = "Validation the Sign In Error Message")
    public void validate_SignIn_ErrorMessage() {

        carvana_basePage.signIn.click();
        carvana_basePage.emailInputBox.sendKeys("johndoe@gmail.com");
        carvana_basePage.continueButton.click();
        carvana_basePage.passwordInput.sendKeys("abcd1234");
        carvana_basePage.signInButton.click();
        Assert.assertEquals(carvana_basePage.errorMessage.getText(), "Email address and/or password combination is incorrect.");

    }

    @Test(priority = 5, description = "Validation for the Search Filter Options and Search Button")
    public void validate_FilterOptions() {

       carvana_searchCarPage.routeToCars();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.carvana.com/cars");

        IntStream.range(0, carvana_searchCarPage.filterOptions.size()).forEach(i ->
                Assert.assertTrue(carvana_searchCarPage.filterOptions.get(i).isDisplayed()));
    }

    @Test(priority = 6, description = "Validation for the Search Result Tiles")
    public void validate_SearchResult_Tiles() {

        carvana_searchCarPage.routeToCars();
        carvana_searchCarPage.searchBarInputBox.sendKeys("mercedes-benz");
        carvana_searchCarPage.go_Button.click();

        String url = driver.getCurrentUrl();
        Waiter.pause(2);
        Assert.assertTrue(Waiter.waitFor_Until_URL("mercedes-benz", 60));

        IntStream.range(0, carvana_searchCarPage.resultTiles.size()).forEach(i ->
                Assert.assertTrue(carvana_searchCarPage.resultTiles.get(i).isDisplayed()));
    }
}