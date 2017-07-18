package com.hanbit.gms.constants;

public class SQL {
	public static final String MEMBER_INSERT = String.format("INSERT INTO %s(%s,%s,%s,%s,%s) VALUES (?,?,?,?,SYSDATE)",DB.TABLE_MEMBER,DB.MEMBER_ID,DB.MEMBER_USER,DB.MEMBER_PASS,DB.MEMBER_SSN,DB.MEMBER_REGDATE);
	public static final String MEMBER_LIST = String.format("SELECT * FROM %s",DB.TABLE_MEMBER);
	public static final String MEMBER_FINDBYNAME = String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_MEMBER,DB.MEMBER_USER);
	public static final String MEMBER_FINDBYID = String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_ID);
	public static final String MEMBER_COUNT = String.format("SELECT COUNT(*) AS %s FROM %s","count",DB.TABLE_MEMBER);
	public static final String MEMBER_UPDATE = String.format("UPDATE %s SET %s=? WHERE %s=?",DB.TABLE_MEMBER,DB.MEMBER_PASS,DB.MEMBER_ID);
	public static final String MEMBER_DELETE = String.format("DELETE FROM %s WHERE %s=?",DB.TABLE_MEMBER,DB.MEMBER_ID);
	public static final String ARTICLE_INSERT = String.format("INSERT INTO %s(%s,%s,%s,%s,%s,%s) VALUES(article_seq.nextval,?,?,?,0,SYSDATE)",
			DB.TABLE_BOARD,DB.ARTICLE_SEQ,DB.MEMBER_ID,DB.ARTICLE_TITLE,DB.ARTICLE_CONTENT,DB.ARTICLE_HITCOUNT,DB.ARTICLE_REGDATE);
	public static final String ARTICLE_LIST = String.format("SELECT * FROM %s",DB.TABLE_BOARD);
	public static final String ARTICLE_FINDBYID = String.format("SELECT * FROM %s WHERE %s=?",DB.TABLE_BOARD,DB.MEMBER_ID);
	public static final String ARTICLE_SEQ = String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.ARTICLE_SEQ);
	public static final String ARTICLE_COUNT = String.format("SELECT COUNT(*) AS %s FROM %s","article_seq",DB.TABLE_BOARD);
	public static final String ARTICLE_UPDATE = String.format("UPDATE %s SET %s=?,%s=? WHERE %s=?",DB.TABLE_BOARD,DB.ARTICLE_TITLE,DB.ARTICLE_CONTENT,DB.ARTICLE_SEQ);
	public static final String ARTICLE_DELETE = String.format("DELETE FROM %s WHERE %s=?",DB.TABLE_BOARD,DB.MEMBER_ID);
}
