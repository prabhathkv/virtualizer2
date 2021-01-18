package com.tsys.virtualizer.config;

import com.tsys.virtualizer.interceptor.SoapInquiryServiceInterceptor;
import com.tsys.virtualizer.service.TSYSXMLMessagingSoapInquiryServiceImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.jms.JMSConfigFeature;
import org.apache.cxf.transport.jms.JMSConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;
import javax.xml.ws.Endpoint;

@Configuration
public class JmsSoapEndpointsConfig {

    @Autowired
    SoapInquiryServiceInterceptor soapInquiryServiceInterceptor;

    @Autowired
    TSYSXMLMessagingSoapInquiryServiceImpl tsysXmlMessagingSoapInquiry;

    @Bean
    public Endpoint jmsEndpoint(SpringBus bus, JMSConfigFeature jmsConfigFeature) {
        EndpointImpl endpoint = new EndpointImpl(bus, tsysXmlMessagingSoapInquiry);
        endpoint.getFeatures().add(jmsConfigFeature);
        endpoint.publish("jms://");
        return endpoint;
    }

    @Bean
    public JMSConfigFeature jmsConfigFeature(ConnectionFactory mqConnectionFactory) {
        JMSConfigFeature feature = new JMSConfigFeature();
        JMSConfiguration jmsConfiguration = new JMSConfiguration();
        jmsConfiguration.setConnectionFactory(mqConnectionFactory);
        jmsConfiguration.setTargetDestination("iib.req.queue");
        jmsConfiguration.setMessageType("text");
        feature.setJmsConfig(jmsConfiguration);
        return feature;
    }
}