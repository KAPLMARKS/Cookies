package com.simbirsoft.repositories;

import com.simbirsoft.models.WeekStats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekStatsRepository extends JpaRepository<WeekStats, Long> {
}
