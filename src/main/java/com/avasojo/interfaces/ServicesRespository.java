package com.avasojo.interfaces;

/**
 * 
 */
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avasojo.entity.Services;

/**
 * @author Avasojo
 *
 */
public interface ServicesRespository extends JpaRepository<Services, Long> {

	Collection<Services> findByServicesName(String servicesName);
}

