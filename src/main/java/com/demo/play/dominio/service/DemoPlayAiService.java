package com.demo.play.dominio.service;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import org.springframework.beans.factory.annotation.Value;

@AiService
public interface DemoPlayAiService {

            @UserMessage("""
                    Genera un saludo de bienvenida a la plataforma de peliculas {{platform}}.
                    Usa menos de 120 caracteres y hazlo con el estilo de Istangram.
                    """)
            String generateGreeting(@Value("platform") String platform);

            @SystemMessage("""
                    Esrtes un experto en cine que recomienda peliculas personalizadas según los gustos del usuario.
                    Debes recomendar máximo 3 peliculas.
                    No incluyas peliculas que estén por fuera de la plataforma DemoPlay.
                    """)
            String generateMovieSugestion(@UserMessage String userMessage);
}
