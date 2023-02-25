package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="instructor_detail")
public class Instructor_detail extends BaseEntity{
	
	
	@Column (name="blog")
	private String blog;
	
	@Column (name="hobby")
	private String hobby;
	
	//OneToOne bidirecional con instructor
	@OneToOne (mappedBy="InstructorDetail", cascade=CascadeType.ALL) 
	private Instructor instructor;
	
	public Instructor_detail (String blog, String hobby) {
		super();
		this.blog = blog;
		this.hobby = hobby;
	}
}