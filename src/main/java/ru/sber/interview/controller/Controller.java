package ru.sber.interview.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import ru.sber.interview.helper.JsonResponseHelper;
import ru.sber.interview.repository.ManagerRepo;

import javax.jms.Queue;
import javax.validation.Valid;


@RestController
public class Controller {

    @Autowired
    JsonResponseHelper jsonResponseHelper;

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @Autowired
    ManagerRepo repo;

    @GetMapping("/find/{managerLogin}")
    public String find(@PathVariable("managerLogin")
                          final String managerLogin) {

        try {
            JSONObject obj = new JSONObject();
            JSONObject managerList = new JSONObject();
            JSONObject serviceList = new JSONObject();


            serviceList.put("serviceName", repo.findByManagerLogin(managerLogin).get(0).getServiceName());
            serviceList.put("serviceTimeStart", repo.findByManagerLogin(managerLogin).get(0).getServiceTimeEnd());
            serviceList.put("serviceTimeEnd", repo.findByManagerLogin(managerLogin).get(0).getServiceTimeEnd());

            managerList.put("login", managerLogin);

            managerList.put("serviceList", serviceList);
            obj.put("managerList", managerList);

            return obj.toJSONString();

        }catch (Exception e){

            return jsonResponseHelper.jsonResponse("error", "Сотрудник не найден");
        }

    }

    @PostMapping("/send")
    public String send(@Valid @RequestBody String message) {

        try {

            jmsTemplate.convertAndSend(queue, message);

            return jsonResponseHelper.jsonResponse("ok","Сообщение отправлено");

        } catch (Exception e) {

            e.printStackTrace();
            return jsonResponseHelper.jsonResponse("error","Ошибка отправки сообщения");
        }
    }
}