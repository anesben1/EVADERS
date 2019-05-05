package services;

import javax.ejb.Remote;

import entity.Condidate_Profile;
import entity.Experience;
import entity.Skill;

@Remote
public interface Service_Candidate_ProfileRemote {
	int addCandidateProfile(Condidate_Profile condidate_Profile);
	int addExperience(Experience experience,int profileId);
	int affectUser(int userId,int profileId);
	int addSkill(Skill skill,int profileId);
	
	

}
