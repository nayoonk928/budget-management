package com.example.budget.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // ------ 4xx ------
    NOT_FOUND(HttpStatus.BAD_REQUEST, "요청사항을 찾지 못했습니다."),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    // Token
    EXPIRE_TOKEN(HttpStatus.UNAUTHORIZED, "만료된 토근입니다."),
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "잘못된 토큰입니다."),
    EMPTY_AUTHORIZATION_HEADER(HttpStatus.BAD_REQUEST, "인증헤더가 비어있습니다."),

    // Member
    ALREADY_EXISTS_ACCOUNT(HttpStatus.BAD_REQUEST,"이미 존재하는 계정입니다."),
    ALREADY_EXISTS_NICKNAME(HttpStatus.BAD_REQUEST,"이미 존재하는 닉네임입니다."),
    INCORRECT_ACCOUNT_OR_PASSWORD(HttpStatus.BAD_REQUEST,"계정 또는 비밀번호가 일치하지 않습니다."),

    // Budget
    BUDGET_NOT_FOUND(HttpStatus.NOT_FOUND, "예산이 존재하지 않습니다."),

    // Category
    ALL_CATEGORIES_NOT_ROAD(HttpStatus.BAD_REQUEST, "모든 카테고리가 포함되지 않았습니다."),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 카테고리입니다."),

    // Expense
    EXPENSE_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 지출 내역입니다."),

    // ------ 5xx ------
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버에 문제가 발생했습니다."),
    ;

    private final HttpStatus status;
    private final String message;

    ErrorCode(final HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
