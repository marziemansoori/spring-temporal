package org.example.springtemporal.starter;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import org.example.springtemporal.dto.TravelRequest;
import org.example.springtemporal.workflow.TravelWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Starter will call the Temporal server using gRPC workFlowStub
@Component
public class TravelBookingWorkflowStarter {

    @Autowired
    private WorkflowServiceStubs serviceStubs;


    public void startWorkFlow(TravelRequest travelRequest){
        WorkflowClient client = WorkflowClient.newInstance(serviceStubs);

        TravelWorkflow workflow = client.newWorkflowStub(
                TravelWorkflow.class,
                WorkflowOptions.newBuilder()
                        .setTaskQueue("TRAVEL_TASK_QUEUE")
                        .setWorkflowId("travel_" + travelRequest.getUserId())
                        .build()
        );

        WorkflowClient.start(workflow::bookTrip, travelRequest);
    }


    public void sendConfirmationSignal(String userId) {
        WorkflowClient client = WorkflowClient.newInstance(serviceStubs);

        String workflowId = "travel_" + userId;
        TravelWorkflow workflow = client.newWorkflowStub(TravelWorkflow.class, workflowId);

        workflow.sendConfirmationSignal();
    }
}
