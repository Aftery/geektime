package top.aftery.mybatis.generator.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: MoneyTypeHandler
 * @description:
 * @author: aftery
 * @create: 2020-03-31 15:44
 * 在 Money 与 Long 之间转换的 TypeHandler，处理 CNY 人民币
 **/

public class MoneyTypeHandler extends BaseTypeHandler<Money> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money o, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, o.getAmountMajorLong());
    }


    @Override
    public Money getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return parseMoney(resultSet.getLong(columnName));
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Money getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }

    private Money parseMoney(Long value) {
        return Money.of(CurrencyUnit.of("CNY"), value / 100.0);
    }
}
