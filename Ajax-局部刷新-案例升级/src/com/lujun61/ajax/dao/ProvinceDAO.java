package com.lujun61.ajax.dao;

import com.lujun61.ajax.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceDAO {
    /**
     * @param id 省份编号
     * @return java.lang.String 对应的省份名称
     * @description 通过省份编号查询对应的省份名称
     * @author Jun Lu
     * @date 2021-10-07 21:01:23
     */
    public String searchById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String name = null;

        try {
            String sql = "select name from table_province where id=?";
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();

            //反正只需要查询一条数据，用if足矣
            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return name;
    }
}
