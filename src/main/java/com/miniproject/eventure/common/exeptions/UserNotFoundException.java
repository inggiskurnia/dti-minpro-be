package com.miniproject.eventure.common.exeptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(Long userId) {
    super("User with ID "+ userId + " not found !");
  }
}
