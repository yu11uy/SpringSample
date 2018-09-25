package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.SignupForm;
import com.example.demo.login.domain.model.GroupOrder;

@Controller
public class SignupController {
	
	//ラジオボタン
	private Map<String, String>radioMarriage;
	
	//ラジオボタンを初期化
	private Map<String, String>initRadioMarrige() {
			
		Map<String, String>radio = new LinkedHashMap<>();
		//既婚、未婚を格納
		radio.put("既婚", "true");
		radio.put("未婚", "false");
		
		return radio;
		
	}

	//ユーザ登録画面のGET用コントローラー
	@GetMapping("/signup")
	public String getSignUp(@ModelAttribute SignupForm form, Model model) {
		
		radioMarriage = initRadioMarrige();
		
		model.addAttribute("radioMarriage", radioMarriage);
		
		return "login/signup";
	}
	
	//ユーザ登録画面のPOST用コントローラー
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated SignupForm form, BindingResult bindingResult 
			,Model model) {
		
		if(bindingResult.hasErrors()) {
			return getSignUp(form, model);
		}
		
		System.out.println(form);
		
		return "redirect:/login";
	}

}
