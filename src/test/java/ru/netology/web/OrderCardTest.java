package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;


public class OrderCardTest {
    private WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestValidFirstLastNameAndPhone() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Вася Пупкин");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79217931826");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        assertEquals(expected, actual.trim());
    }

    @Test
    public void shouldTestAgreementCheckbox() {
        // Изначально флажок должен быть снят
        assertFalse(driver.findElement(By.cssSelector("[data-test-id='agreement']")).isSelected());
        // Ставим флажок
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        // Теперь проверяем, что он установлен
        assertTrue(driver.findElement(By.cssSelector("[data-test-id='agreement']")).isEnabled());
    }
}