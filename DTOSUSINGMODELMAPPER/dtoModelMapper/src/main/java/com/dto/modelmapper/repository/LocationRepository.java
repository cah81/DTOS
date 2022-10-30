package com.dto.modelmapper.repository;

import com.dto.modelmapper.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
