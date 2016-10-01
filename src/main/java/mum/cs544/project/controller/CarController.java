package mum.cs544.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.cs544.project.domain.Car;
import mum.cs544.project.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	CarService carService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.GET)
	public String createCar(@ModelAttribute("car") Car car) {
		System.out.println("addCar method");
		return "addCar";
	}

	@RequestMapping(value = "/carList", method = RequestMethod.GET)
	public String getCar(Model model) {
		System.out.println("get cars");
		List<Car> cars = carService.getAll();
		model.addAttribute("cars", cars);
		return "carList";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		carService.delete(id);
		return "redirect:/car/carList";
	}

	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		System.out.println("The id to update is " + id);
		Car car = carService.findById(id);
		System.out.println(car);
		model.addAttribute("car", car);
		return "editCar";
	}

	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	public String newCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult,
			RedirectAttributes redirectAttrs) {
		if (bindingResult.hasErrors()) {
			System.out.println("errors:");
			Iterator<ObjectError> errors = bindingResult.getAllErrors().iterator();
			while (errors.hasNext()) {
				System.out.println(errors.next().getDefaultMessage());
			}
			return "addCar";
		}

		carService.save(car);
		redirectAttrs.addFlashAttribute("message", "Welcome ");
		System.out.println("adduser have called");
		return "redirect:/car/carList";

	}

	@RequestMapping(value = "/editCar", method = RequestMethod.POST)
	public String editCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult,
			RedirectAttributes redirectAttrs) {
		System.out.println("Editing usig edit User");
		if (bindingResult.hasErrors()) {
			return "addCar";
		}
		carService.edit(car);
		redirectAttrs.addFlashAttribute("message", " Successfully edited");
		return "redirect:/car/carList";
	}

}
