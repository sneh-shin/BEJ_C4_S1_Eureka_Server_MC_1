/*
 *Author Name: Sneha Shinde
 *Date: 11/25/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Artist is not available")
public class ArtistNotFound extends Exception {

}
