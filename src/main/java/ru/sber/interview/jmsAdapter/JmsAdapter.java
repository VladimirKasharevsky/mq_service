package ru.sber.interview.jmsAdapter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.sber.interview.model.Manager;
import ru.sber.interview.repository.ManagerRepo;

@Component
public class JmsAdapter {


    @Autowired
    ManagerRepo repo;

    @JmsListener(destination = "standalone.queue")
    public void consume(String message) {

        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(message);

            repo.save(new Manager(
                    (String) json.get("serviceName"),
                    (String) json.get("managerLogin"),
                    (String) json.get("serviceTimeStart"),
                    (String) json.get("serviceTimeEnd")));

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
