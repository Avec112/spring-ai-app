package com.github.avec112.report.rag.ingest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final ReportIngestionService ingestion;

    public StartupRunner(ReportIngestionService ingestion) {
        this.ingestion = ingestion;
    }

    @Override
    public void run(String... args) {
        ingestion.ingestReports();
    }
}
