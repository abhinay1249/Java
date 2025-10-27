import java.sql.*;

public class ConnectionOperations {
    public static void main(String[] args){
        
        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://Abhinay:1433;databaseName=BikeStores;user=sa;password=abcd;encrypt=True;trustServerCertificate=true";
        String sql = "Select * from Sales.customers c where c.customer_id <= 5";

        try (
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql)
        ){
            ResultSetMetaData rsmd = rs.getMetaData();
            int columncount = rsmd.getColumnCount();
            System.out.println("Customer Id\tFirst Name\tZip Code");
            while(rs.next()){
                for(int i = 1; i<=columncount; i++){
                    String col = rsmd.getColumnName(i);
                    Object value = rs.getObject(i);
                    System.out.println(rs.getInt("customer_id"+"value"));
                }
                System.out.println();
                // System.out.print(rs.getInt("customer_id")+"\t\t");
                // System.out.print(rs.getString("first_name")+"\t\t");
                // System.out.println(rs.getInt("zip_code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
