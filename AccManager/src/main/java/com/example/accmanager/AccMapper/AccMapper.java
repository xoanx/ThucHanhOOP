package com.example.accmanager.AccMapper;

import com.example.accmanager.AccDto.AccDto;
import com.example.accmanager.AccEntity.AccEntity;

public class AccMapper {
    public static AccDto maptoAccDto(AccEntity accEntity) {
        return new AccDto(
                accEntity.getId(),
                accEntity.getUsername(),
                accEntity.getPasswd(),
                accEntity.getEmail()
        );
    }
    public static AccEntity maptoAccEntity(AccDto accDto) {
        return new AccEntity(
                accDto.getId(),
                accDto.getUsername(),
                accDto.getPasswd(),
                accDto.getEmail()
        );
    }
}
