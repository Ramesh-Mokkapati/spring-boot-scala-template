package com.github.rameshmokkapati.springbootscalatemplate.JWTManager.controller

import com.github.rameshmokkapati.springbootscalatemplate.JWTManager.model.{APIToken, Client}
import io.jsonwebtoken.{Jwts, SignatureAlgorithm}
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, RequestMapping, RestController}

import java.util.Date

@RestController
@RequestMapping(Array("/authorize"))
class LoginController {
  //TODO: Complete the client validation before Token generation and Change the Encoded Key "C8#&*Intuition*WorkFlowService211221"
  @PostMapping
  def login(@RequestBody client: Client) = new ResponseEntity[APIToken](
        new APIToken(Jwts.builder.setSubject(client.getClientName).claim("roles", "user").setIssuedAt(new Date)
          .signWith(SignatureAlgorithm.HS256, "C8#&*Intuition*WorkFlowService211221").compact), HttpStatus.OK)
}
