package com.aviastore.dao;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffBaseDAO {
	public boolean authorization(String log, String pass);

}
