package com.mvc.file.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//유효성 검사(파일의 크기)
@Service
public class FileVaildator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//vaildator 사용 가능 여부
		return false;
	}

	@Override
	public void validate(Object uploadFile, Errors errors) {
		UploadFile file = (UploadFile)uploadFile;
		
		if(file.getFile().getSize() == 0) {
			errors.rejectValue("file", "errorCode","Please select a file");
		}
		
		
		
	}
	
}
