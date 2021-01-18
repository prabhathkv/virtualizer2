package com.tsys.virtualizer.interceptor;

import com.tsys.virtualizer.response.TSYSXMLMessagingSoapInquiryHeader;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.namespace.QName;

@Component
public class SoapInquiryServiceInterceptor extends AbstractSoapInterceptor {

    @Autowired
    TSYSXMLMessagingSoapInquiryHeader tsysxmlMessagingSoapInquiryHeader;

    public SoapInquiryServiceInterceptor() {
        super(Phase.USER_PROTOCOL);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        QName qName = new QName("urn://tsys.com/xmlmessaging/CH", "TSYSprofileInq");
        SoapHeader soapHeader = (SoapHeader) message.getHeader(qName);
        //get the actual Object TSYSprofileInq(TSYSprofileType) instead of directly reading the clientID
        String clientId = getClientId(soapHeader);
        tsysxmlMessagingSoapInquiryHeader.setClientId(clientId);
    }

    public String getClientId(SoapHeader soapHeader) {
        Element headerElement = (Element) soapHeader.getObject();
        NodeList clientIdNode = headerElement.getElementsByTagNameNS("*", "clientID");
        String clientId = clientIdNode.item(0).getChildNodes().item(0).getNodeValue();
        return clientId;
    }

    //write a method for handling Soap-Fault
}
