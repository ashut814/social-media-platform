package com.social.media.repositories;

import com.social.media.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users , Long> {

}
