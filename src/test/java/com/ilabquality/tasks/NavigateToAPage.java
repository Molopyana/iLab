package com.ilabquality.tasks;

import com.ilabquality.ui.CurrentOppenningsPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateToAPage implements Task {
    private String pageNamed;

    public NavigateToAPage(String pageNamed) {
        this.pageNamed = pageNamed;
    }

    public static NavigateToAPage called(String pageNamed) {
        return Instrumented.instanceOf(NavigateToAPage.class).withProperties(pageNamed);
    }

    @Override
    @Step("{0} navigate to #pageNamed")
    public <T extends Actor> void performAs(T applicant) {
        Target pageLink = Target.the(pageNamed+ " link").locatedBy("//nav[@class='navigation-right text-right']//a[contains(text(),'"+pageNamed+"')]");
        applicant.attemptsTo(

                WaitUntil.the(pageLink, isVisible()).forNoMoreThan(30).seconds(),
                Click.on(pageLink)
        );

    }
}
