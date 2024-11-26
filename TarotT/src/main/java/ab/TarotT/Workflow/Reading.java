package ab.TarotT.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

import java.io.IOException;

@WorkflowInterface
public interface Reading {

    @WorkflowMethod
    String getReading() throws IOException;

}