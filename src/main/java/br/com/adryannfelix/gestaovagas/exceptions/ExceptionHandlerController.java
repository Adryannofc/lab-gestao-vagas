package br.com.adryannfelix.gestaovagas.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ControllerAdvice
public class ExceptionHandlerController {

    private MessageSource messageSoruce;

    public ExceptionHandlerController(MessageSource message) {
        this.messageSoruce = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException error){
        List<ErrorMessageDTO> dto = new ArrayList<>();

        error.getBindingResult().getFieldErrors().forEach(erro -> {
            String message = messageSoruce.getMessage(erro, LocaleContextHolder.getLocale());
            ErrorMessageDTO err = new ErrorMessageDTO(message, erro.getField());
            dto.add(err);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
