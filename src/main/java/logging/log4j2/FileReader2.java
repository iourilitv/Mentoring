package logging.log4j2;

import logging.log4j.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The next version of log4j. See log4j2 dependency in pom.xml
 */
public class FileReader2 implements Reader{
    final static Logger logger = LogManager.getLogger(FileReader2.class);

    @Override
    public String read() {
        String message = "";
        try {
            //TODO choose getSystemResource() with URL returning!
            URI url = ClassLoader.getSystemResource("message.txt").toURI();
            logger.info("File URL has been gotten");

            byte[] fileBites = Files.readAllBytes(Paths.get(url));
            logger.info("Byte array from the file has been gotten");

            message = new String(fileBites);
            logger.info("The message from the file has been gotten");

        } catch (URISyntaxException | NullPointerException | IOException e) {
            //e.printStackTrace();
            logger.error(e);
        }
        return message;
    }
}
