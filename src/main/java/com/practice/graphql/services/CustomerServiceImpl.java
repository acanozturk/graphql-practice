package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Address;
import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.api.mappers.CustomerMapper;
import com.practice.graphql.entities.CustomerEntity;
import com.practice.graphql.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final AddressService addressService;

    @Override
    public Customer getCustomerById(final Integer id) {
        final CustomerEntity customerEntity = customerRepository.findCustomerEntityById(id);

        return setCustomerAddress(customerEntity);
    }

    @Override
    public List<Customer> getCustomersSortedAndPaginated(final Integer pageNo, final Integer pageSize,
                                                         final String sortBy, final String sortDirection) {

        final Pageable page = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.valueOf(sortDirection), sortBy);
        final List<CustomerEntity> customerEntities = customerRepository.findAll(page).getContent();

        return customerEntities
                .stream()
                .map(this::setCustomerAddress)
                .collect(Collectors.toList());
    }

    private Customer setCustomerAddress(final CustomerEntity customerEntity) {
        final Address address = addressService.getAddressById(customerEntity.getAddressEntity().getId());
        final Customer customer = customerMapper.customerEntityToCustomerDTO(customerEntity);

        customer.setAddress(address);

        return customer;
    }
}
