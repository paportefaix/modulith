package com.example.mymodulith.common;

import com.example.mymodulith.common.configuration.ApiError;
import com.example.mymodulith.common.configuration.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

  @Mock
  private MethodArgumentNotValidException ex;

  @Mock
  private BindingResult bindingResult;

  @InjectMocks
  private GlobalExceptionHandler globalExceptionHandler;


  @Test
  void handleMethodArgumentNotValidException() {

    // 1. Préparation des données de test
    FieldError fieldError1 = new FieldError("objectName", "field1", "Field1 is required");
    FieldError fieldError2 = new FieldError("objectName", "field2", "Field2 must be positive");
    ObjectError globalError = new ObjectError("objectName", "Global error message");

    // 2. Configuration des mocks
    when(ex.getBindingResult()).thenReturn(bindingResult);
    when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError1, fieldError2));
    when(bindingResult.getGlobalErrors()).thenReturn(List.of(globalError));

    // 3. Appel de la méthode à tester
    ResponseEntity<ApiError> response = globalExceptionHandler.handleMethodArgumentNotValidException(ex);

    // 4. Vérifications
    assertNotNull(response);
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

    ApiError apiError = response.getBody();
    assertNotNull(apiError);
    assertEquals(HttpStatus.BAD_REQUEST, apiError.status());
    assertEquals("Field validation failed", apiError.message());

    // Vérification des erreurs de champ
    Map<String, String> errors = apiError.errors();
    assertEquals(3, errors.size()); // 2 erreurs de champ + 1 erreur globale
    assertEquals("Field1 is required", errors.get("field1"));
    assertEquals("Field2 must be positive", errors.get("field2"));
    assertEquals("Global error message", errors.get("objectName"));
  }
}
