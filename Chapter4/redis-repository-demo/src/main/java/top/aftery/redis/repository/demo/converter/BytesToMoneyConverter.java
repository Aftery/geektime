package top.aftery.redis.repository.demo.converter;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.nio.charset.StandardCharsets;

/**
 * @classname: BytesToMoneyConverter
 * @Auther: aftery
 * @Date: 2020-04-06 11:21
 * @Description:
 */
@ReadingConverter
public class BytesToMoneyConverter implements Converter<byte[], Money> {
    @Override
    public Money convert(byte[] bytes) {
        String value = new String(bytes, StandardCharsets.UTF_8);
        return Money.ofMajor(CurrencyUnit.of("CNY"), Long.parseLong(value));
    }
}
