package fr.afcepf.atod26.webservice.avance.data.api;

import fr.afcepf.atod26.webservice.avance.entity.Adresse;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

/**
 * Tout ce qui concerne la persistance de l'entité Adresse.
 * @author Jérome
 */
public interface IDaoAdresse {

	/**
	 * Pour ajouter une adresse dans la bdd.
	 * @param paramAdresse l'adresse à ajouter.

	 * @return l'adresse avec son id.
	 * @throws WSException si l'ajout se passe mal.
	 */
	Adresse ajouterAdresse(Adresse paramAdresse) throws WSException;
	
}
