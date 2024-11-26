package ab.TarotT.Activities;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GetCardImpl implements GetCard {

    @Override
    public String getCard() {
        File tarotfile = new File("src/main/resources/TarotCardsList.txt");
        String yourTarotCard;
        try{
            try (RandomAccessFile randomTStringPick = new RandomAccessFile(tarotfile, "r")) {
                final long randomLocation = (long) (Math.random() * randomTStringPick.length());
                randomTStringPick.seek(randomLocation);
                randomTStringPick.readLine();
                yourTarotCard = randomTStringPick.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return yourTarotCard;

    }

}
