package top.aftery.mongo.demo.converter;


import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * @classname: MoneyReadConverter
 * @Auther: aftery
 * @Date: 2020-04-05 16:19
 * @Description:
 */

public class MoneyReadConverter implements Converter<Document, Money> {


    @Override
    public Money convert(Document source) {
        Document money = (Document) source.get("money");
        double amount = Double.parseDouble(money.getString("amount"));
        String currency = ((Document) money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency), amount);
    }
}
