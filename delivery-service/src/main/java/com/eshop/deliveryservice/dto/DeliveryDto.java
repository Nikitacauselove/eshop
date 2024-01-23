package com.eshop.deliveryservice.dto;

import com.eshop.deliveryservice.entity.EType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {
    private String address;

    private EType type;

    private Long orderId;

    private LocalDate date;
}
