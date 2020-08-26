package effectiveJava._10_equalswithrules;

import java.util.Objects;

/**
 * description: 10. 重写 equals 方法时遵守通用约定
 *
 * @Author: Wjh
 * @Date: 2020/8/26 11:24
 * @Modified By:
 */
public final class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
    @Override
    public boolean equals(Object o) {
        if (o instanceof CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((CaseInsensitiveString) o).s);
        if (o instanceof String)  // One-way interoperability!
            return s.equalsIgnoreCase((String) o);
        return false;
    }
}
