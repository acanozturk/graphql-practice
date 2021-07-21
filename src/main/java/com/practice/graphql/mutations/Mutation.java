package com.practice.graphql.mutations;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.practice.graphql.api.dtos.Address;
import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.api.requests.CreateCustomerRequest;
import com.practice.graphql.api.responses.CreateCustomerResponse;
import com.practice.graphql.entities.AddressEntity;
import com.practice.graphql.services.AddressService;
import com.practice.graphql.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final AddressService addressService;
    private final CustomerService customerService;

    public CreateCustomerResponse createCustomerRequest(final CreateCustomerRequest request) {
        final String country = request.getCountry();
        final String city = request.getCity();
        final String zip = request.getZip();
        final String firstName = request.getFirstName();
        final String lastName = request.getLastName();
        final String birthday = request.getBirthday();
        final String email = request.getEmail();

        final AddressEntity addressEntity = addressService.createAddress(country, city, zip);

        customerService.createCustomer(firstName, lastName, birthday, email, addressEntity);

        final CreateCustomerResponse response = new CreateCustomerResponse();

        response.setMessage("Created customer.");

        return response;
    }



}
