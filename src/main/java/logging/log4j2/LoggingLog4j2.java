package logging.log4j2;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.message.MapMessage;

/**
 * Конфигурация - resources/log4j2.xml
 * Лог-файл - src/main/java/logging/log4j2/logs2/log4j2Log.log
 */
public class LoggingLog4j2 {
    //Для использования log4j2 вам необходимо подключить библиотеки
    // log4j-api-2.x и log4j-core-2.x. Log4j имеет несколько отличное от JUL именование
    // уровней логгирования:
    // TRACE, DEBUG, INFO, WARN, ERROR, FATAL, а так же ALL и OFF включающий и
    // отключающий все уровни соответственно.
    //Логгер создается вызовом статического метода класса org.apache.logging.log4j.Logger:
    //Logger log = LogManager.getLogger(LoggingLog4j2.class);
    // или
    //Logger log = LogManager.getLogger(LoggingLog4j2.class.getName());

    public static void main(String[] args) {
        //Логгер создается вызовом статического метода класса org.apache.logging.log4j.Logger:
        Logger log = LogManager.getLogger(LoggingLog4j2.class);
        //Логгер умеет принимать помимо привычных нам String, Object и Throwable
        // еще два новых типа — MapMessage и Marker:
        // Карта сообщений (напечатается как msg1="Сообщение 1” msg2="Сообщение 2”)
        MapMessage mapMessage = new MapMessage();
        mapMessage.put("msg1", "Сообщение 1");
        mapMessage.put("msg2", "Сообщение 2");
        // Маркер, объект по которому можно фильтровать сообщения
        Marker marker = MarkerManager.getMarker("fileonly");
        // Строковое сообщение
        String stringMessage = "Сообщение";
        // Строковое сообщение с параметрами
        String stringMessageFormat = "Сообщение {}, от {}";
        // Исключение
        Throwable throwable = new Throwable();
        // Объект
        Object object = new Object();

        //В классическом для логгеров стиле методы делятся на два типа:
        // Совпадающие с названием уровня логгирования.
        //log.info(mapMessage);
        //log.info(object);
        //log.info(stringMessage);
        //log.info(marker, mapMessage);
        //log.info(marker, object);
        //log.info(marker, stringMessage);
        //log.info(object, throwable);
        //log.info(stringMessage, throwable);
        //log.info(stringMessageFormat, args);
        //log.info(marker, mapMessage, throwable);
        //log.info(marker, object, throwable);
        //log.info(marker, stringMessageFormat, args);
        //log.info(marker, stringMessage, throwable);
        //log.throwing(throwable);

        // Методы log, принимающие уровень логгирования в качестве параметра, в log4j2 выглядят так:
        log.log(Level.INFO, mapMessage);
        log.log(Level.INFO, object);
        log.log(Level.INFO, stringMessage);
        log.log(Level.INFO, marker, mapMessage);
        log.log(Level.INFO, marker, object);
        log.log(Level.INFO, marker, stringMessage);
        log.log(Level.INFO, object, throwable);
        log.log(Level.INFO, stringMessageFormat, args);
        log.log(Level.INFO, stringMessage, throwable);
        log.log(Level.INFO, marker, mapMessage, throwable);
        log.log(Level.INFO, marker, object, throwable);
        log.log(Level.INFO, marker, stringMessageFormat, args);
        log.log(Level.INFO, marker, stringMessage, throwable);
        log.throwing(Level.INFO, throwable);


    }
}
