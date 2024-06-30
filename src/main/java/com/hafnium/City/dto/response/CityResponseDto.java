package com.hafnium.City.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CityResponseDto {
    private String cityName;
    private Date createdDate;
}
