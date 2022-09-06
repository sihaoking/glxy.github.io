package generator.Controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import generator.Interface.R;
import generator.pojo.EduTeacher;
import generator.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "分页查询教师列表")
    @GetMapping("getEduTeacherByPage/{current}/{limit}")
    public R getEduTeacherByPage(@PathVariable(required = false) Long current,@PathVariable(required = false) Long limit){
        IPage<EduTeacher> page = new Page<>(current,limit);
        eduTeacherService.page(page);
        return R.ok().data("total",page.getTotal()).data("rows",page.getRecords());
    }

    @ApiOperation(value = "获取所有教师列表")
    @GetMapping("getEduTeacher")
    public R getEduTeacher(){
        List<EduTeacher> eduTeacherList = eduTeacherService.list();
        return R.ok().data("rows",eduTeacherList);
    }

    @ApiOperation(value = "根据id逻辑删除教师")
    @ApiParam(value = "id")
    @DeleteMapping("delEduTeacher/{id}")
    public R delEduTeacher(@PathVariable String id){
        boolean isdel = eduTeacherService.removeById(id);
        return isdel?R.ok():R.fail();
    }

}
