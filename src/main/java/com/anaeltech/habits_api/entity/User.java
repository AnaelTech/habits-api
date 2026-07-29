package com.anaeltech.habits_api.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.anaeltech.habits_api.enums.UserGender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter // Generate Getter methods for all fields avoid boilerplate code
@Setter // Generate Setter methods for all fields avoid boilerplate code
@NoArgsConstructor // Generate a no-argument constructor for the class
@AllArgsConstructor // Generate an all-arguments constructor for the class
@Table(name = "users", indexes = {
        @jakarta.persistence.Index(name = "idx_user_email", columnList = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String avatarUrl;

    private LocalDate dateOfBirth;

    private UserGender gender;

    private Integer size;

    private BigDecimal weight;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Habit> habits;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<DailyJournal> dailyJournals;
}
