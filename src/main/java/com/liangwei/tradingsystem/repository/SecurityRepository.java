package com.liangwei.tradingsystem.repository;

import com.liangwei.tradingsystem.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

public interface SecurityRepository extends JpaRepository<Security, Long> {
    @Async
    @Override
    <S extends Security> S save(S entity);
}
