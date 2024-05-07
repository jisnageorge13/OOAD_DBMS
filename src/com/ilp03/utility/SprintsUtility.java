package com.ilp03.utility;
import java.sql.Connection;

import com.ilp03.service.SprintService;
import com.ilp03.dao.SprintsDAO;


public class SprintsUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SprintsDAO sprintsDAO = new SprintsDAO();
		Connection connection=null;
		connection=SprintsDAO.getConnection();
		sprintsDAO.insertIntoSprints(connection);

	}

}
