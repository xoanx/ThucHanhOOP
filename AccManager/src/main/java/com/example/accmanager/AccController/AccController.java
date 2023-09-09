package com.example.accmanager.AccController;

import com.example.accmanager.AccDto.AccDto;
import com.example.accmanager.AccService.AccService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccController {
    private final AccService accService;

    public AccController(AccService accService) {
        this.accService = accService;
    }

    @PostMapping
    public ResponseEntity<AccDto> createAcc(@RequestBody AccDto accDto) {
        AccDto createdAcc = accService.createAcc(accDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAcc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccDto> getAccById(@PathVariable UUID id) {
        AccDto accDto = accService.getAccByid(id);
        return ResponseEntity.ok(accDto);
    }

    @GetMapping
    public ResponseEntity<List<AccDto>> getAllAccs() {
        List<AccDto> accDtoList = accService.getAllAccs();
        return ResponseEntity.ok(accDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccDto> updateAcc(@PathVariable UUID id, @RequestBody AccDto updatedAcc) {
        AccDto updatedDto = accService.updateAcc(id, updatedAcc);
        return ResponseEntity.ok(updatedDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAcc(@PathVariable UUID id) {
        accService.deleteAcc(id);
        return ResponseEntity.noContent().build();
    }
}
