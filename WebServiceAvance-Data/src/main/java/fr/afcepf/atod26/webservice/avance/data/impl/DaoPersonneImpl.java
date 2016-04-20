package fr.afcepf.atod26.webservice.avance.data.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod26.webservice.avance.data.api.IDaoPersonne;
import fr.afcepf.atod26.webservice.avance.entity.Personne;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

@Service
public class DaoPersonneImpl implements IDaoPersonne {

	private SessionFactory sessionFactory;

	private Logger log = Logger.getLogger(DaoAdresseImpl.class);

	private static final String REQUETE_RECHERCHER_PERSONNE = "FROM Personne p WHERE p.adresse.ville = :paramVille";

	@Override
	@Transactional
	public Personne ajouterPersonne(Personne paramPersonne) throws WSException {
		log.info("Passage dans la méthode ajouterPersonne");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(paramPersonne);
		} catch (HibernateException e) {
			log.error(e);
			throw new WSException("Erreur Hibernate");
		}
		return paramPersonne;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Personne> rechercherPersonne(String paramVille) {
		log.info("Passage dans la méthode ajouterPersonne");
		List<Personne> lesPersonnes = new ArrayList<>();
		try {
			Session session = sessionFactory.getCurrentSession();
			lesPersonnes = session.createQuery(REQUETE_RECHERCHER_PERSONNE).setParameter("paramVille", paramVille)
					.list();
		} catch (HibernateException e) {
			log.error(e);
		}
		return lesPersonnes;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
