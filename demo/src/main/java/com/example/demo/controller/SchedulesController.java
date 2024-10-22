package com.example.demo.controller;

import com.example.demo.entity.Schedules;
import com.example.demo.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SchedulesController {

    @Autowired
    private SchedulesService schedulesService;

    @ResponseBody
    @PostMapping("/schedules")
    public String createSchedulesApi(@RequestBody HashMap<String, Object> map) {
        System.out.println("애초에 여길 안 들어오는 듯");
        return schedulesService.createSchedulesApi(map);
    }

    @ResponseBody
    @GetMapping("/schedules/{date}")
    public List<Schedules> getSchedulesApi(@PathVariable("date") String date) {

        return schedulesService.getSchedulesApi(date);
    }

    @ResponseBody
    @PostMapping("/schedules/update")
    public String updateSchedulesApi(@RequestBody HashMap<String, Object> map) {

        return schedulesService.updateSchedulesApi(map);
    }

    @ResponseBody
    @PostMapping("/schedules/toggle")
    public String toggleSchedulesApi(@RequestBody HashMap<String, Object> map) {

        return schedulesService.toggleSchedulesApi(map);
    }

    @ResponseBody
    @DeleteMapping("/schedules/{sIndex}")
    public String deleteSchedulesApi(@PathVariable("sIndex") int index) {
        System.out.println("애초에 여길 안 들어오는 듯");
        return schedulesService.deleteSchedulesApi(index);
    }


}