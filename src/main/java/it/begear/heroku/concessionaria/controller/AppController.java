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
import it.begear.heroku.concessionaria.entity.Moto;
import it.begear.heroku.concessionaria.service.AutoService;
import it.begear.heroku.concessionaria.service.MotoService;

@Controller
public class AppController {

	@Autowired
	AutoService autoService;
	@Autowired
	MotoService motoService;

	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String returnHomepage() {
		return "redirect:/";
	}
	
	@RequestMapping("/Auto")
	public String viewHomePageAuto(Model model, @Param("keyword") String keyword) {
		List<Auto> auto = autoService.ListAll(keyword);
		model.addAttribute("auto", auto);
		model.addAttribute("keyword", keyword);
		
		return "Auto";
	}
	
	@RequestMapping("/Moto")
	public String viewHomePageMoto(Model model, @Param("keyword") String keyword) {
		List<Moto> moto = motoService.ListAllMoto(keyword);
		
		model.addAttribute("moto", moto);
		model.addAttribute("keyword", keyword);
		
		return "Moto";
	}
	
	
	@RequestMapping("/newAuto")
	public String showNewAuto(Model model) {
		Auto a = new Auto();
		model.addAttribute("auto", a);
		return "NewAuto";
	}
	
	@RequestMapping("/newMoto")
		public String showNewMoto(Model model) {
		Moto m = new Moto();
		model.addAttribute("moto", m);
		
		return "NewMoto";
	}
	
	
	@RequestMapping(value = "/saveAuto", method = RequestMethod.POST)
	public String saveAuto(@ModelAttribute("auto") Auto a) {
		autoService.save(a);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/saveMoto", method = RequestMethod.POST)
	public String saveMoto(@ModelAttribute("moto") Moto m){
		motoService.saveMoto(m);
		return "redirect:/";
	}
	
	@RequestMapping("/edit_Auto/{id_auto}")
	public ModelAndView showEditNewAuto(@PathVariable(name = "id_auto") int id_auto) {
		ModelAndView mav = new ModelAndView("Edit_Auto");
		Auto a = autoService.getAuto(id_auto);
		mav.addObject("auto", a);
		return mav;
	}
	
	@RequestMapping("/edit_Moto/{id_moto}")
	public ModelAndView showEditNewMoto(@PathVariable(name = "id_moto") int id_moto) {
		ModelAndView mav = new ModelAndView("Edit_Moto");
		Moto m = motoService.getMoto(id_moto);
		mav.addObject("moto", m);
		return mav;
	}
	
	@RequestMapping("delete_Auto/{id_auto}")
	public String deleteAuto(@PathVariable(name = "id_auto") int id_auto) {
		autoService.delete(id_auto);
		return "redirect:/";
	}
	
	@RequestMapping("delete_Moto/{id_moto}")
	public String deleteMoto(@PathVariable(name="id_moto")int id_moto) {
		motoService.deleteMoto(id_moto);
		return "redirect:/";
	}
	
	
}
