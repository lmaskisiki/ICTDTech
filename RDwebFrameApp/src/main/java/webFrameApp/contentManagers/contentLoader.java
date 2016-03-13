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
	
	private final String tablePrefix="tbl_";
	private final String dbSufix="_db";



	// ///get column names of the table with the name in arguments
	public String[] getCoulumn(String domain,String table) {
		String catalog=domain.trim()+dbSufix;
		String  newTable=tablePrefix+table; 
		String sql = "Select * from " + newTable;
		System.out.println(sql);
//// a method to find the schema or a catalog that contains the table must be used  here...
		String[] columns = null;
		System.out.println("open try-catch block to get columns from metaData");
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

			 System.out.println("Close Connection");
		 con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}/**/
	 System.out.println("Return columns: with the length" + columns.length);
		return columns;
	}

	// ///get number of columns of the table with the name in arguments
	public int getColumnCount(String domain,String table) {
		String catalog=domain.trim()+dbSufix;
		String  newTable=tablePrefix+table;
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

	// /////////////////// ................//////////////////////////

	public List<List<Object>> getData(String domain,String table) {
		String catalog=domain.trim()+dbSufix;
		String  newTable=tablePrefix+table;
		System.out.println("the Catalog is: "+catalog);
		String sql = "Select * from " + newTable;
		contentLoader cl = new contentLoader();
		List<List<Object>> allData = new ArrayList<List<Object>>();
	 	try {

			Connection connect = jdbc.getDataSource().getConnection();
			connect.setCatalog(catalog);
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			int x = cl.getColumnCount(domain,table);
			int columns = resultSet.getMetaData().getColumnCount();
			while (resultSet.next()) {
				ArrayList<Object> list = new ArrayList<Object>(columns);
				for (int z = 1; z <= x; z++) {
					list.add(resultSet.getObject(z));
				}
				allData.add(list);
			}
 			System.out.println("his Size " + allData.size());
		 	// //////////////test below////////////////
connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return allData;
	}

}
