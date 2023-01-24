package io.myproject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Random;

public class TemporalActivity implements TemporalActivityInterface {

    @Override
    public String greet(String greeting, String name) {
        Random randomNo = new Random();
        int upperbound = 370105;
        int lineNumber = randomNo.nextInt(upperbound);
        String response = null;
        try {
            //response = Files.readAllLines(Paths.get("/Users/aarohi/data-converter-AB-3/src/main/resources/words.txt")).get(lineNumber);
            URL resource = getClass().getClassLoader().getResource("words.txt");
            response = Files.readAllLines(new File(resource.toURI()).toPath()).get(lineNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return response + " " + name + "!";
    }
}
