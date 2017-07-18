package com.hanbit.gms.service;
import java.util.List;
import com.hanbit.gms.domain.ArticleBean;
public interface ArticleService {
	public String add (ArticleBean bean);
	public List<ArticleBean> list ();
	public List<ArticleBean> findById(String id);
	public ArticleBean findSeq(String seq);
	public String count();
	public String modify(ArticleBean bean);
	public String remove(String seq);
}
