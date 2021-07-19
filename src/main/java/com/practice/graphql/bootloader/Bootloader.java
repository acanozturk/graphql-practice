package com.practice.graphql.bootloader;

import com.practice.graphql.entities.AddressEntity;
import com.practice.graphql.entities.CustomerEntity;
import com.practice.graphql.repositories.AddressRepository;
import com.practice.graphql.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.andreinc.mockneat.MockNeat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class Bootloader implements CommandLineRunner {

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    @Override
    public void run(String... args) {
        addressLoader();
        customerLoader();
        log.info("Bootloader successful.");
    }

    private void addressLoader() {
        final List<AddressEntity> addressEntities = new ArrayList<>();

        for(int i=0; i<100; i++) {
            final AddressEntity addressEntity = new AddressEntity();

            addressEntity.setCountry(mockNeat.countries().valStr());
            addressEntity.setCity(mockNeat.cities().capitals().valStr());
            addressEntity.setZip(mockNeat.ints().range(1000, 99999).valStr());

            addressEntities.add(addressEntity);
        }

        addressRepository.saveAll(addressEntities);
    }

    private void customerLoader() {
        final List<CustomerEntity> customerEntities = new ArrayList<>();

        for(int i=0; i<100; i++) {
            final CustomerEntity customerEntity = new CustomerEntity();
            final List<AddressEntity> addressEntities = addressRepository.findAll();

            customerEntity.setFirstName(mockNeat.names().first().valStr());
            customerEntity.setLastName(mockNeat.names().last().valStr());
            customerEntity.setEmail(mockNeat.emails().valStr());
            customerEntity.setAddressEntity(addressEntities.get(i));

            customerEntities.add(customerEntity);
        }

        customerRepository.saveAll(customerEntities);
    }

}
