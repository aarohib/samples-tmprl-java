package ab.TarotT;
import ab.TarotT.Workflow.Reading;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

import java.io.IOException;

public class OSSStartReading {

    public static void main(String[] args) throws IOException {
        WorkflowServiceStubs startservice = WorkflowServiceStubs.newLocalServiceStubs();

        /*
         * Get a Workflow service client which can be used to start, Signal, and Query Workflow Executions.
         */
        WorkflowClient startclient = WorkflowClient.newInstance(startservice);

        Reading ossworkflow = startclient.newWorkflowStub(Reading.class,
                WorkflowOptions.newBuilder()
                        .setWorkflowId("ReadingforInput")
                        .setTaskQueue("ossTQ")
                        .build());
        //WorkflowClient.start(ossworkflow::getReading); //this is not blocking. Will only block until the server gets the request and return with some wf run id etc.
        String readingResult = ossworkflow.getReading();
        System.out.println(readingResult);
        System.exit(0);

    }
}