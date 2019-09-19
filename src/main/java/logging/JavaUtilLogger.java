package logging;

import java.util.logging.Logger;

public class JavaUtilLogger {
    private static final Logger logger = Logger.getLogger(JavaUtilLogger.class.getName());

    public static void main(String[] args) {
        //выводим путь и название конфигурационного файла для логирования проекта
        System.out.println(System.getProperty("java.util.logging.config.file"));
    }
}
