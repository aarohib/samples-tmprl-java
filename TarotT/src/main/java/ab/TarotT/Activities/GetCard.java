package ab.TarotT.Activities;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.io.File;

@ActivityInterface
public interface GetCard {
    @ActivityMethod
    String getCard();
}