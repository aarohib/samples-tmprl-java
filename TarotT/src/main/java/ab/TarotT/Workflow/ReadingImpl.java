package ab.TarotT.Workflow;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;
import ab.TarotT.Activities.GetCard;
import ab.TarotT.Activities.GetName;

import java.io.IOException;
import java.time.Duration;

public class ReadingImpl implements Reading{
    final GetName getNameActivity =
            Workflow.newActivityStub(
                    GetName.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(10)).build());
    final GetCard getCardActivity =
            Workflow.newActivityStub(
                    GetCard.class,
                    ActivityOptions.newBuilder()
                            .setStartToCloseTimeout(Duration.ofSeconds(15))
                            .build());
    @Override
    public String getReading(){
        System.out.println("Start reading");
        //String userName = getNameActivity.getName();
        //String yourCard = getCardActivity.getCard();
        // Printing the read line
        Workflow.sleep(Duration.ofSeconds(30));
        //System.out.println("Hello " + getNameActivity.getName() + ", the card picked for you is: " + getCardActivity.getCard());
        try {
            return "Hello " + getNameActivity.getName() + ", the card picked for you is: " + getCardActivity.getCard();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
