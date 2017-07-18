package com.hanbit.gms.daoImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.hanbit.gms.constants.DB;
import com.hanbit.gms.constants.SQL;
import com.hanbit.gms.constants.Vendor;
import com.hanbit.gms.dao.ArticleDAO;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.factory.DatabaseFactory;
public class ArticleDAOImpl implements ArticleDAO{
	public static ArticleDAOImpl instace = new ArticleDAOImpl();
	public static ArticleDAOImpl getInstace() {
		return instace;
	}
	public ArticleDAOImpl() {
	}
	@Override
	public String insert(ArticleBean bean) {
		String insert = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_INSERT);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getContent());
			insert = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return insert;
	}
	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> all = new ArrayList<>();
		ArticleBean member = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_LIST).executeQuery();
			while(rs.next()){
				member = new ArticleBean();
				member.setArticleSeq(rs.getInt(DB.ARTICLE_SEQ));
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setTitle(rs.getString(DB.ARTICLE_TITLE));
				member.setContent(rs.getString(DB.ARTICLE_CONTENT));
				member.setHitcount(rs.getInt(DB.ARTICLE_HITCOUNT));
				member.setRegdate(rs.getString(DB.ARTICLE_REGDATE));
				all.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean>list = new ArrayList<>();
		ArticleBean member = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_FINDBYID);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				member = new ArticleBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setArticleSeq(rs.getInt(DB.ARTICLE_SEQ));
				member.setContent(rs.getString(DB.ARTICLE_CONTENT));
				member.setHitcount(rs.getInt(DB.ARTICLE_HITCOUNT));
				member.setRegdate(rs.getString(DB.ARTICLE_REGDATE));
				member.setTitle(rs.getString(DB.ARTICLE_TITLE));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean=new ArticleBean();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_SEQ);
			pstmt.setString(1, seq);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				bean.setArticleSeq(rs.getInt(DB.ARTICLE_SEQ));
				bean.setContent(rs.getString(DB.ARTICLE_CONTENT));
				bean.setHitcount(rs.getInt(DB.ARTICLE_HITCOUNT));
				bean.setId(rs.getString(DB.MEMBER_ID));
				bean.setRegdate(rs.getString(DB.ARTICLE_REGDATE));
				bean.setTitle(rs.getString(DB.ARTICLE_TITLE));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public String count() {
		String count = "";
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_COUNT).executeQuery();
			if(rs.next()){
				count = rs.getString("article_seq");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String update(ArticleBean bean) {
		ArticleBean temp = selectBySeq(String.valueOf(bean.getArticleSeq()));
		String title = (bean.getTitle().equals(""))?temp.getTitle():bean.getTitle();
		String content = (bean.getTitle().equals(""))?temp.getContent():bean.getContent();
		String result = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.MEMBER_USER, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_UPDATE);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, bean.getArticleSeq());
			result = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String delete(String seq) {
		String result = "";
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERNAME, DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_DELETE);
			pstmt.setString(1, seq);
			result = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}		
}
