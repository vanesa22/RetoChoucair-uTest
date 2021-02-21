package co.com.choucair.certification.proyectobase.stepdefinitions;

import co.com.choucair.certification.proyectobase.model.uTestData;
import co.com.choucair.certification.proyectobase.tasks.JoinToday;
import co.com.choucair.certification.proyectobase.tasks.OpenUp;
import co.com.choucair.certification.proyectobase.tasks.SingUp;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

public class uTestStepDefinitions {
    @Before
    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^Rose wants to register on the uTest platform$")
    public void roseWantsToRegisterOnTheUTestPlatform() {
         OnStage.theActorCalled("Rose").wasAbleTo(OpenUp.thePage(), JoinToday.onThePage());
    }

    @When("^she registers all the data requested by the platform$")
    public void sheRegistersAllTheDataRequestedByThePlatform(List<uTestData> academyChoucairData) {
        OnStage.theActorInTheSpotlight().attemptsTo(SingUp.the(academyChoucairData.get(0).getStrFirstName(),
                        academyChoucairData.get(0).getStrLastName(),academyChoucairData.get(0).getStrEmail(),
                        academyChoucairData.get(0).getStrMonth(),academyChoucairData.get(0).getStrDay(),
                        academyChoucairData.get(0).getStrYear(),academyChoucairData.get(0).getStrpassword(),
                        academyChoucairData.get(0).getStrPasswordConfirmation(),academyChoucairData.get(0).getStrCity(),
                        academyChoucairData.get(0).getStrZip(), academyChoucairData.get(0).getStrComputer(), academyChoucairData.get(0).getStrVersion(),
                        academyChoucairData.get(0).getStrLenguaje()
                        )
                );

    }

    @Then("^she will be registered$")
    public void sheWillBeRegistered() {
    }

}