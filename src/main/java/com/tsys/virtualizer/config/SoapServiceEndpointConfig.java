package com.tsys.virtualizer.config;

import com.tsys.virtualizer.interceptor.SoapInquiryServiceInterceptor;
import com.tsys.virtualizer.service.TSYSXMLMessagingSoapInquiryServiceImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class SoapServiceEndpointConfig {

    @Autowired
    SoapInquiryServiceInterceptor soapInquiryServiceInterceptor;

    @Autowired
    TSYSXMLMessagingSoapInquiryServiceImpl tsysXmlMessagingSoapInquiry;

    @Bean
    public Endpoint endpoint(SpringBus bus) {
        EndpointImpl endpoint = new EndpointImpl(bus, tsysXmlMessagingSoapInquiry);
        endpoint.publish("/inqAcctOptResponse");
        endpoint.getInInterceptors().add(soapInquiryServiceInterceptor);
        return endpoint;
    }
}
