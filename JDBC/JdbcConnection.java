import java.sql.*;

public class JdbcConnection{

    public static void main(String[] args){
        String url = "jdbc:sqlserver://Abhinay\\SQLEXPRESS;databaseName=BikeStores;user=sa;password=abcd;encrypt=true;trustServerCertificate=true";
        //String url = "jdbc:sqlserver://Abhinay:1433;databaseName=BikeStores;user=sa;password=abcd;encrypt=true;trustServerCertificate=true";
        String sql = "Select * from Sales.customers where customer_id=1";

        try(
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)
            ){
                while(rs.next()){
                    System.out.print("Bro You are connected ");
                }
            }
            catch(Exception e){
                System.out.println("Bro, Not connected");
                e.printStackTrace();
            }
    }
}