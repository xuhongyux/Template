package com.xiayu.jdbc;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author xuhongyu
 * @create 2022-02-23 3:32 下午
 */
public class BatchInsertTest {

//@Service
//public class Test {
//
//    @Autowired
//    JdbcUtils jdbcUtils;
//
//    public void batchInsert(BatchInsertBo batchInsertBo) {
//        List insertDataPos = batchInsertBo.getInsertDataPos();
//        List<BatchInsertAttrBo> batchInsertAttrBos = batchInsertBo.getBatchInsertAttrBos();
//        // sql 文本拼接
//        StringBuilder sqlStringBuilder = new StringBuilder();
//        sqlStringBuilder.append("insert into ");
//        sqlStringBuilder.append(batchInsertBo.getTableName());
//        sqlStringBuilder.append(" (");
//        for (Object obj : batchInsertBo.getBatchInsertAttrBos()) {
//            BatchInsertAttrBo batchInsertAttrBo = (BatchInsertAttrBo) obj;
//            sqlStringBuilder.append(batchInsertAttrBo.getAttrName());
//            sqlStringBuilder.append(",");
//        }
//        sqlStringBuilder.deleteCharAt(sqlStringBuilder.length() - 1);
//        sqlStringBuilder.append(") values(");
//
//        for (int i = 0; i < batchInsertBo.getBatchInsertAttrBos().size(); i++) {
//            sqlStringBuilder.append("?,");
//        }
//        sqlStringBuilder.deleteCharAt(sqlStringBuilder.length() - 1);
//        sqlStringBuilder.append(") ");
//
//        // "insert into function_match_info ( match_key, match_value, match_info, match_type,info) values(?, ?, ?, ?, ?)";
//        String sql = sqlStringBuilder.toString();
//        java.sql.PreparedStatement ptmt = null;
//        Connection connection = jdbcUtils.getConnection();
//        try {
//            // 关闭事务
//            connection.setAutoCommit(false);
//            ptmt = connection.prepareStatement(sql);
//
//        } catch (SQLException e2) {
//            e2.printStackTrace();
//        }
//
//        for (int i = 1; i <= batchInsertAttrBos.size(); i++) {
//            try {
//                BatchInsertAttrBo batchInsertAttrBo = batchInsertAttrBos.get(i - 1);
//                switch (batchInsertAttrBo.getTypeEnum()){
//                    case STRING:
//                        ptmt.setString(i, batchInsertAttrBo.getAttrName().toString());
//                        break;
//                    case INT:
//                        ptmt.setInt(i, Integer.parseInt(batchInsertAttrBo.getAttrName().toString()));
//                        break;
//                    default:
//                        throw new CustomException(CustomException.DATA_ERROR, "批量插入数据库，属性类型不存在：" + batchInsertAttrBo.getTypeEnum().name());
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        for (BatchInsertAttrBo batchInsertAttrBo : batchInsertAttrBos) {
//
//        }
//
//        for (FunctionMatchInfo paperaper : listNewsPaper) {
//            try {
//                ptmt.setString(1, paperaper.getMatchKey());
//                ptmt.setString(2, paperaper.getMatchValue());
//                ptmt.setString(3, paperaper.getInfo());
//                ptmt.setString(4, paperaper.getMatchType());
//                ptmt.setString(5, paperaper.getInfo());
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            ptmt.executeBatch();//执行给定的SQL语句，该语句可能返回多个结果
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//}


}
