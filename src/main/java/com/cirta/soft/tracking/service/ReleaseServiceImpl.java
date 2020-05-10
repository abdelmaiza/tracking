package com.cirta.soft.tracking.service;

import com.cirta.soft.tracking.entity.Release;
import com.cirta.soft.tracking.repository.ReleaseRepository;
import org.springframework.stereotype.Service;


@Service
public class ReleaseServiceImpl implements ReleaseService {

    private final ReleaseRepository releaseRepository;

    public ReleaseServiceImpl(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    @Override
    public Iterable<Release> listReleases() {
        return releaseRepository.findAll();
    }

}
