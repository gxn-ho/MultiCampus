package com.boot.api;

import java.io.IOException;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping("/ocr")
	public String ocrTest(Model model) throws IOException {
		String path = Paths.get(resourceLoader.getResource("classpath:static").getURI()).toString();
		System.out.println(path);
		
		Ocr ocr = new Ocr();
		String res = ocr.ocr(path);
		
		JSONObject obj = new JSONObject(res);
		model.addAttribute("res",obj);
		
		
		return "ocrRes";
	}
	
	@GetMapping("/speech")
	public String speechTest(Model model) throws IOException {
		String path = Paths.get(resourceLoader.getResource("classpath:static").getURI()).toString();
		System.out.println(path);
		
		Speech sp = new Speech();
		String res = sp.speech(path);
		JSONObject obj = new JSONObject(res);
		model.addAttribute("res",obj);
		
		
		return "speechRes";
	}
	
	@GetMapping("/cfr")
	public String cfrTest(Model model) throws IOException {
		String path = Paths.get(resourceLoader.getResource("classpath:static").getURI()).toString();
		System.out.println(path);
		
		CFR cfr = new CFR();
		String res = cfr.cfr(path);
		JSONObject obj = new JSONObject(res);
		model.addAttribute("res",obj);
		
		return "cfrRes";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
