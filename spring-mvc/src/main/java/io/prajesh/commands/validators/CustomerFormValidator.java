package io.prajesh.commands.validators;

import io.prajesh.commands.CustomerForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Prajesh Ananthan
 *         Created on 25/8/2017.
 */
@Component
public class CustomerFormValidator implements Validator {

  private static final String PASSWORDS_DON_T_MATCH = "Passwords Don't Match";

  @Override
  public boolean supports(Class<?> aClass) {
    return CustomerForm.class.equals(aClass);
  }

  @Override
  public void validate(Object target, Errors errors) {
    CustomerForm customerForm = (CustomerForm) target;

    if (!customerForm.getPasswordText().equals(customerForm.getPasswordTextConfirm())) {
      errors.rejectValue("passwordText", "PasswordsDontMatch.customerForm.passwordText", PASSWORDS_DON_T_MATCH);
      errors.rejectValue("passwordTextConfirm", "PasswordsDontMatch.customerForm.passwordTextConfirm", PASSWORDS_DON_T_MATCH);
    }
  }
}
