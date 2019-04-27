package services;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import entity.Offer;
import entity.Skill;



/**
 * Session Bean implementation class serviceStat
 */
@Stateless
@LocalBean
public class serviceStat implements serviceStatRemote, serviceStatLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="evaders-ejb")
	EntityManager em;
	
    public serviceStat() {
        // TODO Auto-generated constructor stub
    }
    
   public float statEntreprise (String year , String year1){
    	 float x=0 ;
    	
    	 
    	TypedQuery<Offer> query = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'Java' AND speciality = 'java'",Offer.class);
    	List<Offer> results = query.setParameter("year", year).setParameter("year1", year1).getResultList();
    	//List<Offer> results = query.getResultList();    	
    		x=results.size();
    	 
    	return x; 
    	
    }
    

         	
         
    public float statEntrepris (String year , String year1){
   	 
   	 float f=0 ;
   
   	 	TypedQuery<Offer> query1 = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'java jee' AND speciality = 'Java JEE'",Offer.class);
   	 	List<Offer> result = query1.setParameter("year", year).setParameter("year1", year1).getResultList();
   	 	//List<Offer> result = query1.getResultList();    	
		f=result.size();
   	return f; 
   	
   }
    public float statEntrepri (String year , String year1){
    	
     float z=0 ;
      	TypedQuery<Offer> que = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'HTML5' AND speciality = 'html5' ",Offer.class);
    	List<Offer> result = que.setParameter("year", year).setParameter("year1", year1).getResultList();

      	//List<Offer> result = que.getResultList();    	
   		z=result.size();
      	return z; 
      	
      }
    
    
    public float statEntrepr (String year , String year1){
    	 
        float b=0 ;
        
         	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'C/C++'  ",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).setParameter("year1", year1).getResultList();

         	//List<Offer> result = quer.getResultList();    	
      		b=result.size();
         	return b; 
         	
         }
    
    public float statEntrep (String year , String year1){
     	 
        float a=0 ;
      
         	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality != 'HTML5'  AND speciality != 'Java' AND speciality != 'Java JEE'  ",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).setParameter("year1", year1).getResultList();

         	//List<Offer> result = quer.getResultList();    	
      		a=result.size();
         	return a; 
         	
         }  
 ////////////
   
    public float statEntre (String year){
   	 float x=0 ;
   	 
   	TypedQuery<Offer> query = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) = :year AND speciality = 'Java'",Offer.class);
   	List<Offer> results = query.setParameter("year", year).getResultList();

   	//List<Offer> results = query.getResultList();    	
   		x=results.size();
   	 
   	return x; 
   	
   }
   public float statEntr (String year){
  	 
  	 float y=0 ;
  	 	TypedQuery<Offer> query1 = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) = :year AND speciality = 'java jee' AND  speciality = 'Java JEE'",Offer.class);
  		List<Offer> result = query1.setParameter("year", year).getResultList();
  	 	//List<Offer> result = query1.getResultList(); 

		y=result.size();
  	return y; 
  	
  }
   public float statEnt (String year){
     	 
    float z=0 ;
     	TypedQuery<Offer> que = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) = :year AND speciality = 'HTML5' AND speciality = 'html5' ",Offer.class);
    	List<Offer> result = que.setParameter("year", year).getResultList();
     	//List<Offer> result = que.getResultList();    	
  		z=result.size();
     	return z; 
     	
     }
   
   
   public float statEn (String year){
   	 
       float b=0 ;
        	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) = :year AND speciality = 'C/C++'  ",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).getResultList();
        	//List<Offer> result = quer.getResultList();    	
     		b=result.size();
        	return b; 
        	
        }
   
   public float statE (String year){
    	 
       float a=0 ;
        	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) = :year AND speciality != 'HTML5'  AND speciality != 'Java' AND speciality != 'Java JEE'  ",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).getResultList();
        	//List<Offer> result = quer.getResultList();    	
     		a=result.size();
        	return a; 
        	
        }  
    
    
   
   //langue
   
   
   
   
   
   public float statEntrepriseF (String year , String year1){
    	 float x=0 ;
    	 TypedQuery<Offer> query = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'Frensh' AND speciality = 'frensh'",Offer.class);
    	 List<Offer> results = query.setParameter("year", year).setParameter("year1", year1).getResultList();   	
    	 x=results.size();
    	 return x; 
    }
    

         	
         
    public float statEntrepriseA (String year , String year1){
   	 float f=0 ;
   	 	TypedQuery<Offer> query1 = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'English' AND speciality = 'english'",Offer.class);
   	 	List<Offer> result = query1.setParameter("year", year).setParameter("year1", year1).getResultList();   	
		f=result.size();
   	return f; 
   	
   }
    public float statEntrepriseG (String year , String year1){
    	
     float z=0 ;
      	TypedQuery<Offer> que = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'German' AND speciality = 'german' ",Offer.class);
    	List<Offer> result = que.setParameter("year", year).setParameter("year1", year1).getResultList();
    	z=result.size();
      	return z; 
      	
      }
    
    
    public float statEntrepriseAr (String year , String year1){
    	 
        float b=0 ;
        
         	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality = 'Arabic' AND speciality = 'arabic'  ",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).setParameter("year1", year1).getResultList();

         	//List<Offer> result = quer.getResultList();    	
      		b=result.size();
         	return b; 
         	
         }
    
    public float statEntrepriseFAR (String year , String year1){
     	 
        float a=0 ;
      
         	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) BETWEEN :year AND :year1 AND speciality != 'Arabic' AND speciality != 'arabic' AND speciality != 'German' AND speciality != 'german' AND speciality != 'English' AND speciality != 'english' AND speciality != 'Frensh' AND speciality != 'frensh'  ",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).setParameter("year1", year1).getResultList();

         	//List<Offer> result = quer.getResultList();    	
      		a=result.size();
         	return a; 
         	
         }  
 ////////////
   
    public float statEntreL (String year){
   	 float x=0 ;
   	 TypedQuery<Offer> query = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) = :year AND speciality = 'Frensh' AND speciality = 'frensh'",Offer.class);
   	 List<Offer> results = query.setParameter("year", year).getResultList();   	
   	 x=results.size();
   	return x; 
   	
   }
   public float statEntrL (String year){
  	 float y=0 ;
  	 	TypedQuery<Offer> query1 = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) = :year AND speciality = 'English' AND speciality = 'english'",Offer.class);
  		List<Offer> result = query1.setParameter("year", year).getResultList();
		y=result.size();
  	return y; 
  	
  }
   public float statEntL (String year){
     	 
    float z=0 ;
     	TypedQuery<Offer> que = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) = :year AND speciality = 'German' AND speciality = 'german' ",Offer.class);
    	List<Offer> result = que.setParameter("year", year).getResultList();
     	//List<Offer> result = que.getResultList();    	
  		z=result.size();
     	return z; 
     	
     }
   
   
   public float statEnL (String year){
   	 
       float b=0 ;
        	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE SUBSTRING(O.date, 1, 4) = :year AND speciality = 'Arabic' AND speciality = 'arabic'",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).getResultList();
        	//List<Offer> result = quer.getResultList();    	
     		b=result.size();
        	return b; 
        	
        }
   
   public float statEL (String year){
    	 
       float a=0 ;
        	TypedQuery<Offer> quer = em.createQuery("SELECT O FROM Offer O  WHERE  SUBSTRING(O.date, 1, 4) = :year  AND speciality != 'Arabic' AND speciality != 'arabic' AND speciality != 'German' AND speciality != 'german' AND speciality != 'English' AND speciality != 'english' AND speciality != 'Frensh' AND speciality != 'frensh'   ",Offer.class);
        	List<Offer> result = quer.setParameter("year", year).getResultList();
        	//List<Offer> result = quer.getResultList();    	
     		a=result.size();
        	return a; 
        	
        }  
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    /*public float statRecrutement (){
   	 float r=0 ;
   	TypedQuery<Offer> query = em.createQuery("SELECT O FROM offer O WHERE YEAR(O.date)<2019 AND O.speciality =='java'",Offer.class);
   	List<Offer> results = query.getResultList();    	
   
   	//if()
   		r=r+1;
   	r=r/100;
   	return r; 
   }*/



/*Medcine*/
/*Génie civil*/

   
   public  Map<Integer, String> statCandidat (String year){
  	
  	List<Object[]> listSkil = em.createQuery( " SELECT count(s.content) AS NUMBER ,s.content AS content From Skill s where SUBSTRING(O.date, 1, 4) = :year AND s.speciality = 'informatique' Group By s.content").getResultList();
	Map<Integer, String> list = new HashMap<Integer, String>();
  	for (Object[] result : listSkil) {
		    String content = (String) result[1];
		    int count = ((Number) result[0]).intValue();
		    list.put(count,content);
		}
/*
	   Map<String, Long> xMap = new HashMap<String, Long>();
	   for (Skill f : listSkil) {
	   Query query = em.createQuery("SELECT count(s.id) FROM Skill s  WHERE s.content  = :con AND s.speciality = :informa");
	   Long val = (Long) query.setParameter("con", con).setParameter("informa", informa).getSingleResult();
	   		xMap.put(f.getContent(),val);
	   		}
	   		
	   		return xMap;*/
	   return list;
	   
	   
	   
	  // List<Skill> list = em.createQuery( "SELECT s.content, s.id FROM Skill s WHERE s.speciality = 'informatique' ",Skill.class).getResultList();
        	//SELECT s.content, count(s.content) FROM Skill s WHERE s.speciality = 'informatique' GROUP BY (content) 
	   //select `content` ,count(`content`) from skill WHERE `speciality`='informatique' group by (`content`)
        	//List<Offer> result = quer.setParameter("year", year).getResultList();
        	//List<Skill> result = quer.getResultList();    	
        	

        	//return list ; 
        	
        } 









}
