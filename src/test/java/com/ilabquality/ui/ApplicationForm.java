package com.ilabquality.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ApplicationForm {
    public static final Target NAME_INPUT_FIELD = Target.the("Name input field").located(By.id("applicant_name"));
    public static final Target EMAIL_INPUT_FIELD = Target.the("Email input field").located(By.id("email"));
    public static final Target PHONE_INPUT_FIELD = Target.the("Email input field").located(By.id("phone"));
    public static final Target MOTIVATION_INPUT_FIELD = Target.the("motivation input field").located(By.id("message"));
    public static final Target UPLOAD_BUTTON = Target.the("Upload Button").locatedBy("//div[@class='moxie-shim moxie-shim-html5']//input");
    public static final Target SEND_APPLICATION_BUTTON = Target.the("Send button").located(By.id("wpjb_submit"));
    public static final Target VALIDATION_FILE_UPLOAD = Target.the("validation message").locatedBy("//li[contains(text(),'You need to upload at least one file.')]");
}
