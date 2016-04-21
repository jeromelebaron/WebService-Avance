package fr.afcepf.atod26.webservice.avance.business.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(namespace = "http://lebaronjerome.webserviceavance.atod26.afcepfr")
@XmlType(name = "adresse")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdresseDTO {

	@XmlElement(name = "idAdresse")
	private Integer id;

	@XmlElement(name = "numeroAdresse")
	private String numero;

	@XmlElement(name = "rueAdresse")
	private String rue;

	@XmlElement(name = "villeAdresse")
	private String ville;

	@XmlElement(name = "codePostalAdresse")
	private String codePostal;

	public AdresseDTO() {
		// EMPTY
	}

	public AdresseDTO(Integer id, String numero, String rue, String ville, String codePostal) {
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

}
