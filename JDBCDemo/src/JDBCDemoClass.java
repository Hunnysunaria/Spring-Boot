import java.sql.*;

public class JDBCDemoClass {

    public static void main(String[] args)throws Exception{

        String user="postgres";
        String password="123456";
        String URL="jdbc:postgresql://localhost:5432/Students";
int sid= 12;
String Sname= "Rakesh";
int SRollNo= 34;
        Connection con = DriverManager.getConnection(URL,user,password);
        Statement smt= con.createStatement();
//        PreparedStatement smt= con.prepareStatement("Insert into student Values(?,?,?)");
//smt.setInt(1,sid);
//smt.setString(2,Sname);
//smt.setInt(3,SRollNo);
//smt.execute();
        ResultSet rs= smt.executeQuery("Select * from student");

        while(rs.next()){
            System.out.println(rs.getString(2));
        }


    }

}
