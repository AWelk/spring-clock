package org._3rev.springclock.ws;

import org._3rev.springclock.controller.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoint {

    private Controller controller;

    public Endpoint(Controller controller) {
        this.controller = controller;
    }

    @RequestMapping("/continuousEnd/{seconds}")
    public void continuousEnd(@PathVariable int seconds) {
        controller.continuousEnd(seconds);
    }

    @RequestMapping("/finalEnd/{seconds}")
    public void finalEnd(@PathVariable int seconds) {
        controller.finalEnd(seconds);
    }

    @RequestMapping("/clock")
    public void clock() {
        controller.clock();
    }
}
