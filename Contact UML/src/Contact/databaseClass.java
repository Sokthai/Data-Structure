package Contact;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.ArrayList;








public class databaseClass implements databaseInferface {
	private String host;
	private String username ;
	private String password;
	private Statement stmt;
	private Connection dbCon;
	private ResultSet rs;
	
	
	public databaseClass(String username, String password, String host) { 
		this.host = host;
		this.username = username;
		this.password = password;
	
	 }

	public boolean connect(){//throws  SQLException  { 
		try{
				 dbCon = DriverManager.getConnection(host,username, password);
				 stmt = dbCon.createStatement();		
			
		}catch(SQLException e){
			return false;
		}
		return true;
	 }
	
	public List<Integer> search(String firstname) { 
			List<Integer> idList  = new ArrayList<Integer>();
			try{			
				String sql = "SELECT id FROM CONTACT WHERE FIRSTNAME = '" + firstname + "'";
				 rs = stmt.executeQuery(sql);
	//			 ResultSetMetaData metaData = rs.getMetaData();
				 
				 while (rs.next()){
					 
					 idList.add(rs.getInt("id"));
				 }
			}catch(SQLException e){
				return null;
			}
	 
			 return idList;			
	 }
	
	public boolean remove() { 
		
		String sql = "DELETE FROM CONTACT WHERE id = " + 1;
		try{
			stmt.executeQuery(sql);
			
		}catch(SQLException e){
			return false;
		}
		
		return true;
	 }

	public List<Integer> search(String firstname, String lastname){ 
		
		List<Integer> idList  = new ArrayList<Integer>();
		try{
			String sql = "SELECT id FROM CONTACT WHERE FIRSTNAME = '" + firstname + "' AND + LASTNAME = '" + lastname + "'";
			 rs = stmt.executeQuery(sql);
	//		 ResultSetMetaData metaData = rs.getMetaData();		 
			 while (rs.next()){				 
				 idList.add(rs.getInt("id"));
			 }
		}catch(SQLException e){
			return null;
		}
 
		 return idList;	
	 }
	
	public int count() { 
		int id = 0;
		try{
			String sql = "SELECT COUNT(id) from CONTACT";
			rs = stmt.executeQuery(sql);
			id = rs.getInt(0);
		}catch(SQLException e){
			return id;
		}
		
		
		return id;
		
	 }

	public boolean update(List<String> values) { 
		
		String sql = "UPDATE CONTACT SET firstname = " + values.get(0)
										+ ",lastname = " + values.get(1)
										+ ",phone = " + values.get(2)
										+ ",sex = " + values.get(3)
										+ ",birthday = " + values.get(4)
										+ ",email = " + values.get(5)
										+ ",address = " + values.get(6)
										+ ",icon = " + values.get(7)
										+ ",note = " + values.get(8)										
										+ " WHERE id = " + values.get(9);
		try{
			stmt.executeUpdate(sql);
		}catch(SQLException e){
			return false;
		}
		
		
		return true;
	 }
	
	public boolean add(List<String> values) { 
		String sql = "INSERT INTO CONTACT (firstname, lastname, phone, sex, birthday, email, address, icon, note) VALUES ('";
		for (String value : values){
			sql += value + "', ";
		}
		sql = sql.substring(0, sql.length() -1) + "')";
		
		
		try{
			stmt.executeLargeUpdate(sql);
		}catch(SQLException e){
			return false;
		}
		
		return true;
	 } 

}
