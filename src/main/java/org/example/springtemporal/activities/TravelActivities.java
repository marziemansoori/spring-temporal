package org.example.springtemporal.activities;

import io.temporal.activity.ActivityInterface;
import org.example.springtemporal.dto.TravelRequest;

@ActivityInterface
public interface TravelActivities {

    public void bookFlight(TravelRequest travelRequest);

    public void cancelFlight(TravelRequest travelRequest);

    public void bookHotel(TravelRequest travelRequest);

    public void cancelHotel(TravelRequest travelRequest);

    public void arrangeTransport(TravelRequest travelRequest);

    public void cancelTransport(TravelRequest travelRequest);

    public void cancelBooking(TravelRequest travelRequest);

    public void confirmBooking(TravelRequest travelRequest);
}
