package com.tsys.virtualizer.handler;

import com.tsys.virtualizer.InqAcctOpt;
import com.tsys.virtualizer.InqAcctOptResponse;
import com.tsys.virtualizer.response.TSYSXMLMessagingSoapInquiryHeader;
import com.tsys.virtualizer.response.TSYSXMLMessagingSoapInquiryResponseBuilder;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TSYSXMLMessagingSoapInquiryHandler {

    @Autowired
    TSYSXMLMessagingSoapInquiryResponseBuilder tsysxmlMessagingSoapInquiryResponseBuilder;

    @Autowired
    TSYSXMLMessagingSoapInquiryHeader tsysxmlMessagingSoapInquiryHeader;

    public InqAcctOptResponse handleService(InqAcctOpt inqAcctOpt) {
        String clientId = tsysxmlMessagingSoapInquiryHeader.getClientId();
        InqAcctOptResponse inqAcctOptResponse = null;
        if(!StringUtils.isEmpty(clientId)) {
            inqAcctOptResponse = tsysxmlMessagingSoapInquiryResponseBuilder.getInqAcctOptResponse(clientId);
        }
        return inqAcctOptResponse;
    }

}
