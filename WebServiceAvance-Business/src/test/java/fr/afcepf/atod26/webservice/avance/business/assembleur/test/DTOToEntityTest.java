package fr.afcepf.atod26.webservice.avance.business.assembleur.test;

import static org.junit.Assert.fail;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Test;

import fr.afcepf.atod26.webservice.avance.business.assembleur.DTOToEntity;
import fr.afcepf.atod26.webservice.avance.business.dto.AdresseDTO;
import fr.afcepf.atod26.webservice.avance.business.dto.PersonneDTO;
import fr.afcepf.atod26.webservice.avance.entity.Personne;

public class DTOToEntityTest {

	@Test
	public void testFromDTOPersonneToEntityPersonne() {
		PersonneDTO personneDTO = new PersonneDTO(1, "LE BARON", new Date(11111111111L), "lebaronjerome@free.fr",
				new AdresseDTO(1, "33", "Chemin du fossé de l'aumone", "Asnières sur Seine", "92600"));
		Personne personne = DTOToEntity.fromDTOPersonneToEntityPersonne(personneDTO);

		Assert.assertEquals("Vérification de l'id", personneDTO.getId(), personne.getId());
		Assert.assertEquals("Vérification du nom", personneDTO.getNom(), personne.getNom());
		Assert.assertEquals("Vérification de la date", personneDTO.getDateDeNaissance(), personne.getDateDeNaissance());
		Assert.assertEquals("Vérification du mail", personneDTO.getMail(), personne.getMail());
	}

	public void testFromDTOAdresseToEntityAdresse() {
		fail("Not yet implemented");
	}

}
