package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.dtos.ResumeAddDto;
import com.onur.HRMSProject.entities.concretes.dtos.ResumeGetDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {
    Result add(ResumeAddDto resumeDto);

    DataResult<List<ResumeGetDto>> getAll();

    DataResult<List<ResumeGetDto>> findAllByCandidateId(int id);

    Result saveImage(MultipartFile file, int resumeId);
}
