package generator.Interface;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyds
 * @version 1.0
 * @date 2022/9/6 16:30
 */
@Data
@ApiModel(value = "统一返回结果类")
public class R {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "是否成功")
    private Boolean issucess;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<>();

    private R(){}

    public static R ok(){
        R r = new R();
        r.code(ResultCode.SUCCESS);
        r.message("请求成功");
        r.issucess(true);
        return r;
    }

    public static R fail(){
        R r = new R();
        r.code(ResultCode.ERROR);
        r.message("请求失败");
        r.issucess(false);
        return r;
    }

    public R code(Integer code) {
        this.code = code;
        return this;
    }

    public R issucess(Boolean issucess) {
        this.issucess = issucess;
        return this;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }

    public R data(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
