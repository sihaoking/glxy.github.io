package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import generator.Interface.R;
import generator.pojo.EduTeacher;
import generator.pojo.Vo.TeacherQuery;
import generator.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yyds
 * @version 1.0
 * @date 2022/9/5 21:32
 */
@Api("教师控制类")
@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/eduTeacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;
    @ApiOperation(value = "教师登录接口")
    @PostMapping("user/login")
    public R eduTeacherLogin(){
        return R.ok().data("token","admin");
    }
    @GetMapping("user/info")
    public R getDeuTeacherInfo(){
        return R.ok().data("name","zs").data("avatar","photo");
    }

    @ApiOperation(value = "分页查询教师列表")
    @GetMapping("getEduTeacherByPage/{current}/{limit}")
    public R getEduTeacherByPage(@PathVariable Long current,
                                 @PathVariable Long limit,
                                  TeacherQuery teacherQuery){
        IPage<EduTeacher> page = new Page<>(current,limit);
        LambdaQueryWrapper<EduTeacher> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(teacherQuery.getName() != null,EduTeacher::getName,teacherQuery.getName());
        lambdaQueryWrapper.eq(teacherQuery.getLevel() != null,EduTeacher::getLevel,teacherQuery.getLevel());
        lambdaQueryWrapper.ge(teacherQuery.getBegin() != null,EduTeacher::getGmtCreate,teacherQuery.getBegin());
        lambdaQueryWrapper.le(teacherQuery.getEnd() != null,EduTeacher::getGmtModified,teacherQuery.getEnd());
        eduTeacherService.page(page,lambdaQueryWrapper);
        return R.ok().data("total",page.getTotal()).data("rows",page.getRecords());
    }

    @ApiOperation(value = "获取所有教师列表")
    @GetMapping("getEduTeacher")
    public R getEduTeacher(){
        List<EduTeacher> eduTeacherList = eduTeacherService.list();
        return R.ok().data("rows",eduTeacherList);
    }

    @ApiOperation(value = "根据id逻辑删除教师")
    @DeleteMapping("delEduTeacher/{id}")
    public R delEduTeacher(@PathVariable String id){
        boolean isdel = eduTeacherService.removeById(id);
        return isdel?R.ok():R.fail();
    }

}
