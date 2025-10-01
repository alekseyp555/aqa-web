package ru.netology.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;

||||||| 0bc7911 (fix beaty style)
import static org.junit.jupiter.api.Assertions.*;


=======

>>>>>>> parent of 0bc7911 (fix beaty style)
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
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:9999");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
<<<<<<< HEAD
    void shouldTestValidFirstLastNameAndPhone() {
        //Ввод ФИО
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Вася-Пупкин");
        //Ввод номера телефона
||||||| 0bc7911 (fix beaty style)
    void shouldTestValidFirstLastNameAndPhone() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Вася Пупкин");
=======
    void shouldTestPositive() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Вася Пупкин");
>>>>>>> parent of 0bc7911 (fix beaty style)
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79217931826");
        //Чекбокс соглашения
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        // Продолжить
        driver.findElement(By.cssSelector("button")).click();
<<<<<<< HEAD
        // Ожидаемый результат
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        // Фактический результат
||||||| 0bc7911 (fix beaty style)
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
=======
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
>>>>>>> parent of 0bc7911 (fix beaty style)
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
<<<<<<< HEAD
//      Метод trim() удаляет начальные и конечные пробельные символы строки
//      Это полезно, когда нужно очистить строку перед обработкой или выводом её на экран.
        //Проверяем сообщение
        assertEquals(expected, actual.trim());
||||||| 0bc7911 (fix beaty style)
        assertEquals(expected, actual.trim());
=======
        Assertions.assertEquals(expected, actual);
>>>>>>> parent of 0bc7911 (fix beaty style)
    }

    @Test
    void shouldTestPositiveResultDoubleSurname() {
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Муравьев-Апостол Сергей");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79217951843");
        driver.findElement(By.cssSelector("[data-test-id='agreement']")).click();
        driver.findElement(By.cssSelector("button")).click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldTestPositiveResultDoubleName() {
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Петров Иван Васильевич");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79770001155");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button")).click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        Assertions.assertEquals(expected, actual);
    }
}



