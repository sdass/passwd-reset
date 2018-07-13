package com.subra.passwdreset.controller;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.subra.passwdreset.CustomerService;
import com.subra.passwdreset.model.Customer;

@Controller
public class ResetPasswordController {
	
	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	ModelAndView initial(){
		
		return new ModelAndView("first", "message", "My first message");
		
		//return new ModelAndView("first");		
		
	}
	
	@RequestMapping(value="/forgot", method=RequestMethod.GET)
	ModelAndView displayForgotPasswordPage(){
		return new ModelAndView("forgotPassword");		
		
	}
	
	//send a responsebody instead
	@RequestMapping(value="/forgot", method=RequestMethod.POST)
	ModelAndView processAndSendForgotPasswordURL(ModelAndView modelview, HttpServletRequest httpRequest, @RequestParam("email") String email){
		Optional<Customer> optcustomer = customerService.findUserByemail(email);

		if(!optcustomer.isPresent()){
			modelview.addObject("error", "No customer found");			
		}else{
			Customer customer = optcustomer.get();
			customer.setResetToken(UUID.randomUUID().toString());
			Customer c = customerService.saveCustomer(customer);
			if(c != null){
				//send url
				String thisUrl = httpRequest.getScheme()+ "://" + httpRequest.getServerName();
				String tokenUrl= thisUrl + "reset?token"+ c.getResetToken();
				modelview.addObject("success", "password reset link sent to your email");
			}			
		}
		modelview.setViewName("forgotPassword");
		return modelview;		
		
	}
	
	@RequestMapping(value="/reset", method=RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelview, @RequestParam("token") String resetToken){
		System.out.println("resettoken=" + resetToken);
		Optional<Customer> c = customerService.findByResetToken(resetToken);
		if(c.isPresent()){
			modelview.addObject("resettoken", resetToken);
		}else{
			modelview.addObject("error", "Invalid password reset link");
		}
		modelview.setViewName("resetPassword");
		return modelview;
	}
	
	@RequestMapping(value="/reset", method=RequestMethod.POST)
	ModelAndView setNewPassword(ModelAndView modelview, @RequestParam Map<String, String> reqParams, RedirectAttributes redirectAttribute){
		String token = reqParams.get("token");
		String password = reqParams.get("password");
		System.out.println("inputs: token=" + token + " password=" + password);
		Optional<Customer> optCustomer = customerService.findByResetToken(token);
		if(optCustomer.isPresent()){
			Customer existC = optCustomer.get();//.setPassword(password);
			existC.setPassword(password);
			existC.setResetToken(null);
			customerService.saveCustomer(existC);
			redirectAttribute.addFlashAttribute("success", "Passwd reset successful. Login now");
			modelview.setViewName("redirect:login");
			return modelview;			
		}else{
			modelview.addObject("error", "Invalid password reset link.");
			modelview.setViewName("resetPassword");
		}
		//plain password for now to test. later use bcrypt
				
		
		return modelview;
	}
	
}
