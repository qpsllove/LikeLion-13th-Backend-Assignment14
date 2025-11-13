package com.likelion.assignment14.day.api.dto.response;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// 문화행사 리스트 API 응답
@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@NoArgsConstructor
public class DayListApiResponse {

    // 응답 헤더
    private Header header;

    // 응답 본문
    private Body body;

    // 응답 헤더 정보
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Header {
        // 결과 코드
        private String resultCode;

        // 결과 메시지
        private String resultMsg;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Body {

        @XmlElement(name = "totalCount")
        private Integer totalCount;

        // 페이지 번호
        @XmlElement(name = "pageNo")
        private Integer pageNo;

        // 페이지당 행 수
        @XmlElement(name = "numOfRows")
        private Integer numOfRows;

        // 특일 목록
        private Items items;

    }

    // 특일 아이템 목록
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class Items {
        // 특일 배열
        @XmlElement(name = "item")
        private List<DayListItem> item;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter
    @NoArgsConstructor
    public static class DayListItem {
        // 날짜
        private String locdate;

        // 순번
        private String seq;

        // 종류
        private String dateKind;

        // 공공기관 휴일여부
        private String isHoliday;

        // 명칭
        private String dateName;
    }
}