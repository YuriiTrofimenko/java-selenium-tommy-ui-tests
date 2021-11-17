package org.tyaa.java.tests.selenium.tommy.utils;

import org.tyaa.java.tests.selenium.tommy.utils.interfaces.IPropertiesStore;

public class Global {
    public static final IPropertiesStore properties = new FilePropertiesStore();
}
