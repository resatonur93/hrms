package com.onur.HRMSProject.business.concretes;

import com.onur.HRMSProject.business.abstracts.ResumeService;
import com.onur.HRMSProject.core.cloudinary.CloudinaryService;
import com.onur.HRMSProject.core.dtoConvertor.DtoConverterService;
import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;
import com.onur.HRMSProject.core.results.SuccessDataResult;
import com.onur.HRMSProject.core.results.SuccessResult;
import com.onur.HRMSProject.dataAcces.abstracts.ResumeDao;
import com.onur.HRMSProject.entities.concretes.Resume;
import com.onur.HRMSProject.entities.concretes.dtos.ResumeAddDto;
import com.onur.HRMSProject.entities.concretes.dtos.ResumeGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private CloudinaryService cloudinaryService;
    private DtoConverterService dtoConverterService;


    @Autowired
    public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService, DtoConverterService dtoConverterService) {
        super();
        this.resumeDao = resumeDao;
        this.cloudinaryService = cloudinaryService;
        this.dtoConverterService = dtoConverterService;

    }


    @Override
    public Result add(ResumeAddDto resumeDto) {
//		if (resume.getLanguages() != null) {
//			resume.getLanguages().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getEducation() != null) {
//			resume.getEducation().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getTechnologies() != null) {
//			resume.getTechnologies().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getJobExperiences() != null) {
//			resume.getJobExperiences().forEach(lang -> lang.setResume(resume));
//		}

        resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
        return new SuccessResult("Kayıt Başarılı");

    }


    @Override
    public DataResult<List<ResumeGetDto>> getAll() {
        return new SuccessDataResult<List<ResumeGetDto>>
                (dtoConverterService.dtoConverter
                        (resumeDao.findAll(), ResumeGetDto.class)
                        ,"Data Listelendi");

    }

    @Override
    public Result saveImage(MultipartFile file, int resumeId) {


        @SuppressWarnings("unchecked")
        Map<String, String> uploader = (Map<String, String>)
                cloudinaryService.save(file).getData();
        String imageUrl= uploader.get("url");
        Resume Cv = resumeDao.getOne(resumeId);
        Cv.setPhoto(imageUrl);
        resumeDao.save(Cv);
        return new SuccessResult("Kayıt Başarılı");

    }


    @Override
    public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id) {
        return new SuccessDataResult<List<ResumeGetDto>>
                (dtoConverterService.dtoConverter
                        (resumeDao.findAllByCandidateId(id), ResumeGetDto.class)
                        ,"Data Listelendi");
    }


}