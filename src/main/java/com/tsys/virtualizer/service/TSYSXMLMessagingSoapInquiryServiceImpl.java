package com.tsys.virtualizer.service;

import com.tsys.virtualizer.InqAcctOpt;
import com.tsys.virtualizer.InqAcctOptResponse;
import com.tsys.virtualizer.handler.TSYSXMLMessagingSoapInquiryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@Component
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class TSYSXMLMessagingSoapInquiryServiceImpl implements TSYSXMLMessagingSoapInquiryService {

    @Autowired
    TSYSXMLMessagingSoapInquiryHandler tsysxmlMessagingSoapInquiryHandler;

    @Override
    public InqAcctOptResponse inqAcctOpt(InqAcctOpt inqAcctOpt) {
        return tsysxmlMessagingSoapInquiryHandler.handleService(inqAcctOpt);
    }

}
