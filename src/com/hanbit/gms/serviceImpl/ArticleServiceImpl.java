package com.hanbit.gms.serviceImpl;
import java.util.List;
import com.hanbit.gms.daoImpl.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleService;
public class ArticleServiceImpl implements ArticleService{
	private ArticleDAOImpl dao = ArticleDAOImpl.getInstace();
	public static ArticleServiceImpl getInstance() {
		return new ArticleServiceImpl();
	}
	private ArticleServiceImpl() {
	}
	@Override
	public String add(ArticleBean bean) {

		return (ArticleDAOImpl.getInstace().insert(bean).equals("1"))?"등록성공":"등록실패";
	}
	@Override
	public List<ArticleBean> list() {
		return ArticleDAOImpl.getInstace().selectAll();
	}
	@Override
	public List<ArticleBean> findById(String id) {
/*		List<ArticleBean> findList = new ArrayList<>();
		ArticleDAO dao = new ArticleDAOImpl();
		findList=dao.selectById(id);*/
		return ArticleDAOImpl.getInstace().selectById(id);
	}
	@Override
	public ArticleBean findSeq(String seq) {
		return ArticleDAOImpl.getInstace().selectBySeq(seq);
	}
	@Override
	public String count() {
		return String.valueOf(ArticleDAOImpl.getInstace().count());
	}
	@Override
	public String modify(ArticleBean bean) {
		String modify="";
		if(dao.update(bean).equals("1")){
			modify="Success";
		}else{
			modify="Failed";
		}
		return modify;
	}
	@Override
	public String remove(String seq) {
		String remove="";
		if(dao.delete(seq).equals("1")){
			remove="Success";
		}else{
			remove="Failed";
		}
		return remove;
	}
}