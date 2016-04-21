package fr.afcepf.atod26.webservice.avance.business.assembleur;

import org.dozer.DozerBeanMapper;

import fr.afcepf.atod26.webservice.avance.business.dto.AdresseDTO;
import fr.afcepf.atod26.webservice.avance.business.dto.PersonneDTO;
import fr.afcepf.atod26.webservice.avance.entity.Adresse;
import fr.afcepf.atod26.webservice.avance.entity.Personne;

public class DTOToEntity {

	private static DozerBeanMapper beanMapper = new DozerBeanMapper();

	private DTOToEntity() {
		// EMPTY
	}

	public static Personne fromDTOPersonneToEntityPersonne(final PersonneDTO paramPersonneDTO) {
		final Personne personne = new Personne();
		beanMapper.map(paramPersonneDTO, personne);
		personne.setAdresse(fromDTOAdresseToEntityAdresse(paramPersonneDTO.getAdresse()));
		return personne;
	}

	public static Adresse fromDTOAdresseToEntityAdresse(final AdresseDTO paramAdresseDTO) {
		final Adresse adresse = new Adresse();
		beanMapper.map(paramAdresseDTO, adresse);
		return adresse;
	}

}
