package logging.jul;

import java.io.IOException;
import java.util.logging.*;

/**
 * Логгирование с помощью встроенного java логера.
 * Источник: https://www.youtube.com/watch?v=e1Balqbin84
 *
 */
public class JavaUtilLogger {
    private static final Logger logger = Logger.getLogger(JavaUtilLogger.class.getName());

    public static void main(String[] args) throws IOException {

        //применить конфигурационный файл
        //LogManager.getLogManager().readConfiguration();
        //TODO без него тоже выводится наш конфигуратор
        // достаточно к конфигурации прописать путь к своему конфигуратору в VM option
        //Например:
        //-Djava.util.logging.config.file=D:\GeekBrains\_Mentoring\Mentoring\src\main\java\logging\jul\logTest.properties
        //TODO а это не работает. Не находит файл. Где он должен лежать?
        //LogManager.getLogManager().readConfiguration(JavaUtilLogger.class.getResourceAsStream("logTest.properties"));
        //System.out.println(JavaUtilLogger.class.getResourceAsStream("logTest.properties"));//null

        //выводим путь и название конфигурационного файла для логирования проекта
        System.out.println(System.getProperty("java.util.logging.config.file"));
        //result
        //D:\GeekBrains\_Mentoring\Mentoring\src\main\java\logging\jul\logTest.properties

        //отключаем хандлер по умолчанию, чтобы не выводить в консоль!
        //logger.setUseParentHandlers(false);
        //С этой командой перестал выводить все логи

        System.out.println("***Levels list***");
        logger.log(Level.ALL, "ALL Level: " + Level.ALL.intValue());
        //ALL: ALL Level: -2147483648 [Пт сен 20 12:13:15 MSK 2019]

        //System.out.println(Level.FINEST.getName() + " Level: " + Level.FINEST.intValue());
        //FINEST Level: 300
        logger.log(Level.FINEST, "FINEST Level: " + Level.FINEST.intValue());
        //Не отобразится пока уровень выставлен INFO

        //System.out.println(Level.FINER.getName() + " Level: " + Level.FINER.intValue());
        //FINER Level: 400
        logger.log(Level.FINER, "FINER Level: " + Level.FINER.intValue());
        //Не отобразится пока уровень выставлен INFO

        //System.out.println(Level.FINE.getName() + " Level: " + Level.FINE.intValue());
        //FINE Level: 500
        logger.log(Level.FINE, "FINE Level: " + Level.FINE.intValue());
        //Не отобразится пока уровень выставлен INFO

        //System.out.println(Level.CONFIG.getName() + " Level: " + Level.CONFIG.intValue());
        //CONFIG Level: 700
        logger.log(Level.CONFIG, "CONFIG Level: " + Level.CONFIG.intValue());
        //Не отобразится пока уровень выставлен INFO

        logger.log(Level.INFO, "INFO Level: " + Level.INFO.intValue());
        //сен 19, 2019 1:50:18 PM logging.JavaUtilLogger main
        //INFO: INFO Level: 800

        logger.log(Level.WARNING, "WARNING Level: " + Level.WARNING.intValue(), new Throwable());
        //сен 19, 2019 1:50:18 PM logging.JavaUtilLogger main
        //WARNING: WARNING Level: 900
        //java.lang.Throwable
        //	at logging.JavaUtilLogger.main(JavaUtilLogger.java:49)

        logger.log(Level.SEVERE, "SEVERE Level: " + Level.SEVERE.intValue());
        //сен 19, 2019 1:59:41 PM logging.JavaUtilLogger main
        //SEVERE: SEVERE Level: 1000

        logger.log(Level.OFF, "OFF Level: " + Level.OFF.intValue());
        //OFF: OFF Level: 2147483647 [Пт сен 20 12:13:15 MSK 2019]

        //После применения MyFileFilter в файл выведется
        //FINE: FINE Level: 500 [Пт сен 20 13:20:16 MSK 2019]

        //После применения MyConsoleFilter в console выведется
        //D:\GeekBrains\_Mentoring\Mentoring\src\main\java\logging\jul\logTest.properties
        //***Levels list***
        //WARNING: WARNING Level: 900 [Пт сен 20 13:43:21 MSK 2019]

    }


}
