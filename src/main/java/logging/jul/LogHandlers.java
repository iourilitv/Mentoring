package logging.jul;

import java.io.IOException;
import java.util.logging.*;

/**
 * Логгирование с помощью встроенного java логера.
 * Источник: https://www.youtube.com/watch?v=e1Balqbin84
 *
 */
public class LogHandlers {
    private static final Logger logger = Logger.getLogger(LogHandlers.class.getName());

    public static void main(String[] args) throws IOException {

        //хандлер для консоли
        Handler consoleHandler = new ConsoleHandler();
        //установим фильтр логов
        consoleHandler.setFilter(new MyFilter());
        //установим форматера логов
        consoleHandler.setFormatter(new MyFormatter());

        //хандлер для файла
        //в параметр можно передать паттерн, описав напрямую или в виде объекта паттерна
        //Pattern pattern = Pattern("", 1); забыл синтаксис
        //%h - указывает на домашнюю директорию, там может лежать файл лога;
        //%u - sequence(последовательность)
        Handler fileHandler = new FileHandler("%h/MyJavaLog.log");

        //хендлер для какого-то потока(чтения или записи, например)
        //Handler streamHandler = new StreamHandler();
        //хандлер соединения
        //Handler socketHandler = new SocketHandler();
        //хендлер для вывода в память
        //Handler memoryHandler = new MemoryHandler();

        //устанавливаем хендлер для логера
        //отключаем хандлер по умолчанию, чтобы не выводить в консоль!
        logger.setUseParentHandlers(false);
        //устанавливаем логеру хендлер - пишем в файл
        logger.addHandler(fileHandler);
        //устанавливаем логеру свой хендлер для консоли
        logger.addHandler(consoleHandler);

        logger.info("INFO");
        //сен 19, 2019 2:25:21 PM logging.LogHandlers main
        //INFO: INFO

        logger.info("Info max");
    }

    //установим фильтр логов
    static class MyFilter implements Filter{

        @Override
        public boolean isLoggable(LogRecord record) {
            //выводим только логи, оканчивающиеся на max
            return record.getMessage().endsWith("max");
        }
    }

    //изменим формат представления лога
    static class MyFormatter extends Formatter{

        @Override
        public String format(LogRecord record) {
            return record.getLevel() + ": " + record.getMessage();
        }
    }

}

