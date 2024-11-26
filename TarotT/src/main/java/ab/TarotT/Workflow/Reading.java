package ab.TarotT.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface Reading {

    @WorkflowMethod
    String getReading();

}