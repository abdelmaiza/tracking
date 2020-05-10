package com.cirta.soft.tracking.service;

import com.cirta.soft.tracking.entity.Application;

public interface ApplicationService {
    Iterable<Application> listApplications();
    Application findApplication(long id);
}


