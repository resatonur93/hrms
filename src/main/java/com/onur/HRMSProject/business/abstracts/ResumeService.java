package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.entities.concretes.Resume;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    Result add(Resume resume);
    Result saveImage(MultipartFile file,int resumeId);
}
