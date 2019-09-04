package kwan.org.validator;

/**
 * Created by https://github.com/kwanpham
 */
import kwan.org.model.ApplicantInfo;
import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ApplicantValidator implements Validator {

    // common-validator library.
    private EmailValidator emailValidator =   EmailValidator.getInstance();


    // Các class được hỗ trợ Validate
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == ApplicantInfo.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ApplicantInfo applicantInfo = (ApplicantInfo) target;


        // Kiểm tra các field của ApplicantInfo.
        // (Xem thêm file property: messages/validator.property)
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.applicantForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.applicantForm.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", "NotEmpty.applicantForm.position");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.applicantForm.gender");

        if(!emailValidator.isValid(applicantInfo.getEmail())) {
            // Error in email field.
            // Lỗi trường email.
            errors.rejectValue("email", "Pattern.applicantForm.email");
        }

        if(applicantInfo.getSkills()== null || applicantInfo.getSkills().length==0 ) {
            errors.rejectValue("skills", "Select.applicantForm.skills");
        }

    }

}