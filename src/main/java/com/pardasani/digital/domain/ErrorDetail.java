package com.pardasani.digital.domain;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

/**
 * Created by pardasap on 12/02/2016.
 */
public class ErrorDetail {
    private static final DateTimeFormatter errorTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    private String errorMessage;
    private LocalDateTime timeOfError;
    private HttpStatus status;
    private String urlPath;

    public ErrorDetail() {}

    public String getErrorMessage() {
        if (StringUtils.isEmpty(errorMessage)) return "Some internal error has occurred within the application";
        return errorMessage;
    }

    public String getTimeOfError() {
        if (null == timeOfError) LocalDateTime.now().toString(errorTimeFormat);
        return timeOfError.toString(errorTimeFormat);
    }

    public int getStatus() {
        if (null == this.status) return HttpStatus.INTERNAL_SERVER_ERROR.value();
        return status.value();
    }

    public String getUrlPath() {
        if (StringUtils.isEmpty(urlPath)) return "/";
        return urlPath;
    }

    public class ErrorDetailBuilder {
        public ErrorDetailBuilder() {}

        public ErrorDetailBuilder withErrorMessage(String message) {
            ErrorDetail.this.errorMessage = message;
            return this;
        }

        public ErrorDetailBuilder withTimeOfError(LocalDateTime timestamp) {
            ErrorDetail.this.timeOfError = timestamp;
            return this;
        }

        public ErrorDetailBuilder withHttpErrorStatus(HttpStatus status) {
            ErrorDetail.this.status = status;
            return this;
        }

        public ErrorDetailBuilder withUrlPath(String path) {
            ErrorDetail.this.urlPath = path;
            return this;
        }

        public ErrorDetail build() {
            return ErrorDetail.this;
        }
    }
}

