package week05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LogonDBBean {
	private static LogonDBBean instance = new LogonDBBean();
	
	public static LogonDBBean getInstance() {
		return instance;
	}
	
	//connection 객체
	private Connection getConnection() throws Exception{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/jspdb");
		return ds.getConnection();
		
	}
	//회원가입하는 메소드
	
	//사용자 체크하는 메소드
	public int userCheck(String id, String passwd) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null; 
		String dbpasswd="";
		int x=-1;
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement("select passwd from newMember where id=? ");
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
		
			if(rs.next()) {
				dbpasswd=rs.getString("passwd");
					if(dbpasswd.equals(passwd))
						x=1;
					else
						x=0;
						}else
			x=-1; //아이디 없음
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
}
