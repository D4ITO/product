package connection;

import java.sql.*;

public class ConectSQL {

        private static String Driver = "com.mysql.cj.jdbc.Driver";
        private static String Url = "jdbc:mysql://localhost:3306/sa4e2";
        private static String User = "root";
        private static String Pass = "1234";

        public Connection startConection(){
            try {
                Class.forName(Driver);
                return DriverManager.getConnection(Url,User,Pass);
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException("Deu erro meu consagrado em: "+e);
            }
        }

        public static void stopConnection(Connection connection){
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        public static void stopConnection(Connection connection, PreparedStatement st){
            stopConnection(connection);
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void stopConnection(Connection connection, PreparedStatement st, ResultSet rset){
            stopConnection(connection, st);
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }





}
