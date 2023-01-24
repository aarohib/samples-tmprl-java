package io.myproject;

import io.myproject.codec.CustomCodecAB;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowClientOptions;
import io.temporal.common.converter.CodecDataConverter;
import io.temporal.common.converter.DefaultDataConverter;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import io.temporal.worker.WorkerOptions;

import java.util.Collections;


public class TemporalWorker {

    //public static final String DEFAULT_TASK_QUEUE = "myTaskQueue"
    public static final WorkflowClient client = WorkflowClient.newInstance(Utils.service(),
            WorkflowClientOptions.newBuilder()
                    .setDataConverter(
                            new CodecDataConverter(
                                    DefaultDataConverter.newDefaultInstance(), Collections.singletonList(new CustomCodecAB())))
                    .setNamespace(Utils.NAMESPACE)
                    .build());
    public static final String TASK_QUEUE = "TemporalTaskQueue";
    public static void main(String[] args) {

        // Create worker factory and a worker
        WorkerFactory factory = WorkerFactory.newInstance(client);
        Worker worker = factory.newWorker(TASK_QUEUE, WorkerOptions.newBuilder().build());

        // Register our workflow and activity with worker
        worker.registerWorkflowImplementationTypes(TemporalWorkflow.class);
        worker.registerActivitiesImplementations(new TemporalActivity());
        factory.start();
    }
}