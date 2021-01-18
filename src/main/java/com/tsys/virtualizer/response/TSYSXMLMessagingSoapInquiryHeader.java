package com.tsys.virtualizer.response;

import org.springframework.stereotype.Component;

@Component
public class TSYSXMLMessagingSoapInquiryHeader {

    private String clientId;

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

}
