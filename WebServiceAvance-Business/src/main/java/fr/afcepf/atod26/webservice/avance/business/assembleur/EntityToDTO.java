package fr.afcepf.atod26.webservice.avance.business.assembleur;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.BeanUtils;

import fr.afcepf.atod26.webservice.avance.business.dto.AdresseDTO;
import fr.afcepf.atod26.webservice.avance.business.dto.PersonneDTO;
import fr.afcepf.atod26.webservice.avance.entity.Adresse;
import fr.afcepf.atod26.webservice.avance.entity.Personne;

public class EntityToDTO {

	private static DozerBeanMapper beanMapper = new DozerBeanMapper();

	private EntityToDTO() {
		// EMPTY
	}

	public static PersonneDTO fromPersonneEntityToPersonneDTO(final Personne paramPersonne) {
		final PersonneDTO personneDTO = new PersonneDTO();
		beanMapper.map(paramPersonne, personneDTO);
		personneDTO.setAdresse(fromAdresseEntityToAdresseDTO(paramPersonne.getAdresse()));
		return personneDTO;
	}

	public static AdresseDTO fromAdresseEntityToAdresseDTO(final Adresse paramAdresse) {
		final AdresseDTO adresseDTO = new AdresseDTO();
		BeanUtils.copyProperties(paramAdresse, adresseDTO);
		return adresseDTO;
	}

}
