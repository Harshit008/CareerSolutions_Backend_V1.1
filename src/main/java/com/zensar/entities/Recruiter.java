package com.zensar.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recruiter")
public class Recruiter {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int recruiterId;
	
	private String recruiterName;

	private String username;

	private String password;

	private String email;
	@JsonIgnore
	@OneToMany(mappedBy = "recruiter", orphanRemoval = true, cascade = CascadeType.ALL )	//Orphan Removal=true (Only Removes Child Without deleting the parent)
	private List<Jobs> jobs;

}
