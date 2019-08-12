import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
    // 得到一个c3p0的数据源
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    // 从数据源中得到一个连接对象
    // 这个返回的connection实际上是c3p0经过装饰之后的connection
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("服务器错误");
        }
    }

    //查看连接池的状态
    public static void poolStatus() {
        try {
            System.out.println("清闲的：" + dataSource.getNumIdleConnections());
            System.out.println("忙碌的：" + dataSource.getNumBusyConnections());
            System.out.println("所有的：" + dataSource.getNumConnections());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
