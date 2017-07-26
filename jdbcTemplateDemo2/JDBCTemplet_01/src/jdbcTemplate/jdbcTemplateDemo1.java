package jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.List;

/**
 * Created by dell on 17-7-25.
 */
public class jdbcTemplateDemo1 {
    @Test
    public void add() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //  jdbc:mysql://主机名称：端口号/数据库名称
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbcTemplate");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象里面的方法实现crud操作
        String sql = "insert into manager values(?,?)";
        int rows = jdbcTemplate.update(sql, "Tom", "123456");
        System.out.println(rows);
    }

    @Test
    //查询记录数
    public void testCount() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //  jdbc:mysql://主机名称：端口号/数据库名称
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbcTemplate");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //调用jdbcTemplate对象里面的方法实现crud操作
        String sql = "SELECT COUNT(*) FROM manager";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    //jdbc底层代码实现
    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet resultSet = null;

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbcTemplate", "root", "123456");
        String sql = "select * from manager";
        //预编译sql:connection.prepareStatement(sql);
        //返回预编译对象psmt
        psmt = connection.prepareStatement(sql);
        resultSet = psmt.executeQuery();
        while (resultSet.next()) {

            String username = resultSet.getString("username");
            String passwd = resultSet.getString("password");
            //把记录放到对象里
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwd);

            System.out.println(user.getUsername()+user.getPassword());
        }
        resultSet.close();
        connection.close();
        psmt.close();
    }

    @Test
    //查询返回对象
    public void testObject() throws ClassNotFoundException, SQLException {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //  jdbc:mysql://主机名称：端口号/数据库名称
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbcTemplate");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select * from manager where username=?";
        //参数：sql语句;RowMapper,是接口，类似于dbutils接口;可变参数
        //第二个参数是接口，需要自己写类实现接口，自己做数据封装
        User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), "Tom");
        System.out.println(user.getUsername()+user.getPassword());
    }

    @Test
    //list
    public void testList() throws ClassNotFoundException, SQLException {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //  jdbc:mysql://主机名称：端口号/数据库名称
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbcTemplate");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select * from manager";
        //参数：sql语句;RowMapper,是接口，类似于dbutils接口;可变参数
        //第二个参数是接口，需要自己写类实现接口，自己做数据封装
        List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
        System.out.println(list);
    }

}

class MyRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int num) throws SQLException {

        String username = rs.getString("username");
        String passwd = rs.getString("password");
        //把记录放到对象里
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwd);

        return user;
    }
}