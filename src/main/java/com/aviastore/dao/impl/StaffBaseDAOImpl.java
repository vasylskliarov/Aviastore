package com.aviastore.dao.impl;

import java.util.List;
import javax.persistence.*;
import com.aviastore.dao.*;
import com.aviastore.entitys.*;

import org.springframework.stereotype.Repository;

@Repository
public abstract class StaffBaseDAOImpl implements StaffBaseDAO {
	@PersistenceContext
	protected EntityManager em;
	protected boolean access = false;
	protected String permission = null;
	
	public StaffBaseDAOImpl() {}
	public boolean authorization(String login, String password) {
		TypedQuery<Security> query = em.createQuery(
				"SELECT s FROM Security s WHERE s.login = '" + login + "'",
				Security.class);
		List<Security> listM = null;
		try {
			listM = query.getResultList();

			if (!listM.isEmpty()) {
				if (listM.get(0).getPassword().equals(password)) {
					access = true;
					permission = listM.get(0).getPermission();
					return true;
				}
			}
		} finally {}
		return false;
	}
}