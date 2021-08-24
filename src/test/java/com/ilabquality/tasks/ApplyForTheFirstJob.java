package com.ilabquality.tasks;

import com.ilabquality.ui.ApplicationForm;
import com.ilabquality.ui.CurrentOppenningsPage;
import com.ilabquality.ui.JobDetailsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ApplyForTheFirstJob implements Task {
    private String name;
    private String email;
    private String phone;
    private boolean upLoad;

    public ApplyForTheFirstJob(String name, String email, String phone, boolean upLoad) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.upLoad = upLoad;
    }

    @Override
    @Step("{0} applies for the first job listing")
    public <T extends Actor> void performAs(T applicant) {
        applicant.attemptsTo(
                WaitUntil.the(CurrentOppenningsPage.firstListing, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(CurrentOppenningsPage.firstListing),
                WaitUntil.the(JobDetailsPage.applyOnline, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(JobDetailsPage.applyOnline),
                Enter.theValue(name).into(ApplicationForm.NAME_INPUT_FIELD),
                Enter.theValue(email).into(ApplicationForm.EMAIL_INPUT_FIELD),
                Enter.theValue(phone).into(ApplicationForm.PHONE_INPUT_FIELD)
        );

        if(upLoad){
            //upload files
        }

        applicant.attemptsTo(
                Click.on(ApplicationForm.SEND_APPLICATION_BUTTON)
        );



    }

    public static ApplyForTheFirstJob withDetails(String name, String email, String phone, boolean upLoad) {
        return Instrumented.instanceOf(ApplyForTheFirstJob.class).withProperties(name,email,phone,upLoad);
    }


}
