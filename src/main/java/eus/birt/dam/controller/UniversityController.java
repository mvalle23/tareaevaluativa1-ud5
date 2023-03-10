package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.repository.UniversityRepository;

@Controller
public class UniversityController {
	
	@Autowired
   	private UniversityRepository universityRepository;
    
    @RequestMapping({"/universitys"})
    public String getUniversitys(Model model){

        model.addAttribute("universitys", universityRepository.findAll());

        return "universitys/university";	
    }
 
}
