package com.anaeltech.habits_api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "daily_journals", indexes = {
        @jakarta.persistence.Index(name = "idx_daily_journal_user_id", columnList = "user_id"),
        @jakarta.persistence.Index(name = "idx_daily_journal_date", columnList = "date")
})
public class DailyJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate date;

    private Integer mood; // Mood rating from 1 to 10

    private Integer energyLevel; // Energy level rating from 1 to 10

    private Integer stressLevel; // Stress level rating from 1 to 10

    private String notes; // Additional notes for the day

    private Integer sleepDuration; // Sleep duration in hours

    private Integer sleepQuality; // Sleep quality rating from 1 to 10

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
