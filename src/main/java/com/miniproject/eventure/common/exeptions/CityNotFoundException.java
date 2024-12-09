package com.miniproject.eventure.common.exeptions;

public class CityNotFoundException extends RuntimeException {
  public CityNotFoundException(Long cityId) {
    super("City with ID " + cityId + " not found !");
  }
}
