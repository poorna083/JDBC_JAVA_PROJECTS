import java.sql.*;
import java.util.*;
public class Demo {
    public static void main(String[] args)throws Exception {
        Demo D = new Demo();
        Scanner sc = new Scanner(System.in);
        D.read();
        System.out.println("for insertion enter details(String name,int Age,int Class,Float Height)");
        D.insert(sc.nextLine(), sc.nextInt(), sc.nextInt(), sc.nextFloat());
    }


    public void read()throws Exception{
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO","root","poorna__07.08");
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery("SELECT * FROM Demo");
        while(r.next()){
        System.out.printf(r.getString(1)+r.getInt(2)+r.getInt(3),r.getFloat(4));
    }
    }

    public void insert(String name,int Age,int Class,Float Height) throws Exception{
        String Query = "Insert INTO Demo1 Values('"+name+"','"+Age+"','"+Class+"','"+Height+"'";
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO","root","poorna__07.08");
        Statement s = c.createStatement();
        int r = s.executeUpdate(Query);
        System.out.println(r+" "+"row inserted");   
    }

    public void Update(String name,float Height) throws Exception{
        String Query = "UPDATE Demo1 set name = '"+name+"' where Height ='"+Height+"'";
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/DEMO","root","poorna__07.08");
        Statement s = c.createStatement();
        int r = s.executeUpdate(Query);
        System.out.println(r+" "+"row Updated");
    }


}
