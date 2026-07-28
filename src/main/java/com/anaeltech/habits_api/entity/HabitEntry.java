package com.anaeltech.habits_api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.anaeltech.habits_api.enums.HabitEntryUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "habit_entries", indexes = {
        @jakarta.persistence.Index(name = "idx_habit_entry_habit_id", columnList = "habit_id"),
        @jakarta.persistence.Index(name = "idx_habit_entry_date", columnList = "date")
})
public class HabitEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private LocalDateTime createdAt;

    private Integer duration; // Duration in minutes

    private HabitEntryUnit unit; // Enum to represent the unit of measurement

    private String note;

    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

}
