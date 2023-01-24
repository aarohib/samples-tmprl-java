package io.myproject;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;

public class TemporalWorkflow implements TemporalWorkflowInterface {

    /**
     * Define the TemporalActivities stub.
     * Activity stubs are proxies for activity invocations that
     * are executed outside of the workflow thread on the activity worker, that can be on a
     * different host. Temporal is going to dispatch the activity results back to the workflow and
     * unblock the stub as soon as activity is completed on the activity worker.
     *
     * <p>In the {@link ActivityOptions} definition the "setStartToCloseTimeout" option sets the
     * overall timeout that our workflow is willing to wait for activity to complete.
     */
    private final TemporalActivityInterface activity =
        Workflow.newActivityStub(
            TemporalActivityInterface.class,
            ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(2)).build());

    @Override
    public String getGreeting(String name) {
        // This is a blocking call that returns only after the activity has completed.
        Workflow.sleep(Duration.ofSeconds(30));
        return activity.greet("Hello", name);
   }
}
