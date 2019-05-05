package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Condidate_Profile;
import entity.Experience;
import entity.Skill;
import entity.User;

/**
 * Session Bean implementation class Service_Candidate_Profile
 */
@Stateless
@LocalBean
public class Service_Candidate_Profile implements Service_Candidate_ProfileRemote {
	@PersistenceContext(unitName="evaders-ejb")
	 EntityManager em;

    /**
     * Default constructor. 
     */
    public Service_Candidate_Profile() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public int addCandidateProfile(Condidate_Profile condidate_Profile) {
		em.persist(condidate_Profile);
		return condidate_Profile.getId();
	}

	
	@Override
	public int affectUser(int userId, int profileId) {
		User user = em.find(User.class, userId);
		Condidate_Profile condidate_Profile = em.find(Condidate_Profile.class, profileId);
		condidate_Profile.setUserCondidate(user);		
		return condidate_Profile.getId();
	}
	@Override
	public int addExperience(Experience experience, int profileId) {
		Condidate_Profile condidate_Profile = em.find(Condidate_Profile.class, profileId);
		experience.setCondidate(condidate_Profile);
		em.persist(experience);
		condidate_Profile.getExperiences().add(experience);
		return condidate_Profile.getId();
	}

	@Override
	public int addSkill(Skill skill, int profileId) {
		Condidate_Profile condidate_Profile = em.find(Condidate_Profile.class, profileId);
		skill.setCandidate(condidate_Profile);
		em.persist(skill);
		condidate_Profile.getSkills().add(skill);
		return condidate_Profile.getId();
	}

	

}
