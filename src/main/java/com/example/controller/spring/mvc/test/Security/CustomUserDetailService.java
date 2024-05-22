package com.example.controller.spring.mvc.test.Security;

import com.example.controller.spring.mvc.test.doa.Entities.UserEntity;
import com.example.controller.spring.mvc.test.doa.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailService  implements UserDetailsService {


    @Autowired
 private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username", username);
        Optional<UserEntity> user = this.userRepo.findByusername(username);
        user.orElseThrow(()-> new UsernameNotFoundException("user not Found!"));
        log.info("user", user.get());

        String password = user.get().getPassword();
        String role = user.get().getRole();

        List <GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(role));


        return new CustomUserDetails(username , password, roles);
    }
}
