package es.tierno.parcticajavabbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/midatabase?allowPublicKeyRetrieval=true&useSSL=false";
            Connection con = DriverManager.getConnection(url, "root", "rootpass");

            // onnection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/midatabase?useSSL=false&serverTimezone=UTC","root","rootpass");
            java.sql.Statement stmt=con.createStatement();

            ResultSet rs=((java.sql.Statement) stmt).executeQuery("select * from productos");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}