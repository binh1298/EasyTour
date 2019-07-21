/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package binhpd.dtos;

import java.io.Serializable;

/**
 *
 * @author Binh_Pham
 */
public class AccountDTOErrorObject implements Serializable
{
    String usernameError, passwordError, cfPasswordError, fullnameError, emailError, phoneError, addressError;

    public AccountDTOErrorObject()
    {
    }

    public AccountDTOErrorObject(String usernameError, String passwordError, String cfPasswordError, String fullnameError, String emailError, String phoneError, String addressError)
    {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.cfPasswordError = cfPasswordError;
        this.fullnameError = fullnameError;
        this.emailError = emailError;
        this.phoneError = phoneError;
        this.addressError = addressError;
    }

    public String getUsernameError()
    {
        return usernameError;
    }

    public void setUsernameError(String usernameError)
    {
        this.usernameError = usernameError;
    }

    public String getPasswordError()
    {
        return passwordError;
    }

    public void setPasswordError(String passwordError)
    {
        this.passwordError = passwordError;
    }

    public String getCfPasswordError()
    {
        return cfPasswordError;
    }

    public void setCfPasswordError(String cfPasswordError)
    {
        this.cfPasswordError = cfPasswordError;
    }

    public String getFullnameError()
    {
        return fullnameError;
    }

    public void setFullnameError(String fullnameError)
    {
        this.fullnameError = fullnameError;
    }

    public String getEmailError()
    {
        return emailError;
    }

    public void setEmailError(String emailError)
    {
        this.emailError = emailError;
    }

    public String getPhoneError()
    {
        return phoneError;
    }

    public void setPhoneError(String phoneError)
    {
        this.phoneError = phoneError;
    }

    public String getAddressError()
    {
        return addressError;
    }

    public void setAddressError(String addressError)
    {
        this.addressError = addressError;
    }
    
    
}
