package mum.cs544.project.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.cs544.project.domain.Role;
import mum.cs544.project.domain.User;
import mum.cs544.project.service.UserService;



@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
UserService userService;
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public String createEmployee(@ModelAttribute("user") User user){
		System.out.println("addUser method");
		return "addUser";
	}
	
	@RequestMapping(value="/userList",method=RequestMethod.GET)
	public String getUsers(Model model){
		System.out.println("get users");
		List<User> users=userService.getAll();
		model.addAttribute("users",users);
		return "userList";
	}
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") Integer id){
		userService.delete(id);
		return "redirect:/admin/userList";
	}
	@RequestMapping(value="/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model){
		System.out.println("The id to update is "+id);
		User user=userService.findById(id);
		System.out.println(user);
		model.addAttribute("user",user);
		return "edit";
	}
	@RequestMapping(value="/editUser",method=RequestMethod.POST)
	public String editUser(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,RedirectAttributes redirectAttrs){
		System.out.println("Editing using edit User");
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getAllErrors());
			return "addUser";
		}
		userService.edit(user);
		redirectAttrs.addFlashAttribute("message",user.getFirstName()+" "+user.getLastName()+" Successfully edited");
		return "redirect:/admin/userList";
	}
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String newUser(@ModelAttribute("user")@Valid  User user,BindingResult bindingResult,RedirectAttributes redirectAttrs){
		if(bindingResult.hasErrors()){
			return "addUser";
		}
		String newPassword=this.MD5(user.getPassword());
		user.setPassword(newPassword);
		Role role=new Role();
		role.setId(RandomUtils.nextInt());
		role.setRole("ADMIN");
		role.setUser(user);
		user.setRole(role);
		userService.save(user);
		redirectAttrs.addFlashAttribute("message","Welcome "+user.getFirstName());
		System.out.println("adduser have called");
		return "redirect:/admin/userList";
		
		
	}
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String home(Model model) {
		return "adminHome";
	}
	public String MD5(String md5){
		java.security.MessageDigest md;
		
		try {
			md = java.security.MessageDigest.getInstance("MD5");
			byte[] array=md.digest(md5.getBytes());
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
}
