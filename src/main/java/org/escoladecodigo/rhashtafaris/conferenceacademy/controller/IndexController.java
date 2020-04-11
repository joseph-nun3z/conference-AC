package org.escoladecodigo.rhashtafaris.conferenceacademy.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conference")
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<API> getVersion(){
        API api = new API("Conference Academia de Codigo", "1.0.0");

        return new ResponseEntity<>(api, HttpStatus.OK);
    }


    @Getter
    @Setter
    private static class  API {
        private String name;
        private String version;

        public API(String name, String version) {
            this.name = name;
            this.version = version;
        }
    }
}
