package effectiveJava._10_equalswithrules;

import java.util.Objects;

/**
 * description: 10. 重写 equals 方法时遵守通用约定
 *  对称性验证
 * @Author: Wjh
 * @Date: 2020/8/26 11:24
 * @Modified By:
 */
public final class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    /*
     * description: 不具备对称性的equals方法, a.equals(b) = true, b.equals(a) = false;
     * @Author: Wjh
     * @Date: 2020/8/26 14:14
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s);
        if (o instanceof String)  // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    /*
     * Description: 具备对称性的equals方法
     * @Author: Wjh
     * @Date: 2020/8/26 14:16
     */
    /*@Override
    public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }*/

}
