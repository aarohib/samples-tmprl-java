package io.myproject;

import io.temporal.client.WorkflowOptions;
import io.temporal.testing.TestWorkflowRule;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

public class TemporalWorkflowTest {

    @Rule
    public TestWorkflowRule testWorkflowRule =
            TestWorkflowRule.newBuilder()
                    .setWorkflowTypes(TemporalWorkflow.class)
                    .setDoNotStart(true)
                    .build();

    @Test
    public void testActivity() {

        testWorkflowRule.getWorker().registerActivitiesImplementations(new TemporalActivity());
        testWorkflowRule.getTestEnvironment().start();

        // Get a workflow stub using the same task queue the worker uses.
        TemporalWorkflowInterface workflow =
                testWorkflowRule
                        .getWorkflowClient()
                        .newWorkflowStub(
                                TemporalWorkflowInterface.class,
                                WorkflowOptions.newBuilder().setTaskQueue(testWorkflowRule.getTaskQueue()).build());
        // Execute a workflow waiting for it to complete.
        String greeting = workflow.getGreeting("World");
        assertEquals("Hello World!", greeting);

        testWorkflowRule.getTestEnvironment().shutdown();
    }

    @Test
    public void testMockedActivity() {
        // withoutAnnotations() is required to stop Mockito from copying
        // method-level annotations from the GreetingActivities interface
        TemporalActivityInterface activities =
                mock(TemporalActivityInterface.class, withSettings().withoutAnnotations());
        when(activities.greet("Hello", "World")).thenReturn("Hello World!");
        testWorkflowRule.getWorker().registerActivitiesImplementations(activities);
        testWorkflowRule.getTestEnvironment().start();

        // Get a workflow stub using the same task queue the worker uses.
        TemporalWorkflowInterface workflow =
                testWorkflowRule
                        .getWorkflowClient()
                        .newWorkflowStub(
                                TemporalWorkflowInterface.class,
                                WorkflowOptions.newBuilder().setTaskQueue(testWorkflowRule.getTaskQueue()).build());
        // Execute a workflow waiting for it to complete.
        String greeting = workflow.getGreeting("World");
        assertEquals("Hello World!", greeting);

        testWorkflowRule.getTestEnvironment().shutdown();
    }
}