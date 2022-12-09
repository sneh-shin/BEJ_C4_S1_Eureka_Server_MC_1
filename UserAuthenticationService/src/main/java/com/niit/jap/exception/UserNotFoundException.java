/*
 *Author Name: Sneha Shinde
 *Date: 11/29/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Invalid login! Incorrect email or password")
public class UserNotFoundException extends Exception {
}
