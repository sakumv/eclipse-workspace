package stepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.*;

import org.junit.runner.RunWith;


public class stepDefinition {

    @Given("^User is in login page$")
    public void user_is_in_login_page()  {
    	System.out.println("Inside login");
        
    }

    @When("^user logs in with userid and password$")
    public void user_logs_in_with_userid_and_password(){
    	System.out.println("userid and pwd entered");
        
    }

    @Then("^home page is shown$")
    public void home_page_is_shown() {
    	System.out.println("homepage shown");

    }    

    @And("^user sees assignment and scores if any$")
    public void user_sees_assignment_and_scores_if_any()  {
    	System.out.println("assignment");

   
    }

    @But("^User doesnt see any errors$")
    public void user_doesnt_see_any_errors(){
    	System.out.println("error");

        
    }

}