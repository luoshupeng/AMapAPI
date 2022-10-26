package com.cheese.amapapi.service;

import com.cheese.amapapi.dao.ConvertDao;
import com.cheese.amapapi.exception.JSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Icemap
 * @date 2019-09-09 16:04
 */
@Service
public class ConvertService {
    @Autowired
    ConvertDao convertDao;


    public String getConvertFromResult (Double x, Double y, String type) {
        try {
            return convertDao.getConvertFrom(x, y, type);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(new JSException(e.getMessage()));
        }
    }
}
