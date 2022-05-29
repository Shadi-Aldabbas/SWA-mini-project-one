package com.miniOne.MiniOne.service.impl;

import com.miniOne.MiniOne.entity.Batch;
import com.miniOne.MiniOne.repository.BatchRepo;
import com.miniOne.MiniOne.service.JobService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private BatchRepo batchRepo;
    @Override
    public List<Batch> doTheWorkBaby() throws IOException {
        List<Batch> batchArr = new ArrayList<>();
        String newLine;
        ArrayList<String> lines = new ArrayList<String>();

        try (InputStream in = getClass().getResourceAsStream("/data.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            while ((newLine = reader.readLine()) != null) {
                if(newLine.contains("First,Last,GPA,AGE")) continue;
                System.out.println(newLine);
                lines.add(newLine);
            }
        }
        for(String line : lines){
            String[] arr = line.split(",");
            Batch b = new Batch();
            b.setFirst(arr[0]);
            b.setLast(arr[1]);
            b.setGPA(Double.parseDouble(arr[2]));
            Date date = new GregorianCalendar(2022-Integer.parseInt(arr[3]), Calendar.JANUARY, 1).getTime();
            b.setDOB(date);
            batchArr.add(b);

        }
//        Reader in = new FileReader("src/main/resources/data.csv");
//        Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
//        for (CSVRecord record : records) {
//            Batch b = new Batch();
//            b.setFirst(record.get("First"));
//            b.setLast(record.get("Last"));
//            b.setGPA(Double.parseDouble(record.get("GPA")));
//            Date date = new GregorianCalendar(2022-Integer.parseInt(record.get("AGE")), Calendar.JANUARY, 1).getTime();
//            b.setDOB(date);
//            batchArr.add(b);
//        }
        System.out.println(batchArr);
        batchRepo.saveAll(batchArr);

        return batchArr;
    }
}
