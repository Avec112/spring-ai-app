package com.github.avec112.report;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ReportDataLoader implements CommandLineRunner {

    private final ReportRepository repo;

    public ReportDataLoader(ReportRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        if (repo.count() == 0) {
            repo.save(new Report("A", "Vann i kjeller",
                    "Kraftig vanninntrenging etter regn. Fukt i grunnmur."));

            repo.save(new Report("A", "Taklekkasje",
                    "Lekkasjer fra tak etter snøsmelting."));

            repo.save(new Report("B", "Elektrisk feil",
                    "Kortslutning i sikringsskap."));
        }
    }
}
