package org._3rev.springclock.ws;

import org._3rev.springclock.controller.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

    private Controller controller;

    public Endpoint(Controller controller) {
        this.controller = controller;
    }

    @RequestMapping("/start")
    public void start() {
        controller.start();
    }

    @RequestMapping("/stop")
    public void stop() {
        controller.stop();
    }
}
