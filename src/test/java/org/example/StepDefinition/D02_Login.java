package org.example.StepDefinition;

import org.example.Pages.P03_homePage;
import org.example.Pages.P02_login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class D02_Login {
    P02_login login;
    P03_homePage home;

    @When("user navigates to login page")
    public void user_navigate_to_login_page() {
        home = new P03_homePage(Hooks.driver);
        login = new P02_login(Hooks.driver);
        home.Navigate_to_LoginPage().click();
    }

    @And("user enter \"(.*)\" and \"(.*)\"$")
    public void vaild_data(String email, String password) throws InterruptedException {
        login.LoginSteps(email, password);
        Thread.sleep(1000);
    }

    @Then("user clicks on login button")
    public void click_Login() {
        login.passwordE().sendKeys(Keys.ENTER);
    }

    @And("user could login successfully and go to home page")
    public void login_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/","URL login");
        // Second Assertion
        Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        soft.assertTrue(login.myAccount().isDisplayed(), "My Account");
        // Assert All
        soft.assertAll();
    }

    @And("user couldn't login to the system")
    public void cannot_login_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        login.wrongMsg().isDisplayed();
        String actual = login.wrongMsg().getText();
        soft.assertEquals(actual,"Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect","Wrong Message");
        // Second Assertion
        actual = login.wrongMsg().getCssValue("color");
        String expected = "rgba(228, 67, 75, 1)";
        soft.assertEquals(actual, expected, "color");
        // Assert All
        soft.assertAll();
    }
}
