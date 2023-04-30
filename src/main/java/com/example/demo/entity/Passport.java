package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "passport")
@Audited
@EntityListeners(AuditingEntityListener.class)
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "passport_number")
    private String number;

}
