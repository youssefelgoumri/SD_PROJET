package com.example.infractionservice.feign;

import com.example.infractionservice.models.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "regestration-service")
public interface VehicleRestClient {
    @GetMapping("api/vehicle/vehicleByRn/{rn}")
    Vehicle getByRegestrationNumber(@PathVariable String rn);
}
