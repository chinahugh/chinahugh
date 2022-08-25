package com.example.demo.validation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @author HGH
 */
@RestControllerAdvice
public class ExceptionHandleAdvice {
    Logger logger = LoggerFactory.getLogger(ExceptionHandleAdvice.class);

    private static String getKey(ConstraintViolation<?> msg) {
        return msg.getPropertyPath().toString().replace("get.", "");
    }

    /**
     * 实体参数校验 @RequestBody
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage());
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        Map<String, String> collect = new HashMap<>(allErrors.size());
        for (ObjectError error : allErrors) {
            FieldError x = (FieldError) error;
            collect.put(x.getField(), x.getDefaultMessage());
        }

//        Map<String, String> collect = allErrors.stream()
//                .map(KV::new)
//                .filter(KV::notNull)
//                .collect(Collectors.toMap(KV::getK, KV::getV));
//                .map(error -> (FieldError) error)
        return ResponseEntity.ok(collect);
    }

    /**
     * 路径参数校验 @RequestParam  @PathVariable
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity handleBindGetException(ConstraintViolationException ex) {
        logger.error(ex.getMessage());

        Set<ConstraintViolation<?>> message = ex.getConstraintViolations();
        Map<String, String> collect = message.stream()
                .collect(Collectors.toMap(ExceptionHandleAdvice::getKey, ConstraintViolation::getMessage));
        return ResponseEntity.ok(collect);
    }

    @ExceptionHandler(value = MissingPathVariableException.class)
    public ResponseEntity missingPathVariableException(MissingPathVariableException ex){
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.ok(Objects.requireNonNull(ex.getMessage()));
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleBindException2(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.ok(ex.getMessage());
    }

    private class KV {
        private String k;
        private String v;

        public KV(FieldError fieldError) {
            this.k = fieldError.getField();
            this.v = fieldError.getDefaultMessage();
        }

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "KV{" +
                    "k='" + k + '\'' +
                    ", v='" + v + '\'' +
                    '}';
        }

        public boolean notNull() {
            return !(k != null && k.length() > 0 && v != null && v.length() > 0);
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        System.out.println("map.put(null,\"\") = " + map.put("1", "1"));
        System.out.println("map.put(null,\"\") = " + map.put("1", "2"));
        System.out.println("map.put(null,\"\") = " + map.put("1", "3"));
    }
}
