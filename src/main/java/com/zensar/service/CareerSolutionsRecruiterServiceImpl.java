package com.zensar.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entities.Jobs;
import com.zensar.entities.NotificationEmail;
import com.zensar.entities.Recruiter;
import com.zensar.entities.Resume;
import com.zensar.entities.Skills;
import com.zensar.entities.VerificationToken;
import com.zensar.exception.MailException;
import com.zensar.repository.RecruiterRepository;
import com.zensar.repository.ResumeRepository;
import com.zensar.repository.JobsRepository;
import com.zensar.repository.SkillsRepository;
import com.zensar.repository.VerificationTokenRepository;

@Service
public class CareerSolutionsRecruiterServiceImpl implements CareerSolutionsRecruiterService {
	@Autowired
	private RecruiterRepository repository;

	@Autowired
	private JobsRepository jobsRepository;

	@Autowired
	private SkillsRepository skillsRepository;
	
	@Autowired
	private ResumeRepository resumeRepository;
	
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Autowired
	private MailService mailService;

	@Override
	public List<Recruiter> getRecruiter() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Recruiter getRecruiterById(int recruiterId) {
		return repository.findById(recruiterId).get();
	}

	@Override
	public Recruiter registerRecruiter(Recruiter recruiter) throws MailException {
		boolean res = repository.save(recruiter) != null;

		String token = generateVerificationToken(recruiter);
		mailService.sendMail(new NotificationEmail("Please Activate your account",recruiter.getEmail(),"Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));
		if (res)
		return recruiter;
	else
		return null;
		
		
	}

	private String generateVerificationToken(Recruiter recruiter) {
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken= new VerificationToken();
		verificationToken.setToken(token);
		verificationToken.setRecruiter(recruiter);
		verificationTokenRepository.save(verificationToken);
		return token;
	}

	@Override
	public Recruiter recruiterLogin(String uname, String pass) {
		// TODO Auto-generated method stub
		Recruiter recruiterByItsUsernameAndPassword = repository.recruiterByItsUsernameAndPassword(uname, pass);
		return recruiterByItsUsernameAndPassword;
	}

	@Override
	public Jobs insertJob(Jobs job) {
		boolean res = jobsRepository.save(job) != null;
		if (res)
			return job;
		else
			return null;
	}

	public List<Jobs> getJobsByRecruiterId(int rid) {
		Recruiter recruiter = repository.findById(rid).get();
		
		return null;

	}

	@Override
	public Recruiter recruiterByItsUsername(String username) {

		return repository.recruiterByItsUsername(username);
	}

	@Override
	public Skills insertSkills(Skills skill1) {
		boolean res = skillsRepository.save(skill1) != null;
		if (res)
			return skill1;
		else
			return null;

	}

	@Override
	public List<Jobs> getJobs() {

		return jobsRepository.findAll();
	}

	@Override
	public List<Skills> getSkills() {

		return skillsRepository.findAll();
	}

	@Override
	public Jobs getJobsByJobId(int jid) {

		return jobsRepository.findById(jid).get();
	}

	@Override
	public Skills getSkillsBySkillId(int sid) {

		return skillsRepository.findById(sid).get();
	}

	@Override
	public void deleteJob(int jobId) {
		jobsRepository.deleteById(jobId);
	}

	@Override
	public  Optional<Resume> getFile(Integer fileId) {
		  return resumeRepository.findById(fileId);
	}

}
