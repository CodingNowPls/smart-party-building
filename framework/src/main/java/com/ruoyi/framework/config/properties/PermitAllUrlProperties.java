package com.ruoyi.framework.config.properties;

import com.ruoyi.common.annotation.Anonymous;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 设置Anonymous注解允许匿名访问的url
 *
 * @author ruoyi
 */
@Configuration
public class PermitAllUrlProperties implements InitializingBean, ApplicationContextAware {
    @Getter
    private List<String> urls = new ArrayList<>();
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");
    public String ASTERISK = "*";
    private ApplicationContext applicationContext;


    @Override
    public void afterPropertiesSet() {

        // 获取所有带有 @Anonymous 注解的 Controller 类
        Map<String, Object> controllers = applicationContext.getBeansWithAnnotation(Anonymous.class);


        for (Object controller : controllers.values()) {
            Class<?> clazz = controller.getClass();

            // 获取类级别的 @RequestMapping 或其他派生注解
            String[] classPaths = getMappingPaths(clazz);

            // 如果 @Anonymous 注解在类上
            if (AnnotationUtils.findAnnotation(clazz, Anonymous.class) != null) {
                // 遍历类中的所有方法
                for (Method method : clazz.getMethods()) {
                    // 获取方法上的所有映射注解
                    String[] methodPaths = getMappingPaths(method);
                    for (String classPath : classPaths) {
                        for (String methodPath : methodPaths) {
                            urls.add(classPath + methodPath);
                        }
                    }
                }
            }

            // 如果 @Anonymous 注解在方法上
            for (Method method : clazz.getMethods()) {
                if (AnnotationUtils.findAnnotation(method, Anonymous.class) != null) {
                    // 获取方法上的映射路径
                    String[] methodPaths = getMappingPaths(method);
                    for (String classPath : classPaths) {
                        for (String methodPath : methodPaths) {
                            urls.add(classPath + methodPath);
                        }
                    }
                }
            }
        }
    }



    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }


    // 获取类或方法上的映射路径（包括 @RequestMapping, @GetMapping, @PostMapping 等）
    private String[] getMappingPaths(AnnotatedElement element) {
        List<String> paths = new ArrayList<>();

        // 检查 @RequestMapping
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(element, RequestMapping.class);
        if (requestMapping != null) {
            for (String path : requestMapping.value()) {
                paths.add(path);
            }
        }

        // 检查 @GetMapping
        GetMapping getMapping = AnnotationUtils.findAnnotation(element, GetMapping.class);
        if (getMapping != null) {
            for (String path : getMapping.value()) {
                paths.add(path);
            }
        }

        // 检查 @PostMapping
        PostMapping postMapping = AnnotationUtils.findAnnotation(element, PostMapping.class);
        if (postMapping != null) {
            for (String path : postMapping.value()) {
                paths.add(path);
            }
        }

        PutMapping putMapping = AnnotationUtils.findAnnotation(element, PutMapping.class);
        if (putMapping != null) {
            for (String path : putMapping.value()) {
                paths.add(path);
            }
        }

        DeleteMapping deleteMapping = AnnotationUtils.findAnnotation(element, DeleteMapping.class);
        if (deleteMapping != null) {
            for (String path : deleteMapping.value()) {
                paths.add(path);
            }
        }


        return paths.toArray(new String[0]);
    }

}
