package fr.afcepf.atod26.webservice.avance.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import fr.afcepf.atod26.webservice.avance.business.api.IBusinessWS;
import fr.afcepf.atod26.webservice.avance.business.assembleur.DTOToEntity;
import fr.afcepf.atod26.webservice.avance.business.assembleur.EntityToDTO;
import fr.afcepf.atod26.webservice.avance.business.dto.AdresseDTO;
import fr.afcepf.atod26.webservice.avance.business.dto.PersonneDTO;
import fr.afcepf.atod26.webservice.avance.data.api.IDaoAdresse;
import fr.afcepf.atod26.webservice.avance.data.api.IDaoPersonne;
import fr.afcepf.atod26.webservice.avance.entity.Personne;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

@WebService(endpointInterface = "fr.afcepf.atod26.webservice.avance.business.api.IBusinessWS", targetNamespace = "http://lebaronjerome.webserviceavance.atod26.afcepfr", serviceName = "businessWs")
public class BusinessWSImpl implements IBusinessWS {

	private Logger log = Logger.getLogger(BusinessWSImpl.class);

	private IDaoPersonne daoPersonne;

	private IDaoAdresse daoAdresse;

	@Override
	public PersonneDTO ajouterPersonne(final PersonneDTO paramPersonne) throws WSException {
		log.info("Dans la méthode ajouterPersonne");
		daoPersonne.ajouterPersonne(DTOToEntity.fromDTOPersonneToEntityPersonne(paramPersonne));
		return paramPersonne;
	}

	@Override
	public List<PersonneDTO> rechercherPersonne(final AdresseDTO paramAdresse) {
		log.info("Dans la méthode rechercherPersonne");
		List<Personne> lesPersonnes = daoPersonne.rechercherPersonne(DTOToEntity
				.fromDTOAdresseToEntityAdresse(paramAdresse));
		List<PersonneDTO> lesPersonnesDTO = new ArrayList<>();
		for (final Personne personne : lesPersonnes) {
			PersonneDTO personneDTO = EntityToDTO.fromPersonneEntityToPersonneDTO(personne);
			lesPersonnesDTO.add(personneDTO);
		}
		return lesPersonnesDTO;
	}

	public void setDaoPersonne(IDaoPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public void setDaoAdresse(IDaoAdresse daoAdresse) {
		this.daoAdresse = daoAdresse;
	}

}
