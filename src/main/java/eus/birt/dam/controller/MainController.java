package eus.birt.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.StudentRepository;
import eus.birt.dam.repository.CourseRepository;

@Controller
public class MainController {
	
		@GetMapping("/list")
		public String getList(Model model){
		//model.addAttribute("students",studentRepository.findAll());
        return "/";
       
    		
    		
		}
		
		@GetMapping("/courses")
		public String getCourse(Model model){
			return "courses";
		}
		
		@GetMapping("/instructor_details")
		public String getInstructor_detail(){
			return "instructor_details";
		}
		@GetMapping("/instructors")
		public String getInstructor(){
			return "instructors";
		}
		@GetMapping("/projects")
		public String getProject(){
			return "projects";
		}
		@GetMapping("/tuitions")
		public String getTuition(){
			return "tuitions";
		}
		@GetMapping("/universitys")
		public String getUniversity(){
			return "universitys";
		}
}
