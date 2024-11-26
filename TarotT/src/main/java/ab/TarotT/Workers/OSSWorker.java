package ab.TarotT.Workers;

import ab.TarotT.Activities.GetCardImpl;
import ab.TarotT.Activities.GetNameImpl;
import ab.TarotT.Workflow.ReadingImpl;
import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class OSSWorker {

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();

        final WorkflowClient workerClient = WorkflowClient.newInstance(service);

        // Create worker factory and a worker
        WorkerFactory factory = WorkerFactory.newInstance(workerClient);
        Worker OSSWorker = factory.newWorker("ossTQ");
        // Register workflow with worker
        OSSWorker.registerWorkflowImplementationTypes(ReadingImpl.class);
        OSSWorker.registerActivitiesImplementations(new GetNameImpl());
        OSSWorker.registerActivitiesImplementations(new GetCardImpl());
        //Worker activityWorker = factory.newWorker(ACTIVITY_TASK_QUEUE);
        // Register activity with worker
        //activityWorker.registerActivitiesImplementations(new TemporalActivity());
        factory.start();
    }
}