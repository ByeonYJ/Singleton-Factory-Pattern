package com.hanbit.gms.controller;
import javax.swing.JOptionPane;
import com.hanbit.gms.constants.Butt;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.serviceImpl.MemberServiceImpl;
public class MemberController {
	public static void main(String[] args) {
		MemberBean bean = null;
		Butt[] buttons = {Butt.EXIT,Butt.ADD,Butt.LIST,Butt.FIND_NAME,Butt.FIND_ID,Butt.COUNT,Butt.UPDATE,Butt.DELETE};//버튼 만든 클래스를 불러온다
		while(true){
			switch ((Butt)JOptionPane.showInputDialog(
					null,//frame
					"MEMBER ADMIN",//frame title
					"SELECT MENU",//order
					JOptionPane.QUESTION_MESSAGE,//type
					null,//icon
					buttons,//Array of choices
					buttons[1]//default
					)){
			case EXIT:
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case ADD:
				String[] arr = JOptionPane.showInputDialog("ID/Name/PassWord/SSN").split("/");
				bean = new MemberBean(); 
				bean.setId(arr[0]);
				bean.setName(arr[1]);
				bean.setPassWord(arr[2]);
				bean.setSsn(arr[3]);
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().addMember(bean));
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, "리스트보기"+MemberServiceImpl.getInstance().list());
				break;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findByName(JOptionPane.showInputDialog("Name")));
				break;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, MemberServiceImpl.getInstance().findById(JOptionPane.showInputDialog("ID").toString()));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, "Count값: "+ MemberServiceImpl.getInstance().count());
				break;
			case UPDATE:
				bean = new MemberBean();
				bean.setId(JOptionPane.showInputDialog("Input Login ID"));
				bean.setPassWord(JOptionPane.showInputDialog("Change PW"));
				MemberServiceImpl.getInstance().modify(bean);
				JOptionPane.showMessageDialog(null, "Update Success");
				break;
			case DELETE:
			  /*
				String id = "";
				bean.setId(id);
			  */
				MemberServiceImpl.getInstance().remove(JOptionPane.showInputDialog("ID"));
				JOptionPane.showMessageDialog(null, "Delete Success");
				break;
			}
		}
	}
}
