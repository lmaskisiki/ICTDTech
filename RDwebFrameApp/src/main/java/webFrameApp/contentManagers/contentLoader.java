package webFrameApp.contentManagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import webFrameApp.jdbcTemplate.DomainJDBC;

public class contentLoader {
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:META-INF/applicationContext.xml");
	DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
	JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());
	private final String tablePrefix = "tbl_";
	private final String dbSufix = "_db";

	// ///get column names of the table with the name in arguments
	public String[] getCoulumn(String domain, String table) {
		String catalog = domain.trim() + dbSufix;
		String newTable = tablePrefix + table;
		String sql = "Select * from " + newTable;
		String[] columns = null;
		try {
			Connection con = jdbc.getDataSource().getConnection();
			con.setCatalog(catalog);
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			columns = new String[resultSetMetaData.getColumnCount()];
			for (int x = 1; x <= resultSetMetaData.getColumnCount(); x++) {
				columns[x - 1] = resultSetMetaData.getColumnName(x);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}/**/
		System.out.println("Return columns: with the length" + columns.length);
		return columns;
	}

	// ///get number of columns of the table with the name in arguments
	public int getColumnCount(String domain, String table) {
		String catalog = domain.trim() + dbSufix;
		String newTable = tablePrefix + table;
		String sql = "Select * from " + newTable;

		int numColumns = 0;
		try {
			Connection con = jdbc.getDataSource().getConnection();
			con.setCatalog(catalog);
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			numColumns = resultSetMetaData.getColumnCount();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numColumns;
	}

	// Return a list of records for a specific entity in a domain
	
	public List<List<Object>> getData(String domain, String entity) {
		String catalog = domain.trim() + dbSufix;
		String newTable = tablePrefix + entity;
		String sql = "Select * from " + newTable;
		contentLoader cl = new contentLoader();
		List<List<Object>> allData = new ArrayList<List<Object>>();
		try {
			Connection connect = jdbc.getDataSource().getConnection();
			connect.setCatalog(catalog);
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			int x = cl.getColumnCount(domain, entity);
			int columns = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				ArrayList<Object> list = new ArrayList<Object>(columns);
				for (int z = 1; z <= x; z++) {
					list.add(resultSet.getObject(z));
				}
				allData.add(list);
			}
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allData;
	}

}
