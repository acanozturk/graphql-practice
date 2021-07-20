package com.practice.graphql.services;

import com.practice.graphql.api.dtos.Address;
import com.practice.graphql.api.dtos.Customer;
import com.practice.graphql.api.mappers.CustomerMapper;
import com.practice.graphql.entities.AddressEntity;
import com.practice.graphql.entities.CustomerEntity;
import com.practice.graphql.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        return setCustomerAddressOne(customerEntity);
    }

    @Override
    public List<Customer> getCustomersSortedAndPaginated(final Integer pageNo, final Integer pageSize,
                                                         final String sortBy, final String sortDirection) {

        final Pageable page = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.valueOf(sortDirection), sortBy);
        final List<CustomerEntity> customerEntities = customerRepository.findAll(page).getContent();

        return setCustomerAddressMultiple(customerEntities);
    }

    @Override
    public List<Customer> getCustomersByCity(final List<String> cities) {
        final List<CustomerEntity> customerEntities = new ArrayList<>();

        for(String city : cities) {
            customerEntities.addAll(customerRepository.findCustomerEntityByAddressEntity_CityOrderByFirstName(city));
        }

        return setCustomerAddressMultiple(customerEntities);
    }

    @Override
    public void createCustomer(final String firstName, final String lastName, final String birthday,
                               final String email, final AddressEntity addressEntity) {

        final CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerEntity.setBirthday(birthday);
        customerEntity.setEmail(email);
        customerEntity.setAddressEntity(addressEntity);

        customerRepository.save(customerEntity);
    }

    private Customer setCustomerAddressOne(final CustomerEntity customerEntity) {
        final Address address = addressService.getAddressById(customerEntity.getAddressEntity().getId());
        final Customer customer = customerMapper.customerEntityToCustomerDTO(customerEntity);

        customer.setAddress(address);

        return customer;
    }

    private List<Customer> setCustomerAddressMultiple(final List<CustomerEntity> customerEntities) {

        return customerEntities
                .stream()
                .map(this::setCustomerAddressOne)
                .collect(Collectors.toList());
    }

}
