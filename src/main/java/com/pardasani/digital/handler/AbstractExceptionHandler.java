package com.pardasani.digital.handler;

import com.pardasani.digital.domain.ErrorDetail;
import org.joda.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by pardasap on 26/02/2016.
 */
public class AbstractExceptionHandler extends ResponseEntityExceptionHandler {
    protected <T extends Exception> ErrorDetail produceErrorInstance(T exception, HttpStatus status, WebRequest request) {
        ErrorDetail errorDetails = new ErrorDetail().new ErrorDetailBuilder()
                .withErrorMessage(exception.getMessage())
                .withHttpErrorStatus(status)
                .withTimeOfError(LocalDateTime.now())
                .withUrlPath(request.getContextPath())
                .build();

        return errorDetails;
    }

    protected <T extends Exception> ErrorDetail produceErrorInstance(T exception, HttpStatus status, HttpServletRequest request) {
        ErrorDetail errorDetails = new ErrorDetail().new ErrorDetailBuilder()
                .withErrorMessage(exception.getMessage())
                .withHttpErrorStatus(status)
                .withTimeOfError(LocalDateTime.now())
                .withUrlPath(request.getContextPath())
                .build();

        return errorDetails;
    }
}
