package io.nimbuspay.repository;

import io.nimbuspay.model.Msg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Msg, Long> {
}
