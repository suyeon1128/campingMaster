package com.example.campingmaster.api.member.dto;

import com.google.gson.annotations.SerializedName;

public class SignUpResponseDto {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
