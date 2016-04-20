package fr.afcepf.atod26.webservice.avance.data.api;

import java.util.List;

import fr.afcepf.atod26.webservice.avance.entity.Personne;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

public interface IDaoPersonne {

	Personne ajouterPersonne(Personne paramPersonne) throws WSException;

	List<Personne> rechercherPersonne(String paramVille);

}
