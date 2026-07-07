package com.cursojava.pmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExemploController {
    @GetMapping("/ok")
    public ResponseEntity<String> olaMundo() {
        return ResponseEntity.ok("Olá mundo");
    }

    @PostMapping("/echo")
    public ResponseEntity<String> echo(@RequestBody String mensagem) {
        StringBuilder novaMensagem = new StringBuilder(mensagem);
        return ResponseEntity.ok(novaMensagem.reverse().toString());
    }
}
