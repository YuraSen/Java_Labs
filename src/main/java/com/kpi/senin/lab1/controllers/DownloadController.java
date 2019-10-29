package com.kpi.senin.lab1.controllers;

import com.kpi.senin.lab1.services.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/download")
public class DownloadController {
    @Autowired
    private DownloadService downloadService;


    @GetMapping("/singleThread")
    public Map<String, ?> getWithSingleThread(){
        Map<String, Object> modelMap = new HashMap<>();
        return modelMap;
    }

    @GetMapping("/synchronous")
    public Map<String, ?> getWithSynchronous(){
        Map<String, Object> modelMap = new HashMap<>();
        return modelMap;
    }

    @GetMapping("/javarx")
    public Map<String, ?> getWithRXJava(){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("data", downloadService.getAllEntriesWithRXJava());
        return modelMap;
    }
}