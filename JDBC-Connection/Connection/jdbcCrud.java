import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcCrud {
     public static void main(String[] args) throws Exception {
        jdbcCrud c=new jdbcCrud();
        Scanner sc= new Scanner(System.in);
        System.out.println("for insertion enter details(username,password,name,email)");
        c.add(sc.next(),sc.next(),sc.next(),sc.next());
        c.read();
        System.out.println("for deletion enter username");
        c.delete(sc.next());
        c.read();
        System.out.println("for Upsation enter password ,email");
        c.update(sc.next(),sc.next());
        c.read();
        c.truncate();
        c.read();
        c.delete();
        c.read();
  }

  public void read() throws Exception{
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "poorna__07.08");
    Statement s =con.createStatement();
    ResultSet rs=s.executeQuery("SELECT * FROM details");
    while(rs.next()){
        System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
    }
  }

  public void add(String username,String password,String name,String email)throws Exception{
    String Query="INSERT INTO details VALUES('"+username+"','"+password+"','"+name+"','"+email+"')";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "poorna__07.08");
    Statement s =con.createStatement();
    int r=s.executeUpdate(Query);
    System.out.println(r+" row inserted");
  }

  public void delete(String username) throws Exception {
    String Query="DELETE FROM details WHERE username = '"+username+"'";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "poorna__07.08");
    Statement s =con.createStatement();
    int r=s.executeUpdate(Query);
    System.out.println(r+" row deleted");
  }

  public void update(String password,String email) throws Exception {
    String Query = "Update details set password = '"+password+"' where email ='"+email+"'";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "poorna__07.08");
    Statement s =con.createStatement();
    int r=s.executeUpdate(Query);
    System.out.println(r+" row Updated");
  }
  public void truncate()throws Exception{
    String Query = "truncate details";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "poorna__07.08");
    Statement s = con.createStatement();
    int r=s.executeUpdate(Query);
    System.out.println(r+" truncate Done");
  }
  public void delete()throws Exception{
    String Query = "drop table details";
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "poorna__07.08");
    Statement s = con.createStatement();
    int r = s.executeUpdate(Query);
    System.out.println(r+"Table Drop Done");
  }
}
