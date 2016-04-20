package fr.afcepf.atod26.webservice.avance.data.impl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.atod26.webservice.avance.data.api.IDaoAdresse;
import fr.afcepf.atod26.webservice.avance.entity.Adresse;
import fr.afcepf.atod26.webservice.avance.exception.WSException;

@Service
public class DaoAdresseImpl implements IDaoAdresse {

	private Logger log = Logger.getLogger(DaoAdresseImpl.class);

	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public Adresse ajouterAdresse(final Adresse paramAdresse) throws WSException {
		log.info("Passage dans la méthode ajouterAdresse");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.save(paramAdresse);
		} catch (HibernateException e) {
			log.error(e);
			throw new WSException("Erreur 001" + e.getMessage());
		}
		return paramAdresse;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
