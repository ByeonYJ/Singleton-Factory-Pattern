package com.hanbit.gms.daoImpl;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constants.DB;
import com.hanbit.gms.constants.SQL;
import com.hanbit.gms.constants.Vendor;
import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;

import java.sql.*;//sql문 전체를 나타내는것 * all의 의미
public class MemberDAOImpl implements MemberDAO{
	public static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	private MemberDAOImpl(){
	}
	@Override
	public String insertMember(MemberBean bean) {
		String rs="";;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);//sql문을 저장해놨다가 한번에 송출 PreparedStatement
			pstmt.setString(1,bean.getId());
			pstmt.setString(2,bean.getName());
			pstmt.setString(3,bean.getPassWord());
			pstmt.setString(4,bean.getSsn());
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean>list=new ArrayList<>();
		MemberBean member = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){//값이 여러개라서 if 아닌 while 을 사용한다
				member= new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_USER));
				member.setPassWord(rs.getString(DB.MEMBER_PASS));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegDate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<MemberBean> selectName(String name) {
		List<MemberBean>list=new ArrayList<>();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYNAME);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while(rs.next()){
				member=new MemberBean();
				member.setName(rs.getString(DB.MEMBER_USER));
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setPassWord(rs.getString(DB.MEMBER_PASS));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegDate(rs.getString(DB.MEMBER_REGDATE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_FINDBYID);//Driver에 연결(connection)
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_USER));
				member.setPassWord(rs.getString(DB.MEMBER_PASS));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				member.setRegDate(rs.getString(DB.MEMBER_REGDATE));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	@Override
	public String count() {
		String count = "";
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT).executeQuery();//count는 getter라서 ResultSet
			if(rs.next()){
				count = String.valueOf(rs.getString("count"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	@Override
	public String update(MemberBean bean) {
		String rs= "";
		try {
			//String.format("UPDATE %s SET %s=? WHERE %s=?",DB.TABLE_MEMBER,DB.PASSWORD,DB.MEMBER_ID);
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
			pstmt.setString(1, bean.getPassWord());
			pstmt.setString(2, bean.getId());
			System.out.println("UPDATE SQL:::"+SQL.MEMBER_UPDATE);
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			System.out.println("MEMBERDAO UPDATE");
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public String delete(String id) {
		String rs="";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}