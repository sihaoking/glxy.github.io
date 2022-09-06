package generator.pojo;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 教师实体类
 * @author yyds
 * @TableName edu_teacher
 */
@TableName(value ="edu_teacher")
@Data
public class EduTeacher implements Serializable {
    /**
     * 讲师ID
     */
    @TableId
    private String id;

    /**
     * 讲师姓名
     */
    private String name;

    /**
     * 讲师简介
     */
    private String intro;

    /**
     * 讲师资历,一句话说明讲师
     */
    private String career;

    /**
     * 头衔 1高级讲师 2首席讲师
     */
    private Object level;

    /**
     * 讲师头像
     */
    private String avatar;

    /**
     * 排序
     */
    private Object sort;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    @TableLogic(value = "0",delval = "1")
    private Integer isDeleted;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
