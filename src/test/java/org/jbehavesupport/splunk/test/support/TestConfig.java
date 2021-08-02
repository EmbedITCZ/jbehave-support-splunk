package org.jbehavesupport.splunk.test.support;

import org.jbehavesupport.core.report.XmlReporterFactory;
import org.jbehavesupport.splunk.OneShotSearchSplunkClient;
import org.jbehavesupport.splunk.SplunkClient;
import org.jbehavesupport.splunk.SplunkConfig;
import org.jbehavesupport.splunk.report.extension.SplunkXmlReporterExtension;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = org.jbehavesupport.core.splunk.SplunkSteps.class))
public class TestConfig {

    @Bean
    public XmlReporterFactory xmlReporterFactory() {
        return new XmlReporterFactory();
    }

    @Bean
    public SplunkXmlReporterExtension splunkXmlReporterExtension(){
        return new SplunkXmlReporterExtension();
    }

    @Bean
    SplunkConfig splunkConfig() {
        return SplunkConfig.builder()
            .host("localhost")
            .port(11110)
            .scheme("http")
            .username("admin")
            .password("password")
            .build();
    }

    @Bean
    public SplunkClient splunkClient(SplunkConfig config) {
        return new OneShotSearchSplunkClient(config);
    }

}
