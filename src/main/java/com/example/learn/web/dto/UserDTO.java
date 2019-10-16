package com.example.learn.web.dto;


import com.example.learn.web.dto.assist.Create;
import com.example.learn.web.dto.assist.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author LiJing
 * @ClassName: UserDTO
 * @Description: 用户传输对象
 * @date 2019/7/30 13:55
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *    1.@NotNull：不能为null，但可以为empty(""," ","   ")
     *    2.@NotEmpty：不能为null，而且长度必须大于0 (" ","  ")
     *    3.@NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0("test")    即：必须有实际字符
     */

    /*** 用户ID*/
    @NotNull(message = "{1}不能为空", groups = Update.class)
    private Long userId;

    /**
     * 用户名
     * groups用法的参考：https://mp.weixin.qq.com/s?__biz=MzU2MTI4MjI0MQ==&mid=2247487327&idx=1&sn=c9014acaf4e65ef48e09b64aa010da65&chksm=fc7a62f1cb0debe78f6dda58fcd45a8cca534639028a477d9873b06bdd0e553a02b1ce44b1cb&mpshare=1&scene=1&srcid=&sharer_sharetime=1567920134736&sharer_shareid=b86b5810dad2c44f89d45899ed8f1071&key=180c7b20f6306d86898e6b5a8ef17e3cbd9829d77e64a7421d83f7c465b5c7b1121d7029e74407dd4f87582417c1087011ac58cd5b93a8c8463f2b326d1e073d56ee5ef2d3c8555dcca947da426c2fea&ascene=1&uin=MjE2NDM5MTUyMA%3D%3D&devicetype=Windows+10&version=62060833&lang=zh_CN&pass_ticket=h1dknxWU6HmRT%2FXawgSpWsuyTxai4XpSHCTImNjuMpDFu21dQLP6E4%2BR44T5tfnz
     *
     */
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符", groups = {Create.class, Update.class})
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    private String username;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误", groups = {Create.class, Update.class})
    private String mobile;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    @NotBlank(message = "联系邮箱不能为空")
    @Email(message = "邮箱格式不对")
    private String email;

    /**
     * 密码
     */
    private String password;

    /*** 创建时间 */
    @Future(message = "时间必须是将来时间", groups = {Create.class})
    private Date createTime;

}