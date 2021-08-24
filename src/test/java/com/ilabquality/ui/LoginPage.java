package com.ilabquality.ui;


import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static Target UsernameTextBox = Target.the("username input field").locatedBy("//body[@class='webkit chrome iceblue']//tr//tr//tr[1]//td[2]//input[1]");
    public static Target Password = Target.the("password input field").locatedBy("//tr[2]//td[2]//input[1]");
    public static Target LoginButton = Target.the("LoginButton").locatedBy("//span[contains(.,'Log In')]");

}
