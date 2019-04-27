package services;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;



@Remote
public interface serviceStatRemote {
	public float statEntreprise (String year , String year1);
	public float statEntrepris (String year , String year1);
	public float statEntrepri (String year , String year1);
	public float statEntrepr (String year , String year1);
	public float statEntrep (String year , String year1);
	public float statEntre (String year);
	public float statEntr (String year);
	public float statEnt (String year);
	public float statEn(String year);
	public float statE(String year);
	public float statEL (String year);
	public float statEnL (String year);
	public float statEntL (String year);
	public float statEntrL (String year);
	public float statEntreL (String year);
	public float statEntrepriseFAR (String year , String year1);
	 public float statEntrepriseAr (String year , String year1);
	 public float statEntrepriseG (String year , String year1);
	 public float statEntrepriseA (String year , String year1);
	 public float statEntrepriseF (String year , String year1);
	 public  Map<Integer, String> statCandidat(String year);
}
