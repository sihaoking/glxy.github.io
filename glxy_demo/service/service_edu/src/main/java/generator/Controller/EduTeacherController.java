package generator.Controller;

import generator.pojo.EduTeacher;
import generator.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation("获取所有教师列表")
    @GetMapping("getEduTeacher")
    public List<EduTeacher> getEduTeacher(){
        return eduTeacherService.list();
    }

    @ApiOperation("根据id逻辑删除教师")
    @DeleteMapping("delEduTeacher/{id}")
    public boolean delEduTeacher(@PathVariable String id){
        boolean isdel = eduTeacherService.removeById(id);
        return isdel;
    }

}
