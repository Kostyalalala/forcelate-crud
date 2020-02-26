package com.jdv.engine.constants;

import com.jdv.engine.db.model.User;
import com.jdv.engine.dto.Transfromer;
import com.jdv.engine.dto.UserDTO;

public class Constants {
    public static final Integer AGE = 18;
    public static final String NAME = "Tom";
    public static final User TOM_OLDER = User.builder().name(NAME).age(19).build();
    public static final User TOM_YOUNGER = User.builder().name(NAME).age(15).build();
    public static final UserDTO TOM_OLDER_DTO = Transfromer.UserEntityToDTO(TOM_OLDER);
    public static final UserDTO TOM_YOUNGER_DTO = Transfromer.UserEntityToDTO(TOM_YOUNGER);    
    public static final String JWT_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkQXQiOjE1ODI2NDIzMDksInVzZXJJZCI6IjUwOTk5MTg3LWUxMTAtNDNiOS04ZTMzLTcyNDhlOGE4NzU4MiJ9.4jjBuHKjzOxEaallO_JY9ErHsJT-mwS_DZ-RyM68XCEsipU4FjYmraMnwOI15vW3xXjaOnPdfoNnsnxYTwjVqQ";
    public static final String AUTHORIZATION = "Authorization";
}
