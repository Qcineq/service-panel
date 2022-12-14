package pl.coderslab.servicepanel.service;

import pl.coderslab.servicepanel.controller.ReportController;
import pl.coderslab.servicepanel.entity.ReportEntity;

import java.util.List;

public interface ReportService {

    List<ReportEntity> getAllReports();

    ReportEntity saveReport(ReportEntity report);

    ReportEntity getReportById(Long id);
    ReportEntity reportDetails(ReportEntity report);
    ReportEntity reportDiagnosis(ReportEntity report);
}
