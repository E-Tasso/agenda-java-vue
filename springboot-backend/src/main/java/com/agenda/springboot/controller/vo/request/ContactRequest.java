package com.agenda.springboot.controller.vo.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactRequest {
    @JsonProperty
    private String name;
    @JsonProperty
    private String email;
    @JsonProperty
    private String phone;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}
