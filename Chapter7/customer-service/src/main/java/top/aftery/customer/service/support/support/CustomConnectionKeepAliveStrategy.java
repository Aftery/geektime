package top.aftery.customer.service.support.support;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.util.Arrays;

/**
 * @classname: CustomConnectionKeepAliveStrategy
 * @Auther: aftery
 * @Date: 2020/4/16 20:37
 * @Description:
 */
public class CustomConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {

    private final Long DEFAULT_SECONDS = 30L;

    @Override
    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {

        return Arrays.asList(httpResponse.getHeaders(HTTP.CONN_KEEP_ALIVE))
                .stream()
                .filter(h -> StringUtils.equalsAnyIgnoreCase(h.getName(), "timeout") &&
                        StringUtils.isNumeric(h.getValue()))
                .findFirst()
                .map(h -> NumberUtils.toLong(h.getValue(), DEFAULT_SECONDS))
                .orElse(DEFAULT_SECONDS) * 1000;
    }
}
