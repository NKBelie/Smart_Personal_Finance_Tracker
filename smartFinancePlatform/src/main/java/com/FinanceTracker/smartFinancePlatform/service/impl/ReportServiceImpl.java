package com.FinanceTracker.smartFinancePlatform.service.impl;

import com.FinanceTracker.smartFinancePlatform.model.Report;
import com.FinanceTracker.smartFinancePlatform.model.Users;
import com.FinanceTracker.smartFinancePlatform.repository.ReportRepository;
import com.FinanceTracker.smartFinancePlatform.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public Optional<Report> findById(Long id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<Report> findByUser(Users user) {
        return reportRepository.findByUser(user);
    }

    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public void deleteById(Long id) {
        reportRepository.deleteById(id);
    }
}
