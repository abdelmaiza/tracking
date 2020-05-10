package com.cirta.soft.tracking.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class PeopleHealthIndicator implements HealthIndicator {
    private static final String MESSAGEKEY = "People service";

    @Override
    public Health health() {
        if(!isRunningServicePeopleService()){
            return Health.down().withDetail(MESSAGEKEY, "Not Available").build();
        }
        return Health.up().withDetail(MESSAGEKEY, "Available").build();
    }

    private boolean isRunningServicePeopleService(){
        boolean isRunning = false;

        return isRunning;
    }
}
