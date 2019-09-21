package logging.log4j2;

import logging.log4j.FileReader;
import logging.log4j.Reader;

public class App2 {

    public static void main(String[] args) {
        Reader reader = new FileReader();
        String message = reader.read();
        System.out.println(message);
    }
}
