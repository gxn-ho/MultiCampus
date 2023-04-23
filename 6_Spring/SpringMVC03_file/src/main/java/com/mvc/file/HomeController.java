package com.mvc.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.file.validate.FileVaildator;
import com.mvc.file.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileVaildator fileValidator;
	
	
	@RequestMapping(value="/form")
	public String getUploadForm() {
		return "uploadForm";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model,
							UploadFile uploadFile, BindingResult result) {
		
		//BindingResult: 요청시 객체 binding 진행 중 에러 발생하면 해당 에러 정보를 받기 위해 사용.
		//				또는 개발자 유효성 검사 후 에러메시지를 담아 스프링에 전달하기 위해 사용.
		//유효성 검사: 파일 크기가 0인지.
		fileValidator.validate(uploadFile, result);
		if(result.hasErrors()) {
			return "uploadForm";
		}
		
		MultipartFile file = uploadFile.getFile();
		String filename = file.getOriginalFilename();	//업로드된 파일의 실제 이름
		
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream();
			
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
			System.out.println("d업로드 될 실제 경로: " + path);
			
			File storage  = new File(path);
			if( !storage.exists() ) {	//존재여부 확인
				storage.mkdirs();		//디렉토리 만들기
			}
			
			File newfile = new File(path+"/"+filename);
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			outputStream = new FileOutputStream(newfile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while( (read=inputStream.read(b)) != -1 ) {
				outputStream.write(b,0,read);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj",fileobj);
		return "uploadRes";
	}
}
