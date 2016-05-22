package webFrameApp.serviceLgoic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import webFrameApp.entites.Domain;
import webFrameApp.entites.OrgEntity;
import webFrameApp.entites.SqldataTypes;
import webFrameApp.enumerations.EntityAccessType;
import webFrameApp.interfaces.EntityDAO;
import webFrameApp.jdbcTemplate.DomainJDBC;
import webFrameApp.repositories.EntityRepo;

@Service
@WebService( serviceName="EntityService",endpointInterface="webFrameApp.interfaces.EntityDAO",portName="SOAPOverHTTP")
public class EntityDAOImpl implements EntityDAO {
	@Autowired
	private EntityRepo repository;

	@Override
	public void CreateEntity(Domain Domain, String entityName,String accessType,
			String[] attributes, String[] types,
			List<SqldataTypes> sqlDataTypes, int[] att_value_length,
			String[] other,String [] optionValues, int att_number) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
		JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());

		OrgEntity ent = new OrgEntity();
		ent.setName(entityName);
		ent.setDomain(Domain.getDomainName());
		ent.setAttributes(attributes);
		ent.setTypes(types);
		ent.setOther(other);
		ent.setAtt_number(att_number);
		ent.setOptionValues(optionValues);
		ent.setAccessType(EntityAccessType.valueOf(accessType));

		OrgEntity entity = repository.save(ent);
		LooseEntity dob = new LooseEntity();
		dob.createLooseObjects(Domain, entity.getName(),
				entity.getAttributes(), entity.getTypes(), sqlDataTypes,
				att_value_length, entity.getOther());

		System.out
				.println("this is reached without any problem... walllaaa!!!!!");
	}

	@Override
	public List<OrgEntity> findByName(String name) {
		List<OrgEntity> found = new ArrayList<OrgEntity>();
		List<OrgEntity> list = repository.findAll();
		for (OrgEntity items : list) {
			if (items.getName().equals(name)) {

				found.add(items);
			}

		}

		return found;
	}

	@Override
	public List<OrgEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public void relateEntities(OrgEntity addTo, OrgEntity addFrom,
			String ToColumn, String FromColumn, boolean existingField) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
		JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());
		String domain1 = addTo.getDomain();
		String domain2 = addFrom.getDomain();
		String table_prefix = "tbl_";
		String db_suffix = "_db";
		String Catalog = domain1 + db_suffix;
		String db = domain1 + db_suffix;
		String table1 = table_prefix + addTo.getName();
		String table2 = table_prefix + addFrom.getName();
		// related tables must be from the same database *Domain
		if (domain1.endsWith(domain2)) {
			String sqlUpdate = "";
			Connection connect = null;
			if (existingField == true) {
				sqlUpdate = " ALTER TABLE " + table1 + " ADD CONSTRAINT  fk_"
						+ ToColumn + " FOREIGN KEY (" + ToColumn
						+ ") REFERENCES " + table2 + " ( " + FromColumn
						+ ") ON DELETE CASCADE ON UPDATE CASCADE";
				System.out.println(sqlUpdate);

			} else if (!existingField) {
				sqlUpdate = "ALTER TABLE " + table1 + " ADD COLUMN fk_"
						+ FromColumn + " INT  FOREIGN KEY ( " + FromColumn
						+ " )" + " REFERENCES " + table2 + "(" + FromColumn
						+ ")" + " ON DELETE CASCADE ON UPDATE CASCADE";

				System.out.println(sqlUpdate);
			}
			try {
				connect = jdbc.getDataSource().getConnection();
				connect.setCatalog(Catalog);
				PreparedStatement statement = connect
						.prepareStatement(sqlUpdate);
				statement.executeUpdate();

				connect.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<OrgEntity> findByDomain(String Domain) {
		List<OrgEntity> allents = repository.findAll();
		List<OrgEntity> found = new ArrayList<OrgEntity>();
		int x = 0;
		for (OrgEntity ent : allents) {
			if (ent.getDomain().equals(Domain.trim())) {
				found.add(ent);
				x += 1;
			}
		}

		System.out.println(x + " OrgEntity found on " + Domain);
		return found;
	}

	@Override
	public boolean delete(OrgEntity ent) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
		JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());
		String name = ent.getName();
		String domain = ent.getDomain();
		repository.delete(ent);
		OrgEntity entity = repository.findOne(ent.getEid());

		if (entity == null) {
			String sqlDelete = "DROP TABLE IF EXISTS tbl_" + name;
			try {
				Connection con = jdbc.getDataSource().getConnection();
				con.setCatalog(domain + "_db");
				Statement st = con.createStatement();
				st.executeUpdate(sqlDelete);

				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean newRelationship(String domain,String entity,String attribute,String refEntity, String refAttribute) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:META-INF/applicationContext.xml");
		DomainJDBC jdbcTemplate = (DomainJDBC) context.getBean("DomainJDBC");
		JdbcTemplate jdbc = new JdbcTemplate(jdbcTemplate.getDataSource());

		String dbSuffix = "_db";
		String tablePreffix = "tbl_";
		domain= domain + dbSuffix;
			entity = tablePreffix + entity;
		refEntity= tablePreffix + refEntity;

		String Catalog = domain;
		String sqlAlter = "ALTER TABLE " + entity
				+ " ADD FOREIGN KEY (" + attribute +") REFERENCES " + refEntity+" ("+refAttribute+")";

		Connection connect = null;
		try {
			connect = jdbc.getDataSource().getConnection();
			connect.setCatalog(Catalog);
			PreparedStatement statement = connect.prepareStatement(sqlAlter);
			statement.executeUpdate();
			connect.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(sqlAlter);
		return false;
	}

}
