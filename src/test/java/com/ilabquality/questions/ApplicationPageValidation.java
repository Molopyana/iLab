package com.ilabquality.questions;

import com.ilabquality.ui.ApplicationForm;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ApplicationPageValidation implements Question<String> {

    @Override
    public String answeredBy(Actor applicant) {
        return Text.of(ApplicationForm.VALIDATION_FILE_UPLOAD).viewedBy(applicant).asString();
    }

    public static Question<String> value() {
        return new ApplicationPageValidation();
    }
}
