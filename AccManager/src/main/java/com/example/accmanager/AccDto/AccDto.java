package com.example.accmanager.AccDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccDto {
    private UUID id;
    private String username;
    private String passwd;
    private String email;
}
