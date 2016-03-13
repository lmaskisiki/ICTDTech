package webFrameApp.contentManagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import webFrameApp.entites.Domain;
import webFrameApp.entites.OrgEntity;
import webFrameApp.jdbcTemplate.DomainJDBC;
import webFrameApp.serviceLgoic.GetAutoIncrement;

public class addContent {

	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:META-INF/applicationContext.xml");
	DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
	// private String sqlAllTables =
	// "select TABLE_NAME from INFORMATION_SCHEMA.COLUMNS where column_name like 'domainId' AND TABLE_SCHEMA='test'";
	private String sqlAllTables = "select name from Domain";

	private Connection connect = null;

	public addContent() {

	}

	public boolean update(String db, String tbl) {

		return false;
	}

	// ////////////////////////////// Get All Tables
	// /////////////////////////////////////////////////////////////
	public ArrayList<String> getTables() {
		ArrayList<String> tables = new ArrayList<String>();
		ArrayList<String> formatedTables = new ArrayList<String>();

		try {
			connect = jdbcTemplate.getDataSource().getConnection();
			PreparedStatement statement = connect
					.prepareStatement(sqlAllTables);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				// tables.add(resultSet.getString("TABLE_NAME"));
				tables.add(resultSet.getString(1));
			}

			for (String table : tables) {
				formatedTables.add(table.replaceAll("tbl_", ""));
			}

			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formatedTables;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<String> getTableAttributes(OrgEntity ent) {

		String[] attribute = ent.getAttributes();
		GetAutoIncrement incrementCheck = new GetAutoIncrement();
		// remove any column that auto_increments-- using the method defined in
		// class 'GetAutoIncrement'
		//attribute = incrementCheck.validateColumns(ent.getName(), attribute);

		ArrayList<String> attributes = new ArrayList<String>();
		for (int x = 0; x < attribute.length; x++) {
			attributes.add(attribute[x]);

		}
		for (String arr : attributes) {
			System.out.println("Found int ArrayAttributes " + arr);
		}

		return attributes;
	}

	public boolean UpdateContent(Domain domain, OrgEntity entity, String[] data) {

		String[] entityAttributes = entity.getAttributes();
		//GetAutoIncrement incrementCheck = new GetAutoIncrement();
		// remove any column that auto_increments-- using the method defined in
		// class 'GetAutoIncrement'
		//entityAttributes = incrementCheck.validateColumns(entity.getName(),
			//	entityAttributes);

		String attributeString = "";
		String Qmarks = "";
		// for loop that converts an array of entity attributes to a SQL query
		// string part
		for (int x = 0; x < entityAttributes.length; x++) {
			attributeString = attributeString + entityAttributes[x];
			Qmarks = Qmarks + "?";
			if (x < entityAttributes.length - 1) {
				attributeString = attributeString + ",";
				Qmarks = Qmarks + ",";
			}

		}
		String sql = "INSERT INTO tbl_" + entity.getName() + " ("
				+ attributeString + ")   values  (" + Qmarks + ")";

		boolean saved = false;
		saved = saveUpdate(sql, data, domain.getDomainName(), entity.getName());
		System.out.println(sql);
		return saved;
	}

	public boolean saveUpdate(String sql, String[] data, String domainName,
			String entityName) {
		JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());
		Connection con = null;
		String newTable = "tbl_" + entityName;
		String catalog = domainName + "_db";
		System.out.println("the Catalog is: " + catalog);
		System.out.println("the tbale is :" + newTable);
		int results = 0;
		try {
			con = jdbc.getDataSource().getConnection();
			con.setCatalog(catalog);
			System.out.println("prepare statment next>>>>>>>>>>");
			PreparedStatement statement = con.prepareStatement(sql);
			for (int x = 1; x <= data.length; x++) {
				statement.setObject(x, data[x - 1]);
				System.out.println("set value to preparedStatement  \n  >>>>"
						+ data[x - 1]);
			}
			results = statement.executeUpdate();

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("There is a problem with sql Connection");
			e.printStackTrace();
		}
		if (results == 0) {
			return false;
		} else {
			return true;

		}
	}
}
