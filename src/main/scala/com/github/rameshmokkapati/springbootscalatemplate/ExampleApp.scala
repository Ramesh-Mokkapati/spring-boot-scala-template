package com.github.rameshmokkapati.springbootscalatemplate

import org.eclipse.jetty.server.{NetworkTrafficServerConnector, Server}
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{Bean, Profile}
import org.springframework.web.servlet.config.annotation.{CorsRegistry, WebMvcConfigurer}

import java.nio.file.Path


@SpringBootApplication
class ExampleApp {

  //TODO: Disabling cors for development purposes
  @Bean def corsConfigurer: WebMvcConfigurer = new WebMvcConfigurer() {
    override def addCorsMappings(registry: CorsRegistry): Unit = {
      registry.addMapping("/**").allowedMethods("*").allowedHeaders("*").allowedOrigins("*")
      registry.addMapping("/app").allowedOrigins("*")
    }
  }
}

object ExampleApp extends App {
  val app = SpringApplication.run(classOf[ExampleApp])
}
