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

import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class Bootloader implements CommandLineRunner {

    private static final Integer RECORD_COUNT = 500;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) {
        addressLoader();
        customerLoader();
        log.info("Bootloader successful.");
    }

    private void addressLoader() {
        for(int i=0; i<RECORD_COUNT; i++) {
            final AddressEntity addressEntity = new AddressEntity();

            addressEntity.setCountry(mockNeat.countries().valStr());
            addressEntity.setCity(mockNeat.cities().capitals().valStr());
            addressEntity.setZip(mockNeat.ints().range(1000, 99999).valStr());

            addressRepository.save(addressEntity);
        }
    }

    private void customerLoader() {
        for(int i=0; i<RECORD_COUNT; i++) {
            final CustomerEntity customerEntity = new CustomerEntity();
            final List<AddressEntity> addressEntities = addressRepository.findAll();

            customerEntity.setFirstName(mockNeat.names().first().valStr());
            customerEntity.setLastName(mockNeat.names().last().valStr());
            customerEntity.setBirthday(mockNeat.localDates().between(
                    LocalDate.of(1900,1,1),
                    LocalDate.of(2003,12,31))
                    .valStr());
            customerEntity.setEmail(mockNeat.emails().valStr());
            customerEntity.setAddressEntity(addressEntities.get(i));

            customerRepository.save(customerEntity);
        }
    }

}
