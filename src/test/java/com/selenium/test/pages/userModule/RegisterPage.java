package com.selenium.test.pages.userModule;

import com.selenium.test.pages.BasePhptravelsPage;
import com.selenium.test.to.Credential;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Rahi on 2017-04-08.
 */
public class RegisterPage extends BasePhptravelsPage {

    public RegisterPage(){
        super();
    }

    @Override
    protected void openPage() {
    }

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstnameTxtField;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastnameTxtField;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneTxtField;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTxtField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTxtField;

    @FindBy(xpath = "//input[@name='confirmpassword']")
    WebElement confirmPasswordTxtField;

    @FindBy(xpath = "//button[@class='signupbtn btn_full btn btn-action btn-block btn-lg']")
    WebElement singUpButton;

    //@FindBy(xpath = "//div//div[contains(.,'Email Already Exists.')]")
    //WebElement existingMailMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    WebElement errorMessage;

    public RegisterPage fillRegistrationForm(Credential credential) {
        typeFirstname(credential.getFirstname());
        typeLastname(credential.getLastname());
        typePhone(credential.getPhone());
        typeEmail(credential.getEmail());
        typePassword(credential.getPassword());
        typeConfirmPassword(credential.getConfirmationPassword());
        return this;
    }

    public AccountPage registerAccount() {
        singUpButton.click();
        return new AccountPage();
    }

    public void typeFirstname(String firstname){
        firstnameTxtField.clear();
        firstnameTxtField.sendKeys(firstname);
    }

    public void typeLastname(String lastname){
        lastnameTxtField.clear();
        lastnameTxtField.sendKeys(lastname);
    }

    public void typePhone(String phone){
        phoneTxtField.clear();
        phoneTxtField.sendKeys(phone);
    }

    public void typeEmail(String email){
        emailTxtField.clear();
        emailTxtField.sendKeys(email);
    }

    public void typePassword(String password){
        passwordTxtField.clear();
        passwordTxtField.sendKeys(password);
    }

    public void typeConfirmPassword(String confirmPassword){
        confirmPasswordTxtField.clear();
        confirmPasswordTxtField.sendKeys(confirmPassword);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
