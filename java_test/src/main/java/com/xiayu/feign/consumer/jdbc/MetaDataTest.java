package com.xiayu.feign.consumer.jdbc;

import com.beust.jcommander.internal.Lists;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

/**
 * @author xuhongyu
 * @create 2021-06-21 14:58
 */
public class MetaDataTest {
    @Test
    public void dataBaseMetaDataTest() throws Exception {
        // 得到Connection对象
        Connection con = JDBCUtil.getConnection();
        // 得到DataBaseMetaData对象
        DatabaseMetaData metaData = con.getMetaData();

        System.out.println("获取数据库的产品名称: " + metaData.getDatabaseProductName());
        System.out.println("获取数据库的版本号: " + metaData.getDatabaseProductVersion());
        System.out.println("获取数据库的用户名: " + metaData.getUserName());
        System.out.println("获取数据库的URL: " + metaData.getURL());
        System.out.println("获取数据库的驱动名称: " + metaData.getDriverName());
        System.out.println("获取数据库的驱动版本号: " + metaData.getDriverVersion());
        System.out.println("查看数据库是否只允许读操作: " + metaData.isReadOnly());
        System.out.println("查看数据库是否支持事务: " + metaData.supportsTransactions());
    }

    @Test
    public void parameterMetaDataTest() throws Exception {
        //得到Connection对象
        Connection con = JDBCUtil.getConnection();
        //创建SQL
        String sql = "select * from test where id=? and sname=?";
        //预编译SQL,得到prepareStatement对象
        PreparedStatement prepareStatement = con.prepareStatement(sql);
        //得到parameterMetaData对象
        ParameterMetaData parameterMetaData = prepareStatement.getParameterMetaData();
        //获取参数个数
        int count = parameterMetaData.getParameterCount();

        //输出
        System.out.println("占位符个数为: " + count);
    }

    @Test
    public void resultSetMetaDataTest() {
        String creatTableName = "testCreat1";

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //得到Connection对象
            con = JDBCUtil.getConnection();
            String sql = "select * from test";
            //预编译sql语句,得到PreparedStatement对象
            stmt = con.prepareStatement(sql);
            //执行sql
            rs = stmt.executeQuery();
            //得到结果集元对象
            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            // 收集列信息
            List<ColumnBo> columnBoList = Lists.newArrayList();
            for (int i = 1; i <= columnCount; i++) {
                String columnTypeName = metaData.getColumnTypeName(i);
                String columnName = metaData.getColumnName(i);
                int precision = metaData.getPrecision(i);
                ColumnBo columnBo = new ColumnBo();
                columnBo.setPrecision(precision);
                columnBo.setColumnTypeName(columnTypeName);
                columnBo.setColumnName(columnName);
                columnBoList.add(columnBo);
            }

            // 创建表SQL 拼接
            StringBuilder creatSql = new StringBuilder();
            creatSql.append("CREATE TABLE ");
            creatSql.append(creatTableName);
            creatSql.append("(");
            for (ColumnBo columnBo : columnBoList) {
                creatSql.append(columnBo.toString());
                creatSql.append(",");
            }
            creatSql.deleteCharAt(creatSql.length() - 1);
            creatSql.append(")");
            creatSql.append("ENGINE=InnoDB DEFAULT CHARSET=utf8;");
            System.out.println(creatSql.toString());

            // 执行建表语句
            stmt.execute(creatSql.toString());

//            System.out.println("获取结果集的列数: " + metaData.getColumnCount());
//            System.out.println("获取指定列的名称: " + metaData.getColumnName(1));
//            System.out.println("获取指定列的SQL类型对应于java.sql.Types类的字段: " + metaData.getColumnType(2));
//            System.out.println("获取指定列的SQL类型: " + metaData.getColumnTypeName(1));
//            System.out.println("获取指定列SQL类型对应于Java的类型: " + metaData.getColumnClassName(1));
//            System.out.println("获取指定列所在的表的名称: " + metaData.getTableName(1));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JDBCUtil.free(rs, stmt, con);
        }

    }
}