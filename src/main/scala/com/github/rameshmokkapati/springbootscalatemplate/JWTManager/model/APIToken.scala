package com.github.rameshmokkapati.springbootscalatemplate.JWTManager.model

import java.io.Serializable

@SerialVersionUID(1L)
class APIToken(var token: String) extends Serializable {
  def getToken: String = token

  def setToken(token: String): Unit = {
    this.token = token
  }
}
