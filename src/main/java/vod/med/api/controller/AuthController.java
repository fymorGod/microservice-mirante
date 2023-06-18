package vod.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vod.med.api.domain.user.AuthDTO;
import vod.med.api.domain.user.User;
import vod.med.api.infra.security.TokenJWT;
import vod.med.api.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid AuthDTO authDTO){
        var AuthToken = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password());
        var authentication = manager.authenticate(AuthToken);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(new TokenJWT(tokenJWT));
    }
}
