package fr.afcepf.atod26.webservice.avance.data.impl;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.atod26.webservice.avance.data.api.IDaoAdresse;
import fr.afcepf.atod26.webservice.avance.entity.Adresse;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-data.xml")
public class DaoAdresseImplTest {

	@Autowired
	private IDaoAdresse daoAdresse;

	@Test
	public void testNotNull() {
		Assert.assertNotNull(daoAdresse);
	}

	@Test
	public void testAjouterAdresse() {
		Adresse adresseAAjouter = new Adresse(null, "33", "Chemin du fossé de l'aumone", "Asnières sur Seine", "92600");
		try {
			daoAdresse.ajouterAdresse(adresseAAjouter);
		} catch (WSException e) {
			fail("Exception lancée");
		}

		int idAttendu = 1;
		int idGenere = adresseAAjouter.getId().intValue();

		Assert.assertEquals("vérification de l'ajout d'une adresse", idAttendu, idGenere);
	}

}
