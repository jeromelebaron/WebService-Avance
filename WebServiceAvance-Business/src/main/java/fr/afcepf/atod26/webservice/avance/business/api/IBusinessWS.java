package fr.afcepf.atod26.webservice.avance.business.api;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import fr.afcepf.atod26.webservice.avance.business.dto.AdresseDTO;
import fr.afcepf.atod26.webservice.avance.business.dto.PersonneDTO;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

@WebService(targetNamespace = "http://lebaronjerome.webserviceavance.atod26.afcepfr")
@SOAPBinding(style = Style.RPC)
public interface IBusinessWS {

	@WebMethod(operationName = "ajouterUnePersonne")
	@WebResult(name = "personneAjoutee")
	PersonneDTO ajouterPersonne(@WebParam(name = "personneAAjouter") PersonneDTO paramPersonne) throws WSException;

	@WebMethod(operationName = "rechercherPersonne")
	@WebResult(name = "lesPersonnesTrouvees")
	List<PersonneDTO> rechercherPersonne(@WebParam(name = "adresseARechercher") AdresseDTO paramAdresse);

}
