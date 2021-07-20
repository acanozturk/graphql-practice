package com.practice.graphql.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.api.requests.GetCustomerByIdRequest;
import com.practice.graphql.api.requests.GetCustomersByCityRequest;
import com.practice.graphql.api.requests.GetCustomersSortedAndPaginatedRequest;
import com.practice.graphql.api.responses.GetCustomerByIdResponse;
import com.practice.graphql.api.responses.GetCustomersByCityResponse;
import com.practice.graphql.api.responses.GetCustomersSortedAndPaginatedResponse;
import com.practice.graphql.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final CustomerService customerService;

    public GetCustomerByIdResponse getCustomerByIdRequest(final GetCustomerByIdRequest request) {
        final Integer id = request.getId();

        final Customer customer = customerService.getCustomerById(id);

        final GetCustomerByIdResponse response = new GetCustomerByIdResponse();

        response.setCustomer(customer);

        return response;
    }

    public GetCustomersSortedAndPaginatedResponse getCustomersSortedAndPaginatedRequest(
            final GetCustomersSortedAndPaginatedRequest request) {

        final Integer pageNo = request.getPageNo();
        final Integer pageSize = request.getPageSize();
        final String sortBy = request.getSortBy();
        final String sortDirection = request.getSortDirection();

        final List<Customer> customers = customerService
                .getCustomersSortedAndPaginated(pageNo, pageSize, sortBy, sortDirection);

        final GetCustomersSortedAndPaginatedResponse response = new GetCustomersSortedAndPaginatedResponse();

        response.setCount(customers.size());
        response.setCustomers(customers);

        return response;
    }

    public GetCustomersByCityResponse getCustomersByCityRequest(final GetCustomersByCityRequest request) {
        final List<String> cities = request.getCities();

        final List<Customer> customers = customerService.getCustomersByCity(cities);

        final GetCustomersByCityResponse response = new GetCustomersByCityResponse();

        response.setCount(customers.size());
        response.setCustomers(customers);

        return response;
    }
}
