package com.tsys.virtualizer.response;

import com.tsys.virtualizer.InqAcctOptResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TSYSXMLMessagingSoapInquiryResponseBuilder {

    private static HashMap<String, InqAcctOptResponse> inqAcctOptResponseMap
            = new HashMap<>();
    static {
        inqAcctOptResponseMap.put("1", getCHInqAcctOptResponse());
        inqAcctOptResponseMap.put("2", getCCInqAcctOptResponse());
    }

    //Mock the response for Consumer
    public static InqAcctOptResponse getCHInqAcctOptResponse() {
        return new InqAcctOptResponse();
    }

    //Mock the response for Commercial
    public static InqAcctOptResponse getCCInqAcctOptResponse() {
        return new InqAcctOptResponse();
    }

    public InqAcctOptResponse getInqAcctOptResponse(String clientId) {
        return inqAcctOptResponseMap.get(clientId);
    }

}
