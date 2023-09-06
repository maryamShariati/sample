package com.demis.sample.dtos.customer;


import com.demis.sample.model.Address;
import com.demis.sample.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CreatCustomerRequest(
        @JsonProperty("nationalCode")String nationalCode,
        @JsonProperty("firstName") String firstName,
        @JsonProperty("lastName") String lastName,
        @JsonProperty("address") Address address
        ) {
        public static Customer fromDto(CreatCustomerRequest creatCustomer){
                Customer people=new Customer();
                people.setNationalCode(creatCustomer.nationalCode());
                people.setFirstName(creatCustomer.firstName());
                people.setLastName(creatCustomer.lastName());
                people.setAddress((List<Address>) creatCustomer.address());
                return people;
        }

}
