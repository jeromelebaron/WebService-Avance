package fr.afcepf.atod26.webservice.avance.data.impl;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.afcepf.atod26.webservice.avance.data.api.IDaoPersonne;
import fr.afcepf.atod26.webservice.avance.entity.Adresse;
import fr.afcepf.atod26.webservice.avance.entity.Personne;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-data-test.xml")
public class DaoPersonneImplTest {

	@Autowired
	private IDaoPersonne daoPersonne;

	@Test
	public void testNotNull() {
		Assert.assertNotNull(daoPersonne);
	}

	@Test
	public void testAjouterPersonne() {
		Personne nouvellePersonne = new Personne(null, "LE BARON", "Jérome", new Date(), "lebaronjerome@free.fr",
				new Adresse(1, "33", "Chemin du fosse aumone", "Asnieres sur Seine", "92600"));
		try {
			daoPersonne.ajouterPersonne(nouvellePersonne);
		} catch (WSException e) {
			fail("Exception levée");
		}

		int idAttendu = 2;
		int idGenere = nouvellePersonne.getId().intValue();

		Assert.assertEquals("vérification de l'ajout d'une personne", idAttendu, idGenere);
	}

	@Test
	public void testRechercherPersonne() {
		List<Personne> lesPersonnesTrouves = daoPersonne.rechercherPersonne("Asnières sur Seine");
		
		int tailleListeAttendue = 1;
		int tailleListeGeneree = lesPersonnesTrouves.size();
		Assert.assertEquals("vérification de la récupération des personne", tailleListeAttendue, tailleListeGeneree);
		
		int idPersonneTrouveeAttendu = 1;
		int idPersonneTrouveeGenere = lesPersonnesTrouves.get(0).getId().intValue();
		Assert.assertEquals("vérification de l'id de la personne trouvée", idPersonneTrouveeAttendu, idPersonneTrouveeGenere);
		
		String mailPersonneTrouveeAttendu = "lebaronjerome@free.fr";
		String mailPersonneTrouveGenere = lesPersonnesTrouves.get(0).getMail();
		Assert.assertEquals("vérification du mail de la personne trouvée", mailPersonneTrouveeAttendu, mailPersonneTrouveGenere);
	}

}
