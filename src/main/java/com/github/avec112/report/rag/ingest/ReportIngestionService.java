package com.github.avec112.report.rag.ingest;

import com.github.avec112.report.ReportRepository;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportIngestionService {

    private final ReportRepository repo;
    private final VectorStore vectorStore;

    public ReportIngestionService(ReportRepository repo, VectorStore vectorStore) {
        this.repo = repo;
        this.vectorStore = vectorStore;
    }

    public void ingestReports() {
        List<Document> docs = repo.findAll().stream()
                .map(r -> new Document(
                        r.getTitle() + "\n\n" + r.getBody(),
                        Map.of(
                                "reportId", r.getId().toString(),
                                "officeId", r.getOfficeId()
                        )
                ))
                .toList();

        TokenTextSplitter splitter = TokenTextSplitter.builder().build();
        List<Document> chunks = splitter.apply(docs);

        vectorStore.add(chunks);
    }
}
