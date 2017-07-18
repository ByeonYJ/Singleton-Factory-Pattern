package com.hanbit.gms.util;
import java.sql.*;

import com.hanbit.gms.constants.DB;
public class JDBCTest {
	public static void main(String[] args) {
		String findName="";
		Connection conn=null;
		try {
			//Class.forName(DB.DRIVER);//직렬화는 DB에 연결시키는 방법 Class는 IO에 있기 때문에 불러서 쓸 수 있다 for name을 호출한다
			                               //객체가 자바에서 나와서 DB로 가서 데이터를 이동해야 하는데 다른 시공간 다른 공간으로 가게 load시켰다
			                               //즉 DRIVER에 연결 (동적으로 로딩)
			//conn = DriverManager.getConnection(DB.URL,DB.USER,DB.PASSWORD);
			Statement stmt = conn.createStatement();//create는 없던것을 만드는 팩토리 패턴
			String sql="SELECT * FROM Member WHERE id='hong'";//sql문이기때문에 자바안의 sql문을 ''로 감싸준다
			ResultSet rs = stmt.executeQuery(sql);//execute는 실행해라 sql문을
			if(rs.next()){//가지고 있는 값을 보여주는것이 next, boolean형이다(rs에 이름이 있으면 rs에 가져온다)
				findName=rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("### 결과"+findName);
	}
}
