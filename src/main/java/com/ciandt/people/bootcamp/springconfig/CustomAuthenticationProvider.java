package com.ciandt.people.bootcamp.springconfig;

//import com.ciandt.people.bootcamp.cleanarch.businessrule.usecase.FindUserByLoginAndPasswordUC;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Optional;
//
//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//    public static final String INVALID_USER = "invalid user";
//    public static final String CLIENT = "CLIENT";
//    @Autowired
//    private final FindUserByLoginAndPasswordUC findUserByLoginAndPasswordUC;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String email = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        Optional.of(findUserByLoginAndPasswordUC.execute(email, password)).get()
//                .orElseThrow(() -> new UsernameNotFoundException(INVALID_USER));
//
//        return new UsernamePasswordAuthenticationToken(email, password,
//                Arrays.asList(new SimpleGrantedAuthority(CLIENT)));
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
