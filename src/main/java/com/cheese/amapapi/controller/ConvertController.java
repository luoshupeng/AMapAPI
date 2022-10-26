package com.cheese.amapapi.controller;

import com.cheese.amapapi.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Icemap
 * @date 2019-09-09 15:26
 */
@RestController
@RequestMapping("/convert")
public class ConvertController {
    @Autowired
    ConvertService convertService;

    @GetMapping("/convertFrom")
    public String getConvertFrom (Double x, Double y, String type) {
        return convertService.getConvertFromResult(x, y, type);
    }
}
