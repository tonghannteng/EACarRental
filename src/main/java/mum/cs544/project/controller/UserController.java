package mum.cs544.project.controller;

import javax.validation.Valid;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.cs544.project.domain.Role;
import mum.cs544.project.domain.User;

import mum.cs544.project.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
UserService userService;


@RequestMapping(value="/signUp",method=RequestMethod.GET)
public String addUser(@ModelAttribute("user") User user){
	System.out.println("User sign up called");
	return "signUp";
}
@RequestMapping(value="/signUp",method=RequestMethod.POST)
public String addUsers(@ModelAttribute("user") @Valid User user, BindingResult result,RedirectAttributes redirectAttrs){
	if(result.hasErrors()){
		return "signUp";
	}
	String newpassword = this.MD5(user.getPassword());
	user.setPassword(newpassword);
	Role role = new Role();
	role.setId(RandomUtils.nextInt());
	role.setRole("USER");
	role.setUser(user);
	user.setRole(role);
	userService.save(user);
	//securityService.autologin(user.getUserName(), user.getPassword());
	redirectAttrs.addFlashAttribute("message","Welcome "+ user.getFirstName()+"  "+user.getLastName()+" Now login with your username and password for access, Your Email is username ");
	return "redirect:/welcome";
}
public String MD5(String md5) {
	   try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}

}
