package com.github.rameshmokkapati.springbootscalatemplate.JWTManager.handler

import io.jsonwebtoken.{Claims, Jwts, SignatureException}
import org.springframework.stereotype.Component
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.http.HttpServletRequest
import javax.servlet.{FilterChain, ServletException, ServletRequest, ServletResponse}


@Component
class JWTFilter extends GenericFilterBean {

  @Override
  @throws[ServletException]
  def doFilter(req: ServletRequest, res: ServletResponse, chain: FilterChain): Unit = {
    val request: HttpServletRequest = req.asInstanceOf[HttpServletRequest]
    val authorization:String = request.getHeader("authorization")
    if (authorization == null || !authorization.startsWith("WFS:Token=")) throw new ServletException("401 - UNAUTHORIZED")
    try {
      // TODO: Complete the client validation before Token generation and Change the Encoded Key "C8#&*Intuition*WorkFlowService211221"
      val claims: Claims = Jwts.parser.setSigningKey("C8#&*Intuition*WorkFlowService211221").parseClaimsJws(authorization.substring(10)).getBody
      request.setAttribute("claims", claims)
    } catch {
      case e: SignatureException =>
        throw new ServletException("401 - UNAUTHORIZED")
    }
    chain.doFilter(req, res)
  }
}
