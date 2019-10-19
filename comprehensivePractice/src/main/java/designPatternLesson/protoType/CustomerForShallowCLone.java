package designPatternLesson.protoType;

/**
 * 通过实现Cloneable接口的浅克隆实现原型模式
 * @author jhmarryme.cn
 * @date 2019/10/13 19:44
 */
public class CustomerForShallowCLone implements Cloneable{

    AddressForShallowClone address;

    public AddressForShallowClone getAddress() {
        return address;
    }

    public void setAddress(AddressForShallowClone address) {
        this.address = address;
    }

    /**
     * 浅克隆
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected CustomerForShallowCLone clone(){
        Object obj = null;

        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }

        return (CustomerForShallowCLone)obj;
    }
}
