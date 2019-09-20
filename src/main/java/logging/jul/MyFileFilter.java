package logging.jul;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

//установим фильтр логов
public class MyFileFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        //выводим только логи, начинающиеся с F
        return record.getMessage().startsWith("F");
    }
}
