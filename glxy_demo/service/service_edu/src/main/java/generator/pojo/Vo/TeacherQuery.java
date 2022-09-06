package generator.pojo.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yyds
 * @version 1.0
 * @date 2022/9/6 18:56
 */
@ApiModel(value = "教师条件查询vo类")
@Data
public class TeacherQuery {
    @ApiModelProperty(value = "教师姓名")
    private String name;
    @ApiModelProperty(value = "教师等级 1高级 2首席")
    private Integer level;
    @ApiModelProperty(value = "开始时间")
    private String begin;
    @ApiModelProperty(value = "结束时间")
    private String end;
}
