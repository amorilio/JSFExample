package com.tutorial;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class validatePassword implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		// TODO Auto-generated method stub
		String password = (String) arg2;

    	System.out.println("Validating Password : " + password);

		if(!password.equals("Password")) {
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("Email is not valid.");
			message.setDetail("Email is not valid.");
			arg0.addMessage("userForm:Email", message);
			throw new ValidatorException(message);
		}
	}
}
