package com.miniOne.MiniOne.controller;

import com.miniOne.MiniOne.entity.Batch;
import com.miniOne.MiniOne.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/job")
@CrossOrigin
public class BatchController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Batch> test() throws IOException {

        return jobService.doTheWorkBaby();
    }
}
