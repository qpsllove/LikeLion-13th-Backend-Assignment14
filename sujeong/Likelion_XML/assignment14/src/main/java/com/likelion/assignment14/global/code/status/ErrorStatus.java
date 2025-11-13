package com.likelion.assignment14.global.code.status;

import com.likelion.assignment14.global.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 400 Bad Request
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "VALID4001", "입력값 유효성 검증에 실패했습니다."),
    MISSING_PARAMETER(HttpStatus.BAD_REQUEST, "VALID4002", "필수 파라미터가 누락되었습니다."),
    TYPE_MISMATCH(HttpStatus.BAD_REQUEST, "VALID4003", "파라미터 타입이 올바르지 않습니다."),
    DAY_API_EMPTY_RESPONSE(HttpStatus.BAD_GATEWAY, "DAY4004", "특일 API에서 빈 응답을 받았습니다."),

    // 405 Method Not Allowed
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "COMMON405", "허용되지 않는 HTTP 메서드입니다."),

    // 409 Conflict
    CONFLICT(HttpStatus.CONFLICT, "COMMON409", "요청이 현재 리소스 상태와 충돌합니다."),
    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "GEN4091", "이미 존재하는 리소스입니다."),
    VERSION_CONFLICT(HttpStatus.CONFLICT, "GEN4092", "리소스 버전 충돌이 발생했습니다."),

    // 500 Internal Server Error
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    DAY_API_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DAY5009", "특일 정보 API 통신 오류가 발생했습니다."),

    // 502, 503, 504
    BAD_GATEWAY(HttpStatus.BAD_GATEWAY, "COMMON502", "불완전한 게이트웨이 응답을 받았습니다."),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "COMMON503", "서비스를 일시적으로 사용할 수 없습니다."),
    GATEWAY_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT, "COMMON504", "게이트웨이 연결이 시간 초과되었습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public boolean isSuccess() {
        return false;
    }
}
