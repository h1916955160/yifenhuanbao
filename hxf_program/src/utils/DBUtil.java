package utils;
import javax.management.relation.RoleResult;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    private static String dbUrl="jdbc:mysql://localhost:3306/db_garbage_system";
    private  static String user="root";
    private  static  String password="1916955160huang";
    private static String jdbcName="com.mysql.jdbc.Driver";

    //连接数据库
    public   static Connection getCon() throws ClassNotFoundException, SQLException{
        Class.forName(jdbcName);
        System.out.println("测试加载数据库成功");
        Connection conn = DriverManager.getConnection(dbUrl, user, password);
        System.out.println("测试数据库连接成功");
        return conn;
    }
    //关闭数据库
    public void closeCon(Connection con,PreparedStatement ps, ResultSet rs) throws Exception {
        if (rs != null) {//关闭资源，避免出现异常
            try {
                rs.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                    e.printStackTrace();
                }
            }
            if (con != null) {
                con.close();
            }
        }
    }

    //增删查改
    public static boolean addUpdateDelete(String sql,Object[] arr) throws ClassNotFoundException, SQLException{
         Connection con;
         PreparedStatement ps;
         try {
                 con=DBUtil.getCon();//第一步 ：连接数据库的操作

                 ps=con.prepareStatement(sql);//第二步：预编译
                 //第三步：设置值
                 if(arr!=null && arr.length!=0){
                         for(int i=0;i<arr.length;i++){
                                 ps.setObject(i+1, arr[i]);
                             }
                     }
                 int count=ps.executeUpdate();//第四步：执行sql语句
                 if(count>0){
                         return true;
                     }else{
                         return false;
                     }
             } catch (ClassNotFoundException | SQLException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }
        return false;
     }
}
