package com.github.avec112.report;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "report", schema = "spring")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_id", nullable = false)
    private String officeId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 10000)
    private String body;

    public Report(String officeId, String title, String body) {
        this.officeId = officeId;
        this.title = title;
        this.body = body;
    }
}
