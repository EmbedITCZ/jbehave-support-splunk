package org.jbehavesupport.splunk.test.sample;

import org.jbehavesupport.core.AbstractSpringStories;
import org.jbehavesupport.splunk.test.support.TestConfig;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes = TestConfig.class)
public class SplunkStoryIT extends AbstractSpringStories {

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList(
            "org/jbehavesupport/splunk/test/sample/Splunk.story"
        );
    }

}
