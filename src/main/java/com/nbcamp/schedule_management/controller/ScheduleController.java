package com.nbcamp.schedule_management.controller;

import com.nbcamp.schedule_management.dto.ScheduleRequest;
import com.nbcamp.schedule_management.dto.ScheduleResponse;
import com.nbcamp.schedule_management.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/schedules")
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponse> saveSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        ScheduleResponse scheduleResponse = scheduleService.saveSchedule(scheduleRequest);
        return ResponseEntity.ok(scheduleResponse);
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> findSchedule(@PathVariable Long scheduleId) {
        ScheduleResponse scheduleResponse = scheduleService.findById(scheduleId);
        return ResponseEntity.ok(scheduleResponse);
    }
}
