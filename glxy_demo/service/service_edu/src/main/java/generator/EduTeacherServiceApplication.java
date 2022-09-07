package generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author yyds
 * @version 1.0
 * @date 2022/9/5 21:38
 */
@SpringBootApplication
@MapperScan("generator/mapper")
public class EduTeacherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduTeacherServiceApplication.class,args);
    }
}
