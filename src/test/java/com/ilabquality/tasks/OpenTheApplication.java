package com.ilabquality.tasks;

import com.ilabquality.ui.ILabLandingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheApplication implements Task {
    private ILabLandingPage iLabLandingPage;

    @Override
    @Step("Opens ILAB website")
    public <T extends Actor> void performAs(T user) {
        user.attemptsTo(Open.browserOn().the(iLabLandingPage));

    }
}
