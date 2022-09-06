package generator.Controller;

import generator.pojo.EduTeacher;
import generator.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yyds
 * @version 1.0
 * @date 2022/9/5 21:32
 */
@RestController
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @RequestMapping("getEduTeacher")
    public List<EduTeacher> getEduTeacher(){
        return eduTeacherService.list();
    }

    @DeleteMapping("delEduTeacher/{id}")
    public boolean delEduTeacher(@PathVariable String id){
        boolean isdel = eduTeacherService.removeById(id);
        return isdel;
    }

}
