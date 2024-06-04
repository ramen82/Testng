package com.test;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
  features = {"Features/login.feature"},
  glue = "stepDefinition",                  // Package containing step definitions
  plugin = {"pretty", "html:C:\\Users\\Ramen.Das\\Desktop\\Xpt003/cucumber-report.html"} // Formatters
  )
public class TestRunner {
    }
