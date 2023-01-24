package io.myproject;

import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class TemporalStarter {
    public static void main(String[] args) {

        // Create the workflow stub
        TemporalWorkflowInterface workflow =
                TemporalWorker.client.newWorkflowStub(
                        TemporalWorkflowInterface.class,
                        WorkflowOptions.newBuilder()
                                .setTaskQueue(TemporalWorker.TASK_QUEUE)
                                .build());

        String greeting = workflow.getGreeting("Prudence");

        System.out.println("Greeting: " + greeting);
        System.exit(0);
    }
}
