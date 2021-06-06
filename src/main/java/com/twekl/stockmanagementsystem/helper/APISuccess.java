package com.twekl.stockmanagementsystem.helper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code = HttpStatus.FOUND, reason = "Found and Success")
public class APISuccess extends RuntimeException{ }

