package top.aftery.waiter.service.support;

import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * @classname: MoneyWriteConverter
 * @Auther: aftery
 * @Date: 2020/4/18 16:51
 * @Description:
 */
@WritingConverter
public class MoneyWriteConverter implements Converter<Money,Long> {
    @Override
    public Long convert(Money money) {
        return money.getAmountMinorLong();
    }
}
