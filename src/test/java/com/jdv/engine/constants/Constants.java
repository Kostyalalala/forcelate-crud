package com.jdv.engine.constants;

import com.jdv.engine.db.model.User;
import com.jdv.engine.dto.Transfromer;
import com.jdv.engine.dto.UserDTO;

public class Constants {
    public final static Integer AGE = 18;
    public final static String NAME = "Tom";
    public final static User TOM_OLDER = User.builder().name(NAME).age(19).build();
    public final static User TOM_YOUNGER = User.builder().name(NAME).age(15).build();
    public final static UserDTO TOM_OLDER_DTO = Transfromer.UserEntityToDTO(TOM_OLDER);
    public final static UserDTO TOM_YOUNGER_DTO = Transfromer.UserEntityToDTO(TOM_YOUNGER);

}
