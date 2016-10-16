/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webFrameApp.serviceLgoic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import webFrameApp.jdbcTemplate.DomainJDBC;

/**
 *
 * @author Lizo
 */
public class GetAutoIncrement {

	private static final String CATALOG = "information_schema";
	private static final String TABLE_PREFIX = "tbl_";
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:META-INF/applicationContext.xml");
	DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
	JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());

	public String getColumn(String Table) {
		String sqlQeury = "select COLUMN_NAME from COLUMNS where TABLE_NAME='"
				+ Table + "' AND EXTRA like '%auto_increment%' ";
		String column = null;
		try {
			connection = jdbc.getDataSource().getConnection();
			connection.setCatalog(CATALOG);
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlQeury);
			while (rs.next()) {
				column = rs.getString(1);
			}
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(GetAutoIncrement.class.getName()).log(
					Level.SEVERE, null, ex);
		}
		if (column == null || column.equals("")) {
			return null;
		} else {
			return column;
		}

	}

	public HashMap<String, String[]> validateColumns(String Table, String[] col, String[] tps, String[] optValues) {
		Table = TABLE_PREFIX + Table;
		HashMap<String, String[]>  response= new HashMap<String, String[]>();
		GetAutoIncrement validateColumns = new GetAutoIncrement();
		List<String> atts = new ArrayList<String>();
		List<String> types = new ArrayList<String>();
		List<String> optVls = new ArrayList<String>();

		String removeColumn = validateColumns.getColumn(Table);
		for (int i = 0; i < col.length; i++) {
			if (!col[i].equals(removeColumn)) {
				atts.add(col[i]);
				types.add(tps[i]);
				optVls.add(optValues[i]);
			}
		}
		response.put("attributes", atts.toArray(new String[atts.size()]));
		response.put("types", types.toArray(new String[types.size()]));
		response.put("InputOptionValues", optVls.toArray(new String[optVls.size()]));
		return response;
	}
}
