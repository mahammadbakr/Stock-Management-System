package com.twekl.stockmanagementsystem.helper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Not Found Sorry")
public class APIError extends RuntimeException{
   public APIError(){}
}

