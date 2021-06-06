package com.onur.HRMSProject.business.abstracts;

import com.onur.HRMSProject.core.results.DataResult;
import com.onur.HRMSProject.core.results.Result;

import java.util.List;

public interface FieldService<T> {

    Result verifyData(T data);
    DataResult<List<T>> getAll();
}
