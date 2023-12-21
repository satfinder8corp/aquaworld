package com.naumencourse.aquaworld.services;

import com.naumencourse.aquaworld.dto.AquaristDTO;
import com.naumencourse.aquaworld.entities.Aquarist;
import com.naumencourse.aquaworld.entities.Role;
import com.naumencourse.aquaworld.exceptions.AquaristAlreadyExist;
import com.naumencourse.aquaworld.exceptions.AquaristNotFoundException;
import com.naumencourse.aquaworld.mapper.AquaristMapper;
import com.naumencourse.aquaworld.repositories.AquaristRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AquaristServiceImpl implements AquaristService/*, UserDetailsService*/ {

    public final AquaristRepository aquaristRepository;
    public final AquaristMapper aquaristMapper;

    public AquaristDTO createAquarist(Aquarist aquarist) throws AquaristAlreadyExist {
        if (!aquaristRepository.findByEmail(aquarist.getEmail()).isEmpty()) {
           throw new AquaristAlreadyExist("Пользователь с таким адресом почты уже зарегистрирован");
        }
        aquarist.setDateOfRegistry(LocalDateTime.now());
        aquarist.getRole().add(Role.USER);
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

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Aquarist myAquarist = aquaristRepository.findAquaristByName(username);
//        return new User(
//                myAquarist.getName(),
//                myAquarist.getPassword(),
//                mapRolesToAthorities(myAquarist.getRole()));
//    }
//
//    private List<? extends GrantedAuthority> mapRolesToAthorities(Set<Role> roles) {
//        return roles.stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.name())).collect(Collectors.toList());
//    }

    public Aquarist setRole(UUID aquaristId, Role role) throws AquaristNotFoundException {
        Aquarist aquarist = aquaristRepository.findAquaristById(aquaristId);
        if (aquarist == null) {
            throw new AquaristNotFoundException("Не найден пользователь c id = " + aquaristId);
        }
        aquarist.getRole().add(role);
        aquaristRepository.save(aquarist);
        return aquarist;
    }
}

