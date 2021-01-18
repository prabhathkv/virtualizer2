package com.tsys.virtualizer.service;

import com.tsys.virtualizer.InqAcctOpt;
import com.tsys.virtualizer.InqAcctOptResponse;
import com.tsys.virtualizer.ObjectFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(targetNamespace = "urn://tsys.com/xmlmessaging/CH", name = "TSYSXMLMessagingSoapInquiry")
@XmlSeeAlso({ObjectFactory.class})
public interface TSYSXMLMessagingSoapInquiryService {

    @WebMethod(action = "urn://tsys.com/xmlmessaging/CH/inqAcctOpt")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "inqAcctOptResponse", targetNamespace = "urn://tsys.com/xmlmessaging/CH", partName = "parameters")
    public InqAcctOptResponse inqAcctOpt(
            @WebParam(partName = "parameters", name = "inqAcctOpt", targetNamespace = "urn://tsys.com/xmlmessaging/CH")
                    InqAcctOpt parameters
    );

}
