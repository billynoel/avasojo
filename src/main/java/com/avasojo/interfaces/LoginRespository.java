package com.avasojo.interfaces;

/**
 * 
 */
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avasojo.entity.Login;

/**
 * @author Avasojo
 *
 */
public interface LoginRespository extends JpaRepository<Login, Long> {

	Collection<Login> findByLoginName(String login_name);
}

