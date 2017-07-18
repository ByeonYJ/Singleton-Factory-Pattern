package com.hanbit.gms.dao;
import java.util.List;

import com.hanbit.gms.domain.MemberBean;
public interface MemberDAO {
	public String insertMember(MemberBean bean);//나중에 DB에서 insert Query문을 만든다
	public List<MemberBean> selectAll();
	public List<MemberBean> selectName(String name); // DB에서*
	public MemberBean selectById(String id);
	public String count();
	public String update(MemberBean bean);
	public String delete(String id);
}
