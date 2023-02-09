package org.training360.week01.day03;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Vote {


    private Long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public Vote(Long id, LocalDateTime startDate) {
        this.id = id;
        this.startDate = startDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
