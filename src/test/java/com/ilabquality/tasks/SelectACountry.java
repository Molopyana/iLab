package com.ilabquality.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class SelectACountry implements Task {
    public SelectACountry(String country) {
        this.country = country;
    }

    private String country;

    public static SelectACountry named(String country) {
        return Instrumented.instanceOf(SelectACountry.class).withProperties(country);
    }

    @Override
    @Step("{0} select the country called #country")
    public <T extends Actor> void performAs(T applicant) {
        Target countryName = Target.the(country + " link").located(By.linkText(country));
        System.out.println("//a[contains(.,'"+country+"')])[1]");
        applicant.attemptsTo(
                Scroll.to(countryName),
                Click.on(countryName)
        );

    }


}
