package cn.jhmarryme.practiceproject.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author jhmarryme.cn
 * @date 2019/10/24 10:16
 */
@Data
@Table(name = "tb_user")
public class UserInfo {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Date birthday;

}
