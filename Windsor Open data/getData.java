import java.sql.*;
public class getdata{
public static final String DRIVER = "com.mysql.jdbc.Driver"; 
public static final String URL = "jdbc:mysql://127.0.0.1:3306/lianxi";   
public static final String USERNAME = "";  
public static final String PASSWORD = "";
public static void main(String[] args) throws SQLException, ClassNotFoundException {
Connection conn = null; 
Statement stat = null;
Class.forName(DRIVER);
conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
stat = conn.createStatement();
String sql = "select*from hehe";
ResultSet rs=stat.executeQuery(sql);
while (rs.next()) {
String deptno=rs.getString("deptno");
String dname=rs.getString("dname");
String loc=rs.getString("loc");
String deptno=rs.getString(1);
String dname=rs.getString(2);
String loc=rs.getString(3);
System.out.println("deptno:"+deptno+",dname:"+dname+",loc:"+loc);
}
rs.close();
stat.close();
conn.close();
}
}