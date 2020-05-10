package top.aftery.fixed.discovery.client.demo.support;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @classname: FixedServerList
 * @Auther: aftery
 * @Date: 2020/5/7 20:58
 * @Description:
 */
public class FixedServerList implements ServerList<Server> {

    @Autowired
    private FixedDiscoveryClient discoveryClient;
    @Override
    public List<Server> getInitialListOfServers() {
        return getServers();
    }

    @Override
    public List<Server> getUpdatedListOfServers() {
        return getServers();
    }

    private List<Server> getServers() {
        return discoveryClient.getInstances(FixedDiscoveryClient.SERVICE_ID).stream()
                .map(i -> new Server(i.getHost(), i.getPort()))
                .collect(Collectors.toList());
    }
}
