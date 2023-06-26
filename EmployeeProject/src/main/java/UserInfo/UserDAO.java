package UserInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

	public static Connection conn;
	public PreparedStatement ps;
	public  ResultSet rs;
	
	public UserDAO() throws Exception {
		com.mysql.cj.jdbc.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "root");
				}
	
	public static int save(UserData u) {
	//	int status=0;
		try {
		//	Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement("insert into userdata(id,name,password,email,sex,country)values('0',?,?,?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getSex());
			ps.setString(5,u.getCountry());
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return 0;
	}
	
	public static int update(UserData u) {
		int status=0;
		try {
		//	Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement("update userdata set name=?,password=?,email=?,sex=?,country=? where id=?"); 
			 ps.setString(1,u.getName());  
			 ps.setString(2,u.getPassword());  
		     ps.setString(3,u.getEmail());  
		     ps.setString(4,u.getSex());  
		     ps.setString(5,u.getCountry());  
		     ps.setInt(6,u.getId());  
		     status=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return status;
	}
	
	public static int delete(UserData u) {
		int status=0;
		try {
		//	Connection conn=getConnection();
			PreparedStatement ps=conn.prepareStatement("delete from userdata where id=?");
			ps.setInt(1,u.getId());
			status=ps.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return status;
	}
	
	
	public static List<UserData> getAllRecords(){
		List<UserData>list=new ArrayList<UserData>();
		
		try {
			
	//		Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("select *from userdata");
	        ResultSet rs=ps.executeQuery();
	        
	        while(rs.next()) {
	        	UserData u=new UserData();
	        	u.setId(rs.getInt("id"));
	        	u.setName(rs.getString("name"));
	        	u.setPassword(rs.getString("password"));
	        	u.setEmail(rs.getString("email"));  
	            u.setSex(rs.getString("sex"));  
	            u.setCountry(rs.getString("country"));  
	            list.add(u);  
	        }
		 }
	        catch(Exception ex) {
	        	System.out.println(ex);
	        }
		return list;
}	
		 public static UserData getRecordById(int id) {
			 UserData u = null;
		        try {
	//	            Connection conn= getConnection();
		            PreparedStatement ps = conn.prepareStatement("select *from userdata where id=?");
		            ps.setInt(1, id);
		            ResultSet rs = ps.executeQuery();
		            while (rs.next()) {
		                u=new UserData();
		                u.setId(rs.getInt("id"));
		                u.setName(rs.getString("name"));
		                u.setPassword(rs.getString("password"));
		                u.setEmail(rs.getString("email"));
		                u.setSex(rs.getString("gender"));
		                u.setCountry(rs.getString("country"));
		                
		            }
		        } catch (Exception e) {
		            System.out.println(e);
		        }
				return u;
		}
		 
		 public static List<UserData> getRecords(int start, int total) {
		        List<UserData> list = new ArrayList<UserData>();
		        try {
		        	PreparedStatement ps = conn.prepareStatement(
		                    "select * from userdata limit " + (start - 1) + "," + total);
		            ResultSet rs = ps.executeQuery();
		            while (rs.next()) {
		                UserData u = new UserData();
		                u.setId(rs.getInt(1));
		                u.setName(rs.getString(2));
		               
		                list.add(u);
		            }
		            conn.close();
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		        
				return list; 
		        
		 }
}
