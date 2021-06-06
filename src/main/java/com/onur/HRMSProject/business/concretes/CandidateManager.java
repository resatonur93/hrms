package com.onur.HRMSProject.business.concretes;

import com.onur.HRMSProject.business.abstracts.CandidateService;
import com.onur.HRMSProject.business.abstracts.FieldService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private FieldService<Candidate> controllerService;

    @Autowired
    public CandidateManager(FieldService<Candidate> controllerService) {
        super();
        this.controllerService = controllerService;
    }



    @Override
    public DataResult<List<Candidate>> getAll() {
        return null;
    }

    @Override
    public Result add(Candidate candidate) {
        return null;
    }
}
