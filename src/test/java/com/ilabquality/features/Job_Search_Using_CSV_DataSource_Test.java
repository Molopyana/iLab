package com.ilabquality.features;

import com.ilabquality.questions.ApplicationPageValidation;
import com.ilabquality.tasks.ApplyForTheFirstJob;
import com.ilabquality.tasks.NavigateToAPage;
import com.ilabquality.tasks.SelectACountry;
import com.ilabquality.utils.PhoneNumberGenerator;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import com.ilabquality.tasks.OpenTheApplication;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/TestData/TestData.csv")
public class Job_Search_Using_CSV_DataSource_Test {
    @Managed()
    public WebDriver theirWebDriver;

    @Steps
    OpenTheApplication openTheApplication;

    private Actor applicant;

    private String pageNamed;
    private String country;
    private String name;
    private String email;
    private boolean upLoad;

    @Before
    public void user_can_browse_the_web(){
        applicant = Actor.named("Puleng");
        applicant.can(BrowseTheWeb.with(theirWebDriver));
    }

    @Test
    public void should_displayValidation_message_asking_for_an_upload(){

        givenThat(applicant).wasAbleTo(openTheApplication);

        when(applicant).attemptsTo(NavigateToAPage.called(pageNamed));

        and(applicant).attemptsTo(SelectACountry.named(country));

        and(applicant).attemptsTo(ApplyForTheFirstJob.withDetails(name,email,PhoneNumberGenerator.getValidPhoneNumber(),upLoad));

        then(applicant).should(eventually(seeThat(ApplicationPageValidation.value(),
                containsString("You need to upload at least one file"))));
    }



}
