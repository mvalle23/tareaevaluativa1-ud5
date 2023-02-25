package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import entidad.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name="instructor")
public class Instructor extends BaseEntity{
	
	@Column (name= "first_name")
	private String firstName;
	
	@Column (name= "last_name")
	private String lastName;
	
	@Column (name= "email")
	private String email;
		
	@Embedded
	private Address address;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id" , referencedColumnName="id")
	private Instructor_detail InstructorDetail;
	
	
	@OneToMany
	@JoinColumn (name = "instructor_id")
	List <Course> courses = new ArrayList<>();
	
	@ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="instructor_project", joinColumns=@JoinColumn(name="instructor_id"), 
	inverseJoinColumns=@JoinColumn(name="project_id"))
	private Set<Project> proyecto = new HashSet<>();
	
	public Set<Project> getProyecto() {
		return proyecto;
	}

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		//this.address = address;
	}
	
}
