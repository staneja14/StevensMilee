package com.stevensportal.coursesreview.validators;

import com.stevensportal.coursesreview.constant.CoursesReviewConstant;
import com.stevensportal.coursesreview.contract.request.LoginRequestDTO;
import com.stevensportal.coursesreview.contract.response.base.*;
import com.stevensportal.coursesreview.enumeration.ErrorResponseEnum;

import java.util.*;
import java.util.regex.*;

import org.apache.commons.lang.StringUtils;

/**
 * @author staneja14
 *
 */
public class RequestValidator {
	
	public static List<ErrorDTO> validateLoginRequest(LoginRequestDTO loginRequest, List<ErrorDTO> errorList) {
		
		
		if (StringUtils.isEmpty(loginRequest.getEmailId())) {
			errorList.add(new ErrorDTO(ErrorResponseEnum.EMAIL_ID_IS_MISSING, null));
		} else {
			if (!validateEmail(loginRequest.getEmailId())) {
				errorList.add(new ErrorDTO(ErrorResponseEnum.EMAIL_ID_IS_INVALID, loginRequest.getEmailId()));
			}
		}
		
		return errorList;
	}
	
	public static boolean validateEmail(String emailId) {
		boolean result = true;
		if (emailId != null && emailId.length() < 150) {
			if (!Pattern.matches(CoursesReviewConstant.REGEX_EMAIL, emailId)) {
				return false;
			}
		} else {
			result = false;
		}
		return result;
	}
	
}
