package com.dto.modelmapper.dto;

import lombok.Data;

@Data
public class UserLocationDto {
    private long userId;
    private String email;
    private String place;
    private Double longitude;
    private Double latitude;
}
