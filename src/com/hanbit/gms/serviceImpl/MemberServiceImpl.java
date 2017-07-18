package com.hanbit.gms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.daoImpl.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberDAOImpl dao = MemberDAOImpl.getInstance();//shallow copy
	public static MemberServiceImpl getInstance(){
		return new MemberServiceImpl();
	}
	private MemberServiceImpl() {
	}
	List<MemberBean> list;
	Map<String,MemberBean> map;
	MemberBean member;
	int count;//count를 instance variable로 만드는 곳
	@Override
	public String addMember(MemberBean bean) {
		String addMember="";
	  /*String msg = "";
		MemberDAO dao = new MemberDAOImpl();
        int rs =dao.insertMember(bean);
		if(rs==1){//return이 1이면 성공,0이면 실패
			msg = "등록성공";
		}else{
			msg = "등록실패";
		}*/
		addMember=(dao.insertMember(bean).equals("1"))?"등록성공":"등록실패";
		return addMember;
	}
	@Override
	public List<MemberBean> list() {
/*		List<MemberBean>list = new ArrayList<>();
		Set<String>keys=map.keySet();
		for(String s:keys){
			list.add(map.get(s));
		}*/
		return MemberDAOImpl.getInstance().selectAll();
	}

	@Override//수정중
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp=new ArrayList<MemberBean>();
/*		for(MemberBean mem:list){
			if(name.equals(mem.getName())){
				temp.add(map.get(mem));
			}
		}*/
		return MemberDAOImpl.getInstance().selectName(name);
	}

	@Override
	public MemberBean findById(String id) {
/*		MemberBean member = new MemberBean();
		MemberDAO dao = new MemberDAOImpl();//select 객체를 가져오는 것
		member=dao.selectById(id);*/
		return MemberDAOImpl.getInstance().selectById(id);
	}

	@Override
	public String count() {
		return String.valueOf(MemberDAOImpl.getInstance().count());//회원수를 한번에 count 해주는것
	}

	@Override
	public String modify(MemberBean bean) {
		String update="";
		if(dao.update(bean).equals("1")){
			update="Success";
		}else{
			update="Failed";
		}
		return update;
	}

	@Override
	public String remove(String id) {
		String msg = "";
		for(MemberBean mem:list){
			if(id.equals(mem.getId())){
				list.remove(mem);
			}
		}
		return msg;
	}
}
