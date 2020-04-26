package top.aftery.advanced.resttemplate.demo.support;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @classname: MoneyDesrializer
 * @Auther: aftery
 * @Date: 2020/4/14 21:34
 * @Description:
 */
@JsonComponent
public class MoneyDesrializer extends StdDeserializer<Money> {
    protected MoneyDesrializer() {
        super(Money.class);
    }

    @Override
    public Money deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        return Money.of(CurrencyUnit.of("CNY"), p.getDecimalValue());
    }
}
