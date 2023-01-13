package com.wissen.controller;

import com.wissen.enums.AddressType;
import com.wissen.enums.Gender;
import com.wissen.enums.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller class for enum
 *
 * @author Anushka Saxena
 */

@RestController
@RequestMapping("/api/enum")
@Slf4j
public class EnumController {

    /**
     * @author Anushka Saxena
     * @description Method to fetch Type.
     * @return Enum Type
     */
    @GetMapping("/type")
    public ResponseEntity<Type[]> getType(){
        return ResponseEntity.status(HttpStatus.OK).body(Type.values());
    }

    /**
     * @author Anushka Saxena
     * @description Method to fetch AddressType.
     * @return Enum AddressType
     */
    @GetMapping("/addressType")
    public ResponseEntity<AddressType[]> getAddressType(){
        return ResponseEntity.status(HttpStatus.OK).body(AddressType.values());
    }

    /**
     * @author Anushka Saxena
     * @description Method to fetch gender.
     * @return Enum Gender
     */
    @GetMapping("/gender")
    public ResponseEntity<Gender[]> getGender(){
        return ResponseEntity.status(HttpStatus.OK).body(Gender.values());
    }
}
