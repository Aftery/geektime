package top.aftery.druiddemo;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @classname: ConnectionLogFilter
 * @Auther: aftery
 * @Date: 2020-03-28 16:45
 * @Description:
 */
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        System.out.println("======================");
        log.info("connection_connectBefore");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {

        System.out.println("======================");
        log.info("connection_connectAfter");
    }

}
