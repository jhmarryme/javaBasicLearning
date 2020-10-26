package reading.designPatternLesson.creational.prototype.shallowClone;

import lombok.Data;

/**
 * description: 
 * @Author: Wjh
 * @Date: 2020/10/12 12:49
 * @Modified By:
 */
@Data
public class Customer implements Cloneable {

    private Address address;

    /**
     * 浅克隆
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Customer clone(){
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

        return (Customer)obj;
    }
}
