package com.example.diary.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.diary.domain.Diary;
import com.example.diary.domain.Lists;
import com.example.diary.dto.DayDiaryDto;
import com.example.diary.dto.DiaryCreateDto;
import com.example.diary.dto.YearAndMonthDto;
import com.example.diary.repository.DiaryAttachmentRepository;
import com.example.diary.service.DiaryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DiaryRestController {

    private final DiaryService diaryService;
    private final DiaryAttachmentRepository diaryAttachmentRepository;
    
    @PostMapping("/add/diary")
    public ResponseEntity<Integer> addNewDiary(@RequestBody DiaryCreateDto dto){
        log.info("DiaryCreateDto 잘 왔냐?=DiaryCreateDto({}", dto);
        
       Integer diaryId = diaryService.create(dto);
        
        return ResponseEntity.ok(diaryId);
    }
    
    @GetMapping("/monthDairy/{diaryId}")
    public ResponseEntity<Integer> showIcons(@PathVariable Integer diaryId){
        
        return ResponseEntity.ok(diaryId);
    }
    
    @GetMapping("/day/diary/{diaryId}")
    public ResponseEntity<Diary> detail(@PathVariable Integer diaryId){
        log.info("다이어flIDIDIDI 잘 왔냐?={}", diaryId);
        
        Diary diary = diaryService.read(diaryId);
        
        return ResponseEntity.ok(diary);
       
    }

    @PostMapping("/detail/diary")
    public ResponseEntity<Integer> detailDiary(Integer diaryId){
        log.info("Detai/diary??????={}", diaryId);
     
        
        return ResponseEntity.ok(1);
    }
 
     
}
