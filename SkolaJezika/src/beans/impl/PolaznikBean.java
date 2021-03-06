package beans.impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Polaznik11;

@Stateful
@LocalBean
public class PolaznikBean {
	@PersistenceContext
	EntityManager em;
	
	private Polaznik11 polaznik;

    public PolaznikBean() {
    	
    }

	public Polaznik11 getPolaznik() {
		return polaznik;
	}

	public void setPolaznik(Polaznik11 polaznik) {
		this.polaznik = polaznik;
	}

	public boolean login(String username, String password) {
		try {
			TypedQuery<Polaznik11> query = em.createNamedQuery(
					"Polaznik11.findZaUsernameIPassword",
					Polaznik11.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			polaznik = query.getResultList().get(0);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
