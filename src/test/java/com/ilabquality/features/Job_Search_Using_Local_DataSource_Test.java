package com.ilabquality.features;

import com.ilabquality.questions.ApplicationPageValidation;
import com.ilabquality.tasks.ApplyForTheFirstJob;
import com.ilabquality.tasks.NavigateToAPage;
import com.ilabquality.tasks.OpenTheApplication;
import com.ilabquality.tasks.SelectACountry;
import com.ilabquality.utils.PhoneNumberGenerator;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/TestData/TestData.csv")
public class Job_Search_Using_Local_DataSource_Test {
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

    public Job_Search_Using_Local_DataSource_Test(String pageNamed, String country, String name, String email, boolean upLoad) {
        this.pageNamed = pageNamed;
        this.country = country;
        this.name = name;
        this.email = email;
        this.upLoad = upLoad;
    }



    @Before
    public void user_can_browse_the_web(){
        applicant = Actor.named("Puleng");
        applicant.can(BrowseTheWeb.with(theirWebDriver));
    }

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"CAREERS","South Africa","local_applicant1","local_applicant1@ilab.com",false},
                {"CAREERS","South Africa","Local_applicant2","local_applicant2@ilab.com",false}

        });
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
