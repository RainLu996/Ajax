package com.lujun61.ajax.dao;

import com.lujun61.ajax.entity.Province;
import com.lujun61.ajax.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UpdateProvinceDAO {
    /**
     * @param id 省份编号
     * @return com.lujun61.ajax.entity.Province 查询地区的详细信息
     * @description 通过省份编号查询对应的省份详细信息
     * @author Jun Lu
     * @date 2021-10-07 21:02:26
     */
    public Province searchById(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Province province = new Province();

        try {
            String sql = "select id,name,simpleName,province from table_province where id=?";
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();

            while (rs.next()) {
                province.setId(rs.getInt("id"));
                province.setName(rs.getString("name"));
                province.setSimpleName(rs.getString("simpleName"));
                province.setprovince(rs.getString("province"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return province;
    }
}
