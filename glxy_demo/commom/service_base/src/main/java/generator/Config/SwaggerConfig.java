package generator.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author yyds
 * @version 1.0
 * @date 2022/9/6 14:59
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 配置docket以配置Swagger具体参数*/
    @Bean
    public Docket productDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("All")
                //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .enable(true)
                .pathMapping("/")
                //通过.select()方法，去配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                .select()
                //配置需要扫描的包
                .apis(RequestHandlerSelectors.basePackage("generator.Controller"))
                //配置扫描的路径，我设置为所有的路径
                .paths(PathSelectors.any())
                .build();
                //忽略参数
                //.ignoredParameterTypes(HttpSession.class, HttpServletRequest.class, HttpServletResponse.class)
                //关联上apiInfo()

    }
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                //标题
                .title("谷粒学院项目接口文档")
                //描述
                .description("谷粒学院")
                .version("1.0").build();
    }
}
