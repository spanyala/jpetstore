package selenium.video.recording;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ VerifyProductFireFox.class,VerifyProductIe.class,VerifyProductChrome.class})
public class IntegrationSuite {

}