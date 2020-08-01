package com.auth.jwt

import com.auth.jwt.controller.LoginController
import org.mockito.Mock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post


@AutoConfigureMockMvc
@WebMvcTest
class LoginControllerTest extends Specification {

    @Autowired
    private MockMvc mvc

    //@Mock
    //LoginController loginController


    def "Unity Testing for the Token Generating"() {
        expect:"a string as value for us token "

        mvc.perform(post("/userTokenStatic")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
            .characterEncoding("utf-8")
            .param("user","983482098")
            .param("password","pass123")).andExpect(MockMvcResultMatchers.status().isOk())




        //expect: "a string as value for us token"


        //mvc.perform(post("/userTokenStatic")

        /*
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .characterEncoding("utf-8")
                .param("user" , "983482098")
                .param("password" , "pass123"))
                .andExpect(MockMvcResultMatchers.status().isOk())
        */
    }





}