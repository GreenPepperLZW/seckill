package com.lzw.seckill.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 接收登录参数
 * @author : lzw
 * @date : 2022/4/12
 * @since : 1.0
 */
@Data
@ApiModel(value = "登录请求实体")
public class LoginVo {

    @NotNull
//    @IsMobile
    @ApiModelProperty("手机号码")
    private String mobile;

    @NotNull
    @Length(min = 32)
    @ApiModelProperty("密码（md5加密）")
    private String password;

}
