package com.ensolution.ensol.repository.app.jpa.schedule;

import com.ensolution.ensol.entity.app.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
