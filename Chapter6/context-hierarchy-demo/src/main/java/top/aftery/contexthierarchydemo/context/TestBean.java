package top.aftery.contexthierarchydemo.context;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @classname: TestBean
 * @Auther: aftery
 * @Date: 2020-04-11 17:55
 * @Description:
 */
@AllArgsConstructor
@Slf4j
public class TestBean {

    private String context;

    public void hello(){
        log.info("hello:"+context);
    }

}
