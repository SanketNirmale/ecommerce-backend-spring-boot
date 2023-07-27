package com.backend.main.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.main.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
