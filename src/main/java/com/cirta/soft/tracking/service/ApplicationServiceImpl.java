package com.cirta.soft.tracking.service;

import com.cirta.soft.tracking.entity.Application;
import com.cirta.soft.tracking.exception.ApplicationNotFoundException;
import com.cirta.soft.tracking.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id) {
        final Optional<Application> optionalApplication = applicationRepository.findById(id);
        if (optionalApplication.isPresent()) {
            return optionalApplication.get();
        } else {
            throw new ApplicationNotFoundException("Application not found" , id);
        }
    }


}
