import java.sql.*;

public class Main {

//    import package
//    load and register driver
//            Create Connection
//                    Create Statement
//                            execute statement
//                                    Process the result
//    close


    public static void main(String[] args) throws Exception {
        String URL= "jdbc:postgresql://localhost:5432/Students";
        String User="postgres";
        String Pass="123456";

        int sid= 8;
        String sname= "Gaurav";
        int SRollNo= 15;

        Connection con= DriverManager.getConnection(URL,User,Pass);
System.out.println("Connected to database");

PreparedStatement ps= con.prepareStatement("insert into student values(?,?,?)");
ps.setInt(1,sid);
ps.setString(2,sname);
ps.setInt(3,SRollNo);

ps.execute();



//ResultSet rs= s.executeQuery("Select * from student");

//System.out.print("SID "+"Sname "+"S_RollNo ");
//System.out.println();
//while(rs.next()){
//    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+ rs.getString(3));
//}



con.close();

System.out.println("Connection Closed");
    }
}