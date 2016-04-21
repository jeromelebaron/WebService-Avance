package fr.afcepf.atod26.webservice.avance.business.api;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import fr.afcepf.atod26.webservice.avance.entity.Adresse;
import fr.afcepf.atod26.webservice.avance.entity.Personne;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

@WebService(targetNamespace = "http://lebaronjerome.webserviceavance.atod26.afcepfr")
@SOAPBinding(style = Style.RPC)
public interface IBusinessWS {

	@WebMethod(operationName = "ajouterUnePersonne")
	@WebResult(name = "personneAjoutee")
	Personne ajouterPersonne(@WebParam(name = "personneAAjouter") Personne paramPersonne) throws WSException;

	@WebMethod(operationName = "rechercherPersonne")
	@WebResult(name = "lesPersonnesTrouvees")
	List<Personne> rechercherPersonne(@WebParam(name = "adresseARecherche") Adresse paramAdresse);

}
