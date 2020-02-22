package com.liangwei.tradingsystem.repository;

import com.liangwei.tradingsystem.entity.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.Optional;

public interface SecurityRepository extends JpaRepository<Security, Long> {
    @Async
    @Override
    <S extends Security> S save(S entity);

    Optional<Security> findByTicker(String ticker);

    List<Security> findByParentTicker(String parentTicker);
}
