package fr.afcepf.atod26.webservice.avance.business.impl;

import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import fr.afcepf.atod26.webservice.avance.business.api.IBusinessWS;
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
	public Personne ajouterPersonne(Personne paramPersonne) throws WSException {
		log.info("Dans la méthode ajouterPersonne");
		daoPersonne.ajouterPersonne(paramPersonne);
		return paramPersonne;
	}

	@Override
	public List<Personne> rechercherPersonne(String paramVille) {
		log.info("Dans la méthode rechercherPersonne");
		return daoPersonne.rechercherPersonne(paramVille);
	}

	public void setDaoPersonne(IDaoPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}

	public void setDaoAdresse(IDaoAdresse daoAdresse) {
		this.daoAdresse = daoAdresse;
	}
	
	
}
