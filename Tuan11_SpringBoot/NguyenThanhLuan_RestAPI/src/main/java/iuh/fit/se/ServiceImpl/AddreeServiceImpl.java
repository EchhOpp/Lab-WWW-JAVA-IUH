package iuh.fit.se.ServiceImpl;

import iuh.fit.se.entities.Address;
import iuh.fit.se.repository.AddressRepository;
import iuh.fit.se.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddreeServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }
}
