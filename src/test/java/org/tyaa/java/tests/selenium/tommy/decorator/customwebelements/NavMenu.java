package org.tyaa.java.tests.selenium.tommy.decorator.customwebelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

/* Оболочка для веб-элементов типа "Меню навигации" */
public class NavMenu extends BaseElement {
    public NavMenu(WebDriver driver, WebElement element) {
        super(driver, element);
    }
    public Stream<NavMenuLink> getLinks() {
        return driver.findElements(By.cssSelector(".nav__primary > div.top-level")).stream()
            .map(el -> new NavMenuLink(driver, el));
    }
}
