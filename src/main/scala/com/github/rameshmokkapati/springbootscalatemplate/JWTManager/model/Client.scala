package com.github.rameshmokkapati.springbootscalatemplate.JWTManager.model

import java.io.Serializable

@SerialVersionUID(1L)
class Client extends Serializable {
  private var clientId:Int = 0
  private var clientName:String = null
  private var passwordTxt:String = null

  //TODO: Complete the client validation before sending the ClientName for Token generation
  def getClientId: Int = clientId

  def setClientId(clientId: Int): Unit = {
    this.clientId = clientId
  }

  def getClientName: String = clientName

  def setClientName(clientName: String): Unit = {
    this.clientName = clientName
  }

  def getPasswordTxt: String = passwordTxt

  def setPasswordTxt(passwordTxt: String): Unit = {
    this.passwordTxt = passwordTxt
  }
}
