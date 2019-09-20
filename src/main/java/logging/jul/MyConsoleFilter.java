package logging.jul;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

//установим фильтр логов
public class MyConsoleFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        //выводим только логи, начинающиеся с W
        return record.getMessage().startsWith("W");
    }
}
