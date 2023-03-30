package perfleet.step_definitions;

import perfleet.pages.HomePage;
import perfleet.pages.LoginPage;
import perfleet.utilities.ConfigurationReader;
import perfleet.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("User is on the  login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }


    @When("The user logs in as a driver")
    public void the_user_logs_in_as_a_driver() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("driver_username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("all_password"));
        loginPage.loginButton.click();
    }


    @Then("The user is on the Quick Launchpad page")
    public void the_user_is_on_the_quick_launchpad_page() throws InterruptedException {
        Thread.sleep(3000);
        String expectedTitle = "Quick Launchpad";
        String actualTitle = homePage.quickLaunchpad.getText();

        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @When("The user logs in as a sales manager")
    public void the_user_logs_in_as_a_sales_manager() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("all_password"));
        loginPage.loginButton.click();
    }


    @When("The user logs in as a store manager")
    public void the_user_logs_in_as_a_store_manager() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("all_password"));
        loginPage.loginButton.click();
    }


    @Then("The user is on the Dashboard page")
    public void the_user_is_on_the_dashboard_page() throws InterruptedException {
        Thread.sleep(3000);
        String expectedTitle = "Dashboard";
        String actualTitle = homePage.dashboard.getText();

        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @When("The user enters invalid username and password")
    public void the_user_enters_invalid_username_and_password() {
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("invalid_username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("invalid_password"));
        loginPage.loginButton.click();
    }


    @Then("The user sees 'Invalid username or password'")
    public void the_user_sees_invalid_username_or_password() {
        homePage.invalidUsernameOrPassword.isDisplayed();
    }


    @When("The user leaves the username or password input box empty")
    public void the_user_leaves_the_username_or_password_input_box_empty() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("all_password"));
        loginPage.loginButton.click();
    }


    @Then("The user sees 'Please fill in this field' warning message")
    public void the_user_sees_warning_message_please_fill_in_this_field() {

        String expectedMessage = "Please fill in this field.";
        String actualMessage = loginPage.inputUsername.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @When("The user leaves both username and password input boxes are empty and clicks on login button")
    public void the_user_leaves_both_username_and_password_input_boxes_are_empty_and_clicks_on_login_button() {
        loginPage.loginButton.click();
    }


    @Then("The user sees 'Please fill in this field' warning message only in the username input box")
    public void the_user_sees_warning_message_only_in_the_username_input_box_please_fill_in_this_field() {

        String expectedMessage = "Please fill in this field.";
        String actualMessage = loginPage.inputUsername.getAttribute("validationMessage");
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Then("The driver sees their own username in the profile menu")
    public void the_driver_sees_their_own_username_in_the_profile_menu() throws InterruptedException {
        Thread.sleep(5000);
        String expectedProfileName = ConfigurationReader.getProperty("driver_username");
        String actualProfileName = homePage.userProfile.getText();
        Assert.assertEquals(expectedProfileName, actualProfileName);
    }


    @Then("The sales manager sees their own username in the profile menu")
    public void the_sales_manager_sees_their_own_username_in_the_profile_menu() throws InterruptedException {
        Thread.sleep(3000);
        String expectedProfileName = ConfigurationReader.getProperty("sales_manager_username");
        String actualProfileName = homePage.userProfile.getText();
        Assert.assertEquals(expectedProfileName, actualProfileName);
    }


    @Then("The store manager sees their own username in the profile menu")
    public void the_store_manager_sees_their_own_username_in_the_profile_menu() throws InterruptedException {
        Thread.sleep(3000);
        String expectedProfileName = ConfigurationReader.getProperty("store_manager_username");
        String actualProfileName = homePage.userProfile.getText();
        Assert.assertEquals(expectedProfileName, actualProfileName);

    }

}
