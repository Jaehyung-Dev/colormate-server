package com.jh.colormateserver.service;

import com.jh.colormateserver.dto.CustomUserDetails;
import com.jh.colormateserver.entity.User;
import com.jh.colormateserver.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if(user != null) {
            return new CustomUserDetails(user);
        }
        throw new UsernameNotFoundException("해당 이메일이 존재하지 않습니다: " + email);
    }
}
