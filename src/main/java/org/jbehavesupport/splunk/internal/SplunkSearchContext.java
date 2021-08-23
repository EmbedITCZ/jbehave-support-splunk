package org.jbehavesupport.splunk.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jbehavesupport.splunk.SplunkSearchResultEntry;

import java.util.List;

@AllArgsConstructor
public class SplunkSearchContext {
    @Getter
    private List<SplunkSearchResultEntry> searchResults;
    @Getter
    private String query;
}
