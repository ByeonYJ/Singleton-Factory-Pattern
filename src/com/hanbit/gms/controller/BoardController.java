package com.hanbit.gms.controller;
import javax.swing.JOptionPane;
import com.hanbit.gms.constants.Button;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.serviceImpl.ArticleServiceImpl;
public class BoardController {
	public static void main(String[] args) {
		ArticleBean bean = null;
		Button[] buttons = {Button.ADD,Button.LIST,Button.FIND_BYID,Button.FIND_SEQ,Button.COUNT,Button.UPDATE,Button.DELETE,Button.EXIT};
		while(true){
		switch ((Button)JOptionPane.showInputDialog(
				null,
				"Board ADMIN",
				"SELECT MENU",
				JOptionPane.QUESTION_MESSAGE,
				null,
				buttons,
				buttons[1]
				)){
		    case EXIT:
		    	JOptionPane.showMessageDialog(null, "종료");
		    	return;
			case ADD:
				String arr[] = JOptionPane.showInputDialog("ID/title/content").split("/");
				bean=new ArticleBean();
				bean.setId(arr[0]);
				bean.setTitle(arr[1]);
				bean.setContent(arr[2]);
				System.out.println("controller ADD::"+bean.toString());
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().add(bean));
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().list());
				break;
			case FIND_BYID:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().findById(JOptionPane.showInputDialog("Search ID")));
				break;
			case FIND_SEQ:
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().findSeq(JOptionPane.showInputDialog("input Seq")));
				break;
			case COUNT:
				JOptionPane.showMessageDialog(null, "Count: "+ArticleServiceImpl.getInstance().count());
				break;
			case UPDATE:
				bean = new ArticleBean();
				bean.setArticleSeq(Integer.parseInt(JOptionPane.showInputDialog("Input your Seq")));
				bean.setTitle(JOptionPane.showInputDialog("Input Title"));
				bean.setContent(JOptionPane.showInputDialog("Input Content"));
				JOptionPane.showMessageDialog(null,ArticleServiceImpl.getInstance().modify(bean));
				break;
			case DELETE:
				ArticleServiceImpl.getInstance().remove(JOptionPane.showInputDialog("Input Seq"));
				JOptionPane.showMessageDialog(null, "Delete Success");
				break;
			}
		}
	}
}
