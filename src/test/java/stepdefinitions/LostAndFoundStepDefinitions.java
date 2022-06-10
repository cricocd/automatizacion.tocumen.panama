package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import interactions.ReadPdf;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import questions.LostAndFoundPolicy;
import tasks.Open;
import tasks.SearchLostAndFound;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LostAndFoundStepDefinitions {

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
        theActorCalled("Chris");
    }

      private EnvironmentVariables environmentVariables;
      String downloadFolder;
      String fileName;

    @Given("^Chris entered in the tocumen page$")
    public void chrisEnteredInTheTocumenPage() {
        downloadFolder = environmentVariables.optionalProperty("download.filesFolder")
                .orElseThrow(IllegalArgumentException::new);

        fileName = environmentVariables.optionalProperty("statements.fileName")
                .orElseThrow(IllegalArgumentException::new);
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.thePage());
    }

    @When("^he search the lost and found police$")
    public void heSearchTheLostAndFoundPolice(){
        OnStage.theActorInTheSpotlight().attemptsTo(SearchLostAndFound.policy());
    }

    @Then("^he should read the correct information$")
    public void heShouldReadTheCorrectInformation() throws IOException {
        String statementFilePath = String.format("%s/%s", downloadFolder, fileName);
        theActorInTheSpotlight().whoCan(ReadPdf.downloadedInPath(statementFilePath));
        String pdfText = ReadPdf.as(theActorInTheSpotlight()).getText();
        System.out.println(pdfText);
        theActorInTheSpotlight().should(seeThat(LostAndFoundPolicy.isCorrect(pdfText)));
    }
}
