package webFrameApp.serviceLgoic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import webFrameApp.entites.Domain;
import webFrameApp.entites.SqldataTypes;
import webFrameApp.jdbcTemplate.DomainJDBC;

public class LooseEntity {
	// @Autowired
	// TypeDAOImpl typeDoaIMPL;
	ApplicationContext context = new ClassPathXmlApplicationContext(
			"classpath:META-INF/applicationContext.xml");
	DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
	JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());


	public void createLooseObjects(Domain Domain, String ObjectName,
			String[] attributes, String[] types,
			List<SqldataTypes> dataTypeList, int[] length, String[] other) {
		String catalog = Domain.getDomainName() + "_db";
		String createEnity = "CREATE TABLE IF NOT EXISTS " + "tbl_"
				+ ObjectName + "( ";
		String query = "";
		System.out.println("\n im inside \n");
		System.out.println("\n   " + length.length + ":" + attributes.length
				+ ":" + types.length);

		if (attributes.length > 1) {
			for (int x = 0; x < attributes.length; x++) {
				System.out.println("\n print things: " + x + " "
						+ attributes[x] + ":" + types[x] + ":" + other[x] + ":"
						+ length[x]);

				if (types[x].equals("GEOMETRY")) {
					query = query + "," + attributes[x] + " " + types[x] + " "
							+ other[x];
				} else {
					query = query + attributes[x] + " " + types[x] + "("
							+ length[x] + ") " + other[x];
					if (x < attributes.length - 1) {
						query = query + ",";
					}
				}
			}
		}

		createEnity = createEnity + query + ")";
		createEnity.replaceAll("null", "");
		System.out.println("Statement to create table: " + createEnity);
		Connection connect=null;
		try {
			connect = jdbc.getDataSource().getConnection();
			connect.setCatalog(catalog);
			PreparedStatement statement = connect
					.prepareStatement(createEnity);
			int update = statement.executeUpdate();
			statement.close();
			System.out.println("Query Updated::  to this catalog"
					+ connect.getCatalog());

			connect.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
