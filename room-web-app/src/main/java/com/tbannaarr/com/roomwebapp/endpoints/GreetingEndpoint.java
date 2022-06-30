package com.tbannaarr.com.roomwebapp.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="greeting")
public class GreetingEndpoint {
    //if multiOperation u can choose -> Spring Document them well
    @ReadOperation
    public String getGreeting(){
        return "Hello from actuator";
    }
}
