package logging.log4j;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements Reader{
    final static Logger logger = Logger.getLogger(FileReader.class);

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
