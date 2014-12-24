package io.tmtools.demo;

import io.tmtools.TMTools;
import io.tmtools.application.TMTApplication;
import io.tmtools.services.analytics.AnalyticsService;
import io.tmtools.services.crash_report.CrashReportService;
import io.tmtools.services.main_service.MainService;
import io.tmtools.services.mls.MLSService;

public class TestApplication extends TMTApplication {
    @Override
    protected void initializeTMTools() {
        MLSService.createService(this, "1.0");
        MLSService.getInstance().setLoadLanguagesPolicy(MLSService.POLICY_LOAD_LANGUAGE_ONLY_CURRENT);
        MLSService.getInstance().setCurrentLanguagePolicy(MLSService.POLICY_CURRENT_LANGUAGE_SERVER);

        TMTools.getInstance().addService(MLSService.getInstance());
        TMTools.getInstance().addService(MainService.createService());
        TMTools.getInstance().addService(AnalyticsService.createService(this));
        TMTools.getInstance().addService(CrashReportService.createService(this));
    }

    @Override
    protected String getApplicationId() {
        return "";
    }

    @Override
    protected String getApplicationSecret() { return ""; }
}
