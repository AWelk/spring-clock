package org._3rev.springclock.webcontrol;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.HttpURLConnection;
import java.net.URL;


@Route
public class MainView extends VerticalLayout {

    NumberField hours;
    NumberField minutes;

    Button endTimerButton;
    Button timerButton;
    Button clockButton;

    @Autowired
    public MainView() {
        hours = new NumberField();
        hours.setLabel("Hours");
        hours.setPlaceholder("HH");
        hours.setMin(0);
        hours.setPreventInvalidInput(true);

        minutes = new NumberField();
        minutes.setLabel("Minutes");
        minutes.setPlaceholder("MM");
        minutes.setMin(0);
        minutes.setMax(59);
        minutes.setPreventInvalidInput(true);

        HorizontalLayout fields = new HorizontalLayout(hours, minutes);

        endTimerButton = new Button("End Timer", e -> callEndTimer());
        timerButton = new Button("Timer", e -> callTimer());
        clockButton = new Button("Clock", e -> callClock());
        HorizontalLayout buttons = new HorizontalLayout(endTimerButton, timerButton, clockButton);

        VerticalLayout verticalLayout = new VerticalLayout(fields, buttons);
        add(verticalLayout);
    }

    private int getSeconds() {
        return hours.getOptionalValue().map(Double::intValue).orElse(0) * 60 * 60 +
                minutes.getOptionalValue().map(Double::intValue).orElse(0) * 60;
    }

    private void callEndTimer() {
        try {
            URL url = new URL("http://localhost:8081/continuousEnd/" + getSeconds());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.getResponseCode();
        } catch (Exception e) {
            System.out.println("Sorry");
        }
    }

    private void callTimer() {
        try {
            URL url = new URL("http://localhost:8081/timer/" + getSeconds());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.getResponseCode();
        } catch (Exception e) {
            System.out.println("Sorry");
        }
    }

    private void callClock() {
        try {
            URL url = new URL("http://localhost:8081/clock");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.getResponseCode();
        } catch (Exception e) {
            System.out.println("Sorry");
        }
    }
}
