package com.likelion.assignment14.day.application;

import com.likelion.assignment14.day.api.dto.response.DayListApiResponse;
import com.likelion.assignment14.day.client.DayApiClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DayService {
    private final DayApiClient dayApiClient;

    public String getDayEventsRaw(int page, int size, int year, int month) {
        return dayApiClient.getDayEventsAsString(page, size, year, month);
    }

    public DayListApiResponse getDayEventsFromApi(int page, int size, int year, int month) {
        return dayApiClient.getDayEvents(page, size, year, month);
    }
}
