package com.example.accmanager.AccService.AccServiceImpl;

import com.example.accmanager.AccDto.AccDto;
import com.example.accmanager.AccEntity.AccEntity;
import com.example.accmanager.AccMapper.AccMapper;
import com.example.accmanager.AccRepository.AccRepository;
import com.example.accmanager.AccService.AccService;
import com.example.accmanager.NotFound.Exception;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AccServiceImpl implements AccService {
    private AccRepository accRepository;

    public AccServiceImpl(AccRepository accRepository) {
        this.accRepository = accRepository;
    }

    @Override
    public AccDto createAcc(AccDto accDto) {
        AccEntity accEntity = AccMapper.maptoAccEntity(accDto);
        accEntity.setId(UUID.randomUUID());
        AccEntity savedAccEntity = accRepository.save(accEntity);
        return AccMapper.maptoAccDto(savedAccEntity);
    }

    @Override
    public AccDto getAccByid(UUID id) {
        AccEntity accEntity = findAccEntityById(id);
        return AccMapper.maptoAccDto(accEntity);
    }

    @Override
    public List<AccDto> getAllAccs() {
        List<AccEntity> accEntityList = accRepository.findAll();
        return accEntityList.stream()
                .map(AccMapper::maptoAccDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccDto updateAcc(UUID id, AccDto updatedAcc) {
        AccEntity existingEntityAcc = findAccEntityById(id);
        AccEntity updatedEntityAcc = AccMapper.maptoAccEntity(updatedAcc);
        updatedEntityAcc.setId(existingEntityAcc.getId());
        AccEntity savedEntityAcc = accRepository.save(updatedEntityAcc);
        return AccMapper.maptoAccDto(savedEntityAcc);
    }

    @Override
    public void deleteAcc(UUID id) {
        AccEntity accEntity = findAccEntityById(id);
        accRepository.delete(accEntity);
    }

    private AccEntity findAccEntityById(UUID id) {
        return accRepository.findById(id)
                .orElseThrow(() -> new Exception("Account not found"));
    }
}
