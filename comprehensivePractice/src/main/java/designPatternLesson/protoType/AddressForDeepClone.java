package designPatternLesson.protoType;

import java.io.Serializable;

/**
 * 为深克隆准备的属性
 * @author jhmarryme.cn
 * @date 2019/10/13 19:29
 */
public class AddressForDeepClone implements Serializable {

    public String getAddress(){
        return "测试地址";
    }
}
