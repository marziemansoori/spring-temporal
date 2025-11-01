package org.example.springtemporal.workflow;

import io.temporal.workflow.SignalMethod;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;
import org.example.springtemporal.dto.TravelRequest;

@WorkflowInterface
public interface TravelWorkflow {

    @WorkflowMethod
    void bookTrip(TravelRequest travelRequest);


    @SignalMethod
    public void sendConfirmationSignal();

}
