package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.AquaristDTO;
import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.exceptions.AquaristAlreadyExist;
import com.naumencourse.aquaworld.exceptions.AquaristNotFoundException;
import com.naumencourse.aquaworld.mapper.AquaristMapper;
import com.naumencourse.aquaworld.repositories.AquaristRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AquaristServiceImpl implements AquaristService {

    public final AquaristRepository aquaristRepository;
    public final AquaristMapper aquaristMapper;

    public AquaristDTO createAquarist(Aquarist aquarist) throws AquaristAlreadyExist {
        if (!aquaristRepository.findByEmail(aquarist.getEmail()).isEmpty()) {
           throw new AquaristAlreadyExist("Пользователь с таким адресом почты уже зарегистрирован");
        }
        aquarist.setDateOfRegistry(LocalDateTime.now());
        return aquaristMapper.aquaristToAquaristDTO(aquaristRepository.save(aquarist));
    }

    public List<AquaristDTO> getAll() throws AquaristNotFoundException {
        List<Aquarist> aquaristList = aquaristRepository.findAll();
        if (aquaristList.isEmpty()) {
            throw new AquaristNotFoundException("Не найден ни один пользователь");
        }
        return aquaristList.stream().map(aquaristMapper::aquaristToAquaristDTO).toList();
    }

    public UUID deleteAquaristById(UUID aquaristId) throws AquaristNotFoundException {
        if (aquaristRepository.findById(aquaristId).isEmpty()) {
            throw new AquaristNotFoundException("Пользователь с id = " + aquaristId + " не найден");
        }
        aquaristRepository.deleteById(aquaristId);
        return aquaristId;
    }

}

