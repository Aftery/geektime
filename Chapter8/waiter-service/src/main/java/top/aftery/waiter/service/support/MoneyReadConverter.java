package top.aftery.waiter.service.support;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * @classname: MoneyReadConverter
 * @Auther: aftery
 * @Date: 2020/4/18 16:48
 * @Description:
 */
@ReadingConverter
public class MoneyReadConverter implements Converter<Long, Money> {
    @Override
    public Money convert(Long aLong) {
        return Money.ofMajor(CurrencyUnit.of("CNY"), aLong);
    }
}
