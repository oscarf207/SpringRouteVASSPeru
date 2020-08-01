package com.auth.jwt.controller;

import java.util.Date;
import java.util.List;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.jwt.model.Usuario;
//import com.auth.jwt.service.IUsuarioService;
import security.model.request.User;

@RestController
public class LoginController {

    ////////Static Method for userToken
    @PostMapping("userTokenStatic")       //user
    public User login2(@RequestParam("phone") String phoneUser, @RequestParam("password") String pwd) { //User

        User userOut2 = new User(); //User
        String token = getJWTToken(phoneUser); // se genera el token
        userOut2.setPhone(phoneUser);
        userOut2.setToken(token);
        userOut2.setPassword(pwd);

        return userOut2;
    }

    private String getJWTToken(String phoneUser) {
        String secretKey = "VASS2020Key";
        String token = Jwts
                .builder()
                .setId("softeekJWT")
                .setSubject(phoneUser)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 6000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        System.out.println("TOKEN GENERADO :::: "  + token);
        return "Bearer " + token;

    }

    //@Autowired
    //private IUsuarioService US01;//UserDB
    ////////Dynamic Method for userToken which filter with a list
    /*
    @PostMapping("userToken")       //user
    public ResponseEntity login(@RequestParam("phone") String phoneUser, @RequestParam("password") String pwd) { //User
        List<Usuario> listUsuario = US01.listarUsuarios(); //UserDB
        User userOut = new User(); //User

        for(Usuario usa:listUsuario){ //UserDB usa recorre DB
            if ( usa.getPhone().equals(phoneUser) && usa.getPassword().equals(pwd)) { //UserDB usa toma cada valor del DB y verifica la igualdad con User
                String token = getJWTToken(phoneUser); // se genera el token
                User userTemp = new User(); // inicializamos un User temporal
                userTemp.setPhone(phoneUser);
                userTemp.setToken(token);
                userTemp.setPassword(pwd);
                userOut = userTemp;
            }
        }
        ResponseEntity<User> response = new ResponseEntity<User>(userOut, HttpStatus.BAD_GATEWAY);

        return response;
    }
    */

}

