package top.aftery.redis.repository.demo.converter;

import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.nio.charset.StandardCharsets;

/**
 * @classname: MoneyToBytesConverter
 * @Auther: aftery
 * @Date: 2020-04-06 11:19
 * @Description:
 */
@WritingConverter
public class MoneyToBytesConverter implements Converter<Money, byte[]> {


    @Override
    public byte[] convert(Money money) {
        String value = Long.toString(money.getAmountMajorLong());
        return value.getBytes(StandardCharsets.UTF_8);
    }
}
