package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Address;
import eus.birt.dam.domain.Course;
import eus.birt.dam.domain.Instructor;
import eus.birt.dam.domain.Instructor_detail;
import eus.birt.dam.domain.Project;
import eus.birt.dam.domain.Student;
import eus.birt.dam.domain.Tuition;
import eus.birt.dam.domain.University;
import eus.birt.dam.repository.CourseRepository;
import eus.birt.dam.repository.InstructorRepository;
import eus.birt.dam.repository.Instructor_detailRepository;
import eus.birt.dam.repository.StudentRepository;
import eus.birt.dam.repository.TuitionRepository;
import eus.birt.dam.repository.UniversityRepository;
import eus.birt.dam.repository.ProjectRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	
	//Para autorizar todos los repositorios utilzados
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private TuitionRepository tuitionRepository;
	@Autowired
	private UniversityRepository universityRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private Instructor_detailRepository instructor_detailRepository;
	@Autowired
	private ProjectRepository projectRepository;



	
	@Transactional //Metodo con única transaccion, evita: object references an unsaved transient instance
	@Override
	public void run(String... arg0) throws Exception {
		Student student1 = new Student("Juan", "Sanchez","jusa@hotmail.com");
		Address address1 = new Address("Barrio Gimeno", "04","Burgos", "14000");
		Address address2 = new Address("Calle alcoy", "07","Alacant", "00005");
		Tuition tuition1 = new Tuition(7000.0);
		University university1 = new University("Universidad de Alicante");
		Course course1 = new Course("Historia",6);
		Instructor instructor1 = new Instructor("Manuel", "Loma", "malo@hotmail.com");
		Instructor_detail instructorDetail1 = new Instructor_detail("laCasadelLibro.com", "Libros");
		Project project1 = new Project("Proyecto", "Gestión de datos", "500");
	
		
		
		instructorDetail1.setInstructor(instructor1);
		instructor1.setInstructorDetail(instructorDetail1);
		instructor1.setAddress(address2);
		instructor1.getCourses().add(course1);
		instructor1.getProyecto().add(project1);
		project1.getInstructor().add(instructor1);
		student1.setAddress(address1);
		student1.getPhones().add("654002030");
		student1.getPhones().add("6062036205");
		student1.setBirthdate(LocalDate.parse("1995-01-04"));
		university1.setAddress(address1);
		student1.setTuition(tuition1);
		tuition1.setStudent(student1);
		student1.setUniversity(university1);
		university1.getStudents().add(student1);
		course1.getStudents().add(student1);
		student1.getCourses().add(course1);
	
		//se guardan los repositoris con sus tablas
		courseRepository.save(course1);	
		universityRepository.save(university1);
		studentRepository.save(student1);
		tuitionRepository.save(tuition1);
		instructorRepository.save(instructor1);
		instructor_detailRepository.save(instructorDetail1);
		projectRepository.save(project1);
		
		
		System.out.println("Started in Bootstrap");
        System.out.println("Number of Students: " + studentRepository.count());
			
	}
	
}