package com.example.demo.service;

import com.example.demo.entity.Schedules;
import com.example.demo.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SchedulesService {

    @Autowired
    private SchedulesRepository schedulesRepository;

    public String createSchedulesApi(HashMap map) {
        Schedules schedules = new Schedules();
        schedules.setDate((String)map.get("date"));
        schedules.setTodo("신규");
        schedules.setDone(0);
        schedulesRepository.save(schedules);
        return "성공";
    }

    public List<Schedules> getSchedulesApi(String date) {

        return schedulesRepository.findByDate(date);
    }

    public String updateSchedulesApi(HashMap map) {
        Integer sIndex = (Integer) map.get("sIndex");
        String todo = (String) map.get("todo");
        Schedules schedules = schedulesRepository.findById(sIndex).orElseThrow(() -> new RuntimeException("Entity not found"));
        schedules.setTodo(todo);
        schedulesRepository.save(schedules);
        return "성공";
    }

    public String toggleSchedulesApi(HashMap map) {
        Integer sIndex = (Integer)map.get("sIndex");
        Integer done = (Integer)map.get("done");
        System.out.println(sIndex+" "+done);
        Schedules schedules = schedulesRepository.findById(sIndex).orElseThrow(() -> new RuntimeException("Entity not found"));
        System.out.println(schedules.toString());
        schedules.setDone(done);
        System.out.println(schedules.toString());
        schedulesRepository.save(schedules);
        return "성공";
    }

    public String deleteSchedulesApi(int index) {
        System.out.println(index);
        schedulesRepository.deleteById(index);
        return "성공";
    }

}