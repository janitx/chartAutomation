package listener;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.TestCaseFinished;
import io.cucumber.plugin.event.TestCaseStarted;
import manager.BrowserFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;
import utils.ScreenShot;


public class CheckTooltipsListener implements ConcurrentEventListener {
    private static final Logger logger = LogManager.getLogger(CheckTooltipsListener.class);

    public void onTestCaseStarted(TestCaseStarted testCaseStarted) {
        String testName = testCaseStarted.getTestCase().getName();
        logger.info(String.format("Test case started: %s", testName));
    }

    public void onTestCaseFinished(TestCaseFinished testCaseFinished) {
        logger.info(String.format("Test case %s finished", testCaseFinished.getTestCase().getName()));
    }

    public void onFailedTest(TestCaseFinished testCaseFinished) {
        String testName = testCaseFinished.getTestCase().getName();
        logger.error(String.format("Failed test %s", testName));
        ScreenShot.captureScreenshot(BasePage.getDriver(), testCaseFinished.getTestCase().getName());
    }

    public void onSkippedTest(TestCaseFinished testCaseFinished) {
        String testName = testCaseFinished.getTestCase().getName();
        logger.info(String.format("Skip test %s", testName));
    }

    public void onPassedTest(TestCaseFinished testCaseFinished) {
        String testName = testCaseFinished.getTestCase().getName();
        logger.info(String.format("Pass test %s", testName));

    }

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onTestCaseStarted);
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onTestCaseFinished);


        eventPublisher.registerHandlerFor(TestCaseFinished.class, event -> {
            switch (event.getResult().getStatus()) {
                case PASSED:
                    onPassedTest(event);
                    break;
                case SKIPPED:
                    onSkippedTest(event);
                    break;
                case FAILED:
                    onFailedTest(event);
                    break;
                default:
                    break;
            }
        });

    }

}

