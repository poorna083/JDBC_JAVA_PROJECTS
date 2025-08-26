package JdbcCrud;
import java.sql.*;
public class Jdbccrud {
    public static void main(String[] args)throws Exception{
        Jdbccrud c = new Jdbccrud();
        c.add("poorrr","0123 ","poorna","poorna123@.com");
        c.read();

    }
    public void read() throws Exception{
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "poorna__07.08");
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM detail");
        while(rs.next()){
            System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
        }
    }
    public void add(String username,String password,String name,String email)throws Exception{
        String Query="INSERT INTO detail VALUES('"+username+"','"+password+"','"+name+"','"+email+"')";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "poorna__07.08");
    Statement s =con.createStatement();
    int r=s.executeUpdate(Query);
    System.out.println(r+" row affected");
    }
}
