package com.github.rameshmokkapati.springbootscalatemplate.JWTManager.config

import com.github.rameshmokkapati.springbootscalatemplate.JWTManager.handler.JWTFilter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.{Bean, Configuration}

@Configuration
class JWTConfig {
  @Autowired
  var jwtFilter: JWTFilter = _

  @Bean
  def filterRegistrationBean: FilterRegistrationBean[JWTFilter] = {
    val filterRegistrationBean = new FilterRegistrationBean[JWTFilter]
    filterRegistrationBean.setFilter(jwtFilter)

    // TODO: Change the patterns to include apis that needs to work with JWT
    filterRegistrationBean.addUrlPatterns(
      "/workflow",  // Individual end-point, ex: http://localhost:8080/workflow
                "/workflow/*" // Group end-points, exL http://localhost:8080/workflow/add
    )
    filterRegistrationBean
  }
}
