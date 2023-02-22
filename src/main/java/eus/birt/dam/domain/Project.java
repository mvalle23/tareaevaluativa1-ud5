package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import entidad.Instructor;
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
public class Project extends BaseEntity{
	
	@Column (name= "name")
	private String name;
	
	@Column (name= "field")
	private String field;
	
	@Column (name= "budget")
	private String budget;
	
	//ManyToMany bidireccional con instructor mediante instructor_project
	@ElementCollection
	@CollectionTable(name= "instructor_project", joinColumns=@JoinColumn(name="project_id"))
	@Column(name="instructor_id")
	private List<String> proyectos = new ArrayList<String>();
		
	
	@ManyToMany (mappedBy="proyecto")
	private Set<Instructor> instructor = new HashSet<>();
		

	public Project(String name, String field, String budget) {
		super();
		this.name = name;
		this.field = field;
		this.budget = budget;
	}
	
}
