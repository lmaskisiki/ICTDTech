package webFrameApp.contentManagers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class contentMapper implements ResultSetExtractor {
 

	@Override
	public List<List<Object>> extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		
		 List<List<Object>> allData=new ArrayList<List<Object>>();
		System.out.println("Now inside the mapper");
				int columns = resultSet.getMetaData().getColumnCount();
		ArrayList<Object> list = new ArrayList<Object>(columns);
		for (int x = 1; x <= columns; x++) {
					list.add(resultSet.getArray(x));
		 
		}

		 return allData;
	}

}
