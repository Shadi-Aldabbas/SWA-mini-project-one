package com.miniOne.MiniOne.service;

import com.miniOne.MiniOne.entity.Batch;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface JobService {
    public List<Batch> doTheWorkBaby() throws IOException;
}
