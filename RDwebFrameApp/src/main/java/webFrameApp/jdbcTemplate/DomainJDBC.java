package webFrameApp.jdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

public class DomainJDBC {
	/*  
  */private JdbcTemplate jdbcTemplateObject;
	private DataSource dataSource;
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) throws SQLException {
		this.con = dataSource.getConnection();

	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);

	}

}
