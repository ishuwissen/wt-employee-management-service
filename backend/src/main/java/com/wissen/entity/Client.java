package com.wissen.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(value = 0, message = "Please provide valid clientId")
    @Column(name = "client_id")
    int clientId;

    @NotBlank(message = "Client name cannot be empty")
    @Column(name = "client_name")
    String clientName;

    @NotBlank(message = "Client Location cannot be empty")
    @Column(name = "client_location")
    String clientLocation;
}
