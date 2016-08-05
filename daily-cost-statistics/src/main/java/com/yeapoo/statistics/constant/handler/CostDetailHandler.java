package com.yeapoo.statistics.constant.handler;

import com.yeapoo.statistics.constant.CostDetail;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Created by hebo on 2016/8/1.
 */
public class CostDetailHandler implements TypeHandler<CostDetail> {

    private static Logger logger = Logger.getLogger(CostDetailHandler.class);
    private Class<CostDetail> type;

    private final CostDetail[] enums;

    /**
     * 设置配置文件设置的转换类以及枚举类内容，供其他方法更便捷高效的实现
     *
     * @param type 配置文件中设置的转换类
     */
    public CostDetailHandler(Class<CostDetail> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName() + " does not represent an enum type.");
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, CostDetail parameter, JdbcType jdbcType) throws SQLException {
        /**
         * baseTypeHandler已经帮我们做了parameter的null判断
         */
        ps.setString(i, parameter.getCode());

    }

    @Override
    public CostDetail getResult(ResultSet rs, String columnName) throws SQLException {
        /**
         * 根据数据库存储类型决定获取类型
         */
        String code = rs.getString(columnName);
        return getEnumType(code);
    }

    @Override
    public CostDetail getResult(ResultSet rs, int columnIndex) throws SQLException {
        /**
         * 根据数据库存储类型决定获取类型
         */
        String code = rs.getString(columnIndex);
        return getEnumType(code);
    }

    @Override
    public CostDetail getResult(CallableStatement cs, int columnIndex) throws SQLException {
        /**
         * 根据数据库存储类型决定获取类型
         */
        String code = cs.getString(columnIndex);
        return getEnumType(code);
    }

    /**
     * 消费详情转换，由于构造函数获取了枚举的子类enums，让遍历更加高效快捷
     *
     * @param code 数据库中存储的自定义code属性
     * @return code对应的枚举类
     */
    private CostDetail getEnumType(String code) {
        for (CostDetail bean : enums) {
            if (code != null && code.equals(bean.getCode())) {
                return bean;
            }
        }
        logger.debug("快递枚举类型值：" + code);
        return null;
    }

}
