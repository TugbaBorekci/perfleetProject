package perfleet.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import perfleet.pages.HomePage;
import perfleet.pages.LoginPage;
import perfleet.utilities.Driver;

public class LogoutStepDefinitions {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Then("The user logs out using the logout button inside the profile menu")
    public void the_user_logs_out_using_the_logout_button_inside_the_profile_menu() {
        homePage.userProfile.click();
        homePage.logoutButton.click();


    }

    @Then("The user ends up on the login page")
    public void the_user_ends_up_on_the_login_page() {
        String expectedLoginPage = "Login";
        String actualLoginPage = loginPage.loginPageTitle.getText();
        Assert.assertEquals(expectedLoginPage, actualLoginPage);
    }

    @When("The user clicks step back button")
    public void the_user_clicks_step_back_button() {
        Driver.getDriver().navigate().back();

    }

    @Then("The user is still on the login page")
    public void the_user_is_still_on_the_login_page() {
        String expectedLoginPage = "Login";
        String actualLoginPage =loginPage.loginPageTitle.getText();
        Assert.assertEquals(expectedLoginPage, actualLoginPage);

    }
}
