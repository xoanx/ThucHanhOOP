package com.example.accmanager.AccService;

import com.example.accmanager.AccDto.AccDto;

import java.util.List;
import java.util.UUID;

public interface AccService {
    AccDto createAcc(AccDto accDto);
    AccDto getAccByid(UUID id);
    List<AccDto> getAllAccs();
    AccDto updateAcc(UUID id, AccDto updatedAcc);
    void deleteAcc(UUID id);
}
