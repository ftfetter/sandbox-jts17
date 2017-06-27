package com.ilegra.jts.spring.calculator.rxnetty;

import com.ilegra.jts.spring.calculator.config.AppConfig;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.servo.KaryonServoModule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CalculatorResource calculatorResource = (CalculatorResource) applicationContext.getBean("calculatorResource");

        System.setProperty("java.awt.headless","true");
        System.setProperty("archaius.deployment.environment","dev");

        Karyon.forRequestHandler(8888,
                new RxNettyHandler("/calculator",
                        calculatorResource),
                new ArchaiusBootstrapModule("rxnetty-calculator"),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();

        ((AnnotationConfigApplicationContext) applicationContext).close();
    }
}
