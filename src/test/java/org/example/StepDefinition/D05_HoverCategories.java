package org.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.P03_homePage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class D05_HoverCategories {
    P03_homePage home;
    P03_homePage category;
    String subCategoryName;

    @When("user hover category and select subcategory")
    public void user_hover_category() throws InterruptedException {
        home = new P03_homePage(Hooks.driver);
        category = new P03_homePage(Hooks.driver);
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(home.computers()).perform();
        action.moveToElement(home.computers()).perform();

        subCategoryName = home.desktops().getText().toLowerCase().trim();

        Thread.sleep(1000);
    }

    @And("user click on subcategory")
    public void user_clicks_subcategory(){
        home.desktops().click();
    }

    @Then("user go to relative product page")
    public void relative_subcategory(){
        Assert.assertEquals(category.categoryList().getText().toLowerCase().trim(),subCategoryName,"subcategory");
    }
}
