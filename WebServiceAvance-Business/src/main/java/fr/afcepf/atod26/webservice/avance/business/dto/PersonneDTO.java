package fr.afcepf.atod26.webservice.avance.business.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://lebaronjerome.webserviceavance.atod26.afcepfr")
@XmlType(name = "personne")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonneDTO {

	@XmlElement(name = "idPersonne")
	private Integer id;

	@XmlElement(name = "nomPersonne")
	private String nom;

	@XmlElement(name = "dateNaissancePersonne")
	private Date dateDeNaissance;

	@XmlElement(name = "mailPersonne")
	private String mail;

	@XmlElement(name = "adressePersonne")
	private AdresseDTO adresse;

	public PersonneDTO() {
		// EMPTY
	}

	public PersonneDTO(Integer id, String nom, Date dateDeNaissance, String mail, AdresseDTO adresse) {
		this.id = id;
		this.nom = nom;
		this.dateDeNaissance = dateDeNaissance;
		this.mail = mail;
		this.adresse = adresse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public AdresseDTO getAdresse() {
		return adresse;
	}

	public void setAdresse(AdresseDTO adresse) {
		this.adresse = adresse;
	}

}
