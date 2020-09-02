package base.exception;

import lombok.Getter;

/**
 * description: 处理数据为空(未找到)的情况
 *
 * @Author: Wjh
 * @Date: 2020/9/2 12:31
 * @Modified By:
 */
@Getter
public class EntityNotFoundException extends Exception {
    private final String msg;

    public EntityNotFoundException(String msg) {
        this.msg = msg;
    }
}
