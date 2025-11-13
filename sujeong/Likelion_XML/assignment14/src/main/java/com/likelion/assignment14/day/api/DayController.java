package com.likelion.assignment14.day.api;

import com.likelion.assignment14.day.api.dto.response.DayListApiResponse;
import com.likelion.assignment14.day.application.DayService;
import com.likelion.assignment14.global.code.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// 특일 관련 API
@RestController
@RequestMapping("/api/days")
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;

    @GetMapping("/raw")
    public ResponseEntity<String> getDayRaw(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam int year,
            @RequestParam int month) {

        String response = dayService.getDayEventsRaw(page, size, year, month);
        return ResponseEntity.ok(response);
    }

    // 공휴일 정보 조회
    @GetMapping("/from-api")
    public ResponseEntity<ApiResponse<DayListApiResponse>> getDayFromApi(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam int year,
            @RequestParam int month) {
        {

            DayListApiResponse response = dayService.getDayEventsFromApi(page, size, year, month);
            return ResponseEntity.ok(ApiResponse.onSuccess(response));
        }
    }
}
