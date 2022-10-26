package com.cheese.amapapi.dao;

import com.cheese.amapapi.util.JSCallUtil;
import com.cheese.amapapi.util.SnowFlakeUtil;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Icemap
 * @date 2019-09-09 15:55
 */
@Component
public class ConvertDao {
    @Autowired
    DataCenter center;
    @Autowired
    SnowFlakeUtil snowFlakeUtil;
    @Autowired
    JSCallUtil jsCallUtil;

    public String getConvertFrom (Double x, Double y, String type) throws InterruptedException {
        String callbackId = snowFlakeUtil.nextId() + "";
        WebClient client = new WebClient();
        return jsCallUtil.callJSFunc(client, center.getConvertPage(client), buildConvertFromJSFunc(callbackId, x, y, type), callbackId);
    }

    private String buildConvertFromJSFunc (String callbackId, Double x, Double y, String type) {
        return "convertFrom(\"" + callbackId + "\"," + x + "," + y + ",\"" + type + "\");";
    }
}
