package koschei;

import koschei.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        KoscheiTheDeathless koscheiTheDeathless =
                applicationContext.getBean(KoscheiTheDeathless.class);
        System.out.println(koscheiTheDeathless.getRulesByDeth());
    }

    // шпаргалка
    // injection через:
    // 1. через метод с @Autowired в @Component классе, подтягивает аргументы как зависимости
    // 2. проперт + @Autowire в @Component классе, сама зависимость
    //      объявлена как метод с @Bean в @Configuration классе, в которую (в bean) так же подтягивает аргументы как зависимости
    // 3. через конструктор + @Autowire (подтягивает ппараметры как зависимости
}
