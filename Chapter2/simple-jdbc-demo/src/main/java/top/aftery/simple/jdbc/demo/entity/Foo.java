package top.aftery.simple.jdbc.demo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @classname: Foo
 * @Auther: aftery
 * @Date: 2020-03-28 17:28
 * @Description:
 */
@Data
@Builder
public class Foo {

    private Long id;

    private String bar;

}
