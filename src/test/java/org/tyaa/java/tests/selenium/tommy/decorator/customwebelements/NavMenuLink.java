package org.tyaa.java.tests.selenium.tommy.decorator.customwebelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* Оболочка для веб-элементов типа "Ссылка навигации" */
public class NavMenuLink extends BaseElement {

    private String href;

    public NavMenuLink(WebDriver driver, WebElement element) {
        super(driver, element);
        this.href = element.getAttribute("href");
    }
    /* Выполнить клик по текущему элементу,
     * и если элемент был перекрыт другим элементом
     * или обновлялся - повторять попытку снова, пока не получится выполнить клик */
    public void safeClick(long timeOutInSeconds) {
        safeAction(() -> element.click(), timeOutInSeconds);
    }
    /* Выполнить клик по текущему элементу,
     * затем ожидать максимум до timeOutInSeconds секунд,
     * пока не завершится загрузка нового документа (веб-страницы) */
    public void moveToThenSafeClickThenWaitForDocument(long timeOutInSeconds) {
        moveToElementAndSafeAction(
            element,
            () -> performAndWaitForUpdate(
                driver,
                () -> this.safeClick(timeOutInSeconds),
                timeOutInSeconds
            ),
            timeOutInSeconds
        );
    }

    public String getHref() {
        return href;
    }
}
