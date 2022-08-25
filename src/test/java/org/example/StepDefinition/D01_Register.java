package org.example.StepDefinition;

import org.example.Pages.P03_homePage;
import org.example.Pages.P01_register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {
    P01_register register;
    P03_homePage home;

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        register = new P01_register(Hooks.driver);
        home = new P03_homePage(Hooks.driver);
        home.Navigate_to_RegisterPage().click();
    }

    @And("user chooses male or female")
    public void user_choose_Gender_Option (){
        register.femaleGender().click();
}

    @And("user enters valid data")
    public void user_enter_first_name(){
        register.firstName().sendKeys("Nouran");

        register.lastName().sendKeys("Ashraf");

        Select select = new Select(register.birthDay());
        select.selectByIndex(3);

        select = new Select(register.birthMonth());
        select.selectByVisibleText("August");

        select = new Select(register.birthYear());
        select.selectByValue("1995");


        register.email().sendKeys("nouranashraf@gmail.com");

        register.companyName().sendKeys("Freelance");

        register.password().sendKeys("P123456");
        register.confirmPassword().sendKeys("P123456");
    }

    @Then("user presses on register button")
    public void user_register_successfully(){
        register.registerB().click();
    }

    @And("user could register successfully")
    public void register_successfully() {
        // 1st Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successfulMsg().isDisplayed(), "Success Message");
        // 2nd Assertion
        String actual = register.successfulMsg().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "color is correct");
        // Assert All
        soft.assertAll();
    }
}
