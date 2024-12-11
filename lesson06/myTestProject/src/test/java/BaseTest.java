import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    void initBeforeClass() {
        // сайт был в списке специальных сайтов для отработки автотестирования
        // https://www.software-testing.ru/component/content/article/3806-qa-tester-beginner-series-a-beginners-guide-to-page-object-model-pom-and-page-factory?ysclid=m3q8d57nez138871063
        Configuration.baseUrl = "https://www.demoblaze.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 30000;
    }
}
