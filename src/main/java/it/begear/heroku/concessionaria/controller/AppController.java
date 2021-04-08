package it.begear.heroku.concessionaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.begear.heroku.concessionaria.entity.Auto;
import it.begear.heroku.concessionaria.service.AutoService;

@Controller
public class AppController {

	@Autowired
	AutoService autoService;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@RequestMapping("/Auto")
	public String viewHomePageAuto(Model model, @Param("keyword") String keyword) {
		List<Auto> auto = autoService.ListAll(keyword);
		auto = autoService.orderByMarca();
		model.addAttribute("auto", auto);
		model.addAttribute("keyword", keyword);
		
		return "Auto";
	}
	
	@RequestMapping("/newAuto")
	public String showNewAuto(Model model) {
		Auto a = new Auto();
		model.addAttribute("auto", a);
		return "NewAuto";
	}
	
	@RequestMapping(value = "/saveAuto", method = RequestMethod.POST)
	public String saveAuto(@ModelAttribute("auto") Auto a) {
		autoService.save(a);
		return "redirect:/";
	}
	
	@RequestMapping("/edit_Auto/{id_auto}")
	public ModelAndView showEditNewAuto(@PathVariable(name = "id_auto") int id_auto) {
		ModelAndView mav = new ModelAndView("Edit_Auto");
		Auto a = autoService.getAuto(id_auto);
		mav.addObject("auto", a);
		return mav;
	}
	
	@RequestMapping("delete_Auto/{id_auto}")
	public String deleteAuto(@PathVariable(name = "id_auto") int id_auto) {
		autoService.delete(id_auto);
		return "redirect:/";
	}
}
