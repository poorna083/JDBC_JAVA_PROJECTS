import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Jdbcconnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "poorna__07.08");
       if (con != null) {
            System.out.println("Connection Established");
        } else {
            System.out.println("Connection not Established");
            return;
        }
            Scanner sc = new Scanner(System.in);
            PreparedStatement ps;
            ResultSet rs;
            int choice;
            while (true) {
                System.out.println("\n-----MENU-----");
                System.out.println("1.Insert A user");
                System.out.println("2.View All user");
                System.out.println("3.Update");
                System.out.println("4.Delete User");
                System.out.println("5.View Single User");
                System.out.println("6.Exit");
                System.out.println("Enter Your Choice");
                choice = sc.nextInt();
                sc.nextLine();

                if(choice ==1){
                    System.out.println("Enter UserName");
                    String username = sc.nextLine();
                    System.out.println("Enter The Password");
                    String password = sc.nextLine();
                    System.out.println("Enter Name:");
                    String name = sc.nextLine();
                    System.out.println("Enter Your Email");
                    String email = sc.nextLine();

                    String insert = "INSERT INTO details(username,password,name,email) VALUES(?,?,?,?)";
                    ps = con.prepareStatement(insert);
                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, name);
                    ps.setString(4, email);
                    int res = ps.executeUpdate();
                    if (res>0) System.out.println("User Inserted Successfully");
                }
                else if(choice ==2){
                    System.out.println("All users");
                    Statement st = con.createStatement();
                    rs=st.executeQuery("SELECT * FROM details");
                    while (rs.next()) {
                        System.out.println(rs.getString("username")+" "+rs.getString("password")+" "+rs.getString("name")+" "+rs.getString("email"));
                    }
                }
                else if(choice ==3){
                    System.out.println("Update the Details");
                    System.out.println("Enter The update_column name");
                    String column1 = sc.nextLine();
                    System.out.println("Enter The update_value");
                    String value1 = sc.nextLine();
                    System.out.println("Enter The Column name");
                    String column = sc.nextLine();
                    System.out.println("Enter The value");
                    String value = sc.nextLine();
                    String update = "update details set "+column1+" = ? where "+column+" = ?";
                    ps = con.prepareStatement(update);
                    ps.setString(1, value1);
                    ps.setString(2, value);
                    int res = ps.executeUpdate();
                    if (res>0) System.out.println("User Inserted Successfully");
                }
                else if(choice==4){
                    System.out.println("Delete The User");
                    System.out.println("Enter the column_to_drop");
                    String column = sc.nextLine();
                    System.out.println("Enter The Value");
                    String value = sc.nextLine();
                    String delete = "delete from details where "+column+" = ? ";
                    ps = con.prepareStatement(delete);
                    ps.setString(1, value);
                    int res =ps.executeUpdate();
                    if(res>0)System.out.println("Deleted Successfullyy");    
                }
                else if(choice == 5){
                    System.out.println("Enter The Column");
                    String column = sc.nextLine();
                    System.out.println("Enter The value");
                    String value = sc.nextLine();
                    String viewone = "SELECT * FROM details where "+column+" = ? ";
                    ps = con.prepareStatement(viewone);
                    ps.setString(1, value);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        System.out.println(rs.getString("username")+" "+rs.getString("password")+" "+rs.getString("name")+" "+rs.getString("email"));
                    }  
                }
                else if(choice == 6){
                    System.out.println("Exited Successfully");
                    break;
                }

            }
        }
    }