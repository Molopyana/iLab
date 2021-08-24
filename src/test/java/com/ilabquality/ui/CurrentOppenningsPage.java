package com.ilabquality.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CurrentOppenningsPage {
    public static Target firstListing = Target.the("First Listed Job").locatedBy("//div[contains(@class,'wpjb-job-list wpjb-grid')]//div[1]//div[2]//div[1]//a[1]");
}
