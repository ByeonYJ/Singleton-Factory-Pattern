package com.hanbit.gms.factory;
import com.hanbit.gms.constants.DB;
import com.hanbit.gms.constants.Vendor;
import com.hanbit.gms.domain.DatabaseBean;
public class DatabaseFactory {
	public static DatabaseBean createDatabase(//factory 패턴은 getter가 아닌 create를 사용한다
		//DatabaseBean bean = new DatabaseBean(driver, url, username, password);
		Vendor vendor,String username, String password//hanbit/hanbit
		){
		String driver="",url="";
		switch(vendor){
		case ORACLE:
			driver=DB.ORACLE_DRIVER;
			url=DB.ORACLE_URL;
			break;
		case DB2:
			driver=DB.DB2_Driver;
			url=DB.DB2_URL;
			break;
		case MSSQL:
			driver=DB.MSSQL_DRIVER;
			url=DB.MSSQL_URL;
			break;
		case MYSQL:
			driver=DB.MYSQL_DRIVER;
			url=DB.MYSQL_URL;
			break;
		case MARIADB:
			driver=DB.MARIADB_DRIVER;
			url=DB.MARIADB_URL;
			break;
			default:
				break;
		}
		return new DatabaseBean(DB.ORACLE_DRIVER, DB.ORACLE_URL, DB.USERNAME, DB.PASSWORD);
	}
}
