package top.aftery.mybatis.pagehelper.demo.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @classname: MoneyTypeHandler
 * @Auther: aftery
 * @Date: 2020-04-05 11:27
 * @Description: 在 Money 与 Long 之间转换的 TypeHandler，处理 CNY 人民币
 */

public class MoneyTypeHandler extends BaseTypeHandler<Money> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money money, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i,money.getAmountMajorLong());
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return paresMoney(resultSet.getLong(s));
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return paresMoney(resultSet.getLong(i));
    }

    @Override
    public Money getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return paresMoney(callableStatement.getLong(i));
    }

    public Money paresMoney(Long value){
        return Money.of(CurrencyUnit.of("CNY"),value/100.00);
    }
}
