package ab.TarotT.Activities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetNameImpl implements GetName{

    @Override
    public String getName() throws IOException {
        // Enter data using BufferReader
        //mocking buffer reader
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        // Reading data using readLine
        //System.out.println("Enter your name:");
        String name;
        try {
            System.out.println("Enter your name:");
            name = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
    }
}
