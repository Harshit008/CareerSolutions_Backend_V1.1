package com.zensar.service;

import java.util.List;
import java.util.Optional;

import com.zensar.entities.Jobs;
import com.zensar.entities.Recruiter;
import com.zensar.entities.Resume;
import com.zensar.entities.Skills;
import com.zensar.exception.MailException;

public interface CareerSolutionsRecruiterService {

	public List<Recruiter> getRecruiter();
	//List<Recruiter> getProduct();

	public Recruiter getRecruiterById(int recruiterId);

	public Recruiter registerRecruiter(Recruiter recruiter) throws MailException;

	public Recruiter recruiterLogin(String uname, String pass);

	public Jobs insertJob(Jobs job);

	public List<Jobs> getJobsByRecruiterId(int rid);

	public Recruiter recruiterByItsUsername(String username);

	public Skills insertSkills(Skills skill1);

	public List<Jobs> getJobs();

	public List<Skills> getSkills();

	public Jobs getJobsByJobId(int jid);

	public Skills getSkillsBySkillId(int sid);

	public void deleteJob(int jobId);

	public Optional<Resume> getFile(Integer fileId);


	

	// localhost:8080/{productId} products Endpoint
//	Recruiter getRecruiter(int productId);
//	
//	List<Recruiter> getRecruiterByName(String productName);
//	List<Recruiter> getProductByCost(int productCost);
//
//	Recruiter insertProduct(Recruiter Recruiter);
//
//	void deleteProduct(int productId);
//
//	Recruiter updateProduct(int productId, Recruiter Recruiter);


}
