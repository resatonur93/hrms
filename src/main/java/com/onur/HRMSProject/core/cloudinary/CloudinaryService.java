package com.onur.HRMSProject.core.cloudinary;

import com.onur.HRMSProject.core.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    DataResult<?> save(MultipartFile file);
}
