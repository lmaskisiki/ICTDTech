package webFrameApp.sqlstatements;

public class DBCreateStatement {
	String dbname = null;
	String statement = null;

	public DBCreateStatement(String dbnameInput) {
		if (dbnameInput == null) {
			throw new NullPointerException(dbname);
		}
		this.dbname = dbnameInput;
		statement = String.format("CREATE DATABASE IF NOT EXISTS %s ", dbname);
	}

	public String Get() {
		return statement;
	}
}
