package keepthinker;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;


/**
 * there is only one connection pool,that is ,only one dataSource inside<br/>
 * singleton pattern
 * @author keepthinker
 *
 */
public class DatabaseConnectionPool{
	private final String protocol = "jdbc:mysql:";
	private final String accountDB = "root";
	private final String passwordDB = "ksk97420";
	private final String dbName = "shiro";
	private final String dbUrl = protocol + "//127.0.0.1:3306/"+dbName;
	private final String driverName="com.mysql.jdbc.Driver";
	private static DataSource dataSource;//application scope sharing
	static{
		new DatabaseConnectionPool();
	}
	/**从数据库连接池中获取一个connection
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	private DatabaseConnectionPool(){
		dataSource = setupDataSource(dbUrl);
	}
	public static void main(String[] args){
	}
	public DataSource setupDataSource(String connectURI) {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverName);
		ds.setUsername(accountDB);
		ds.setPassword(passwordDB);
		ds.setUrl(connectURI);
		return ds;
	}
	public static void printDataSourceStats() {
		BasicDataSource bds = (BasicDataSource) dataSource;
		System.out.println("NumActive: " + bds.getNumActive());
		System.out.println("NumIdle: " + bds.getNumIdle());
	}

	public static void shutdownDataSource() throws SQLException {
		BasicDataSource bds = (BasicDataSource) dataSource;
		bds.close();
	}
}
