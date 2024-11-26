package ab.TarotT.Activities;
import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

import java.io.IOException;

@ActivityInterface
public interface GetName {
    @ActivityMethod
    String getName() throws IOException;
}
