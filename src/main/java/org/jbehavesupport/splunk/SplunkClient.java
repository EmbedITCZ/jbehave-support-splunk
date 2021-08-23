package org.jbehavesupport.splunk;

import org.jbehavesupport.splunk.internal.SplunkOutputModes;

import java.util.List;


/**
 * WARNING: Not supported, please use at your own risk. If you want/plan to use this please contact us and let us know
 * (so that we might potentially continue development if there is enough interest).
 * <p>
 * This an interface exposing search entry points for Splunk Java SDK.
 * <p>
 * Prior to your testing, verify that you have a valid Splunk account and you know hostname and port.
 * <p>
 * You can use username/password or auth token if you generated one. All the configuration elements should go to your application yaml file.
 *
 * <p>
 * Example:
 * org.jbehavesupport.splunk:
 * host: <YOUR SPLUNK HOST>
 * port: <YOUR SPLUNK HOST PORT>
 * scheme: https
 * credentials:
 *  username: admin
 *  password: password
 * or
 *  token: Bearer <YOUR SPLUNK AUTH TOKEN>
 */


public interface SplunkClient {

    /**
     * This method invokes Splunk search.
     *
     * @param query            Splunk search query
     * @param earliestTime     earliest date of the search frame
     * @param latestTime       latest date of the search frame
     * @param splunkOutputMode Splunk output mode (e.g. "xml", "json", "csv")
     * @return Splunk resultset matching the search query
     */
    List<SplunkSearchResultEntry> search(String query, String earliestTime, String latestTime, SplunkOutputModes splunkOutputMode);

    /**
     * This method invokes Splunk search.
     *
     * @param query        Splunk search query
     * @param earliestTime earliest date of the search frame
     * @param latestTime   latest date of the search frame
     * @return Splunk resultset matching the search query
     */
    List<SplunkSearchResultEntry> search(String query, String earliestTime, String latestTime);

    /**
     * This method invokes Splunk search.
     *
     * @param query Splunk search query
     * @return Splunk resultset matching the search query
     */
    List<SplunkSearchResultEntry> search(String query);
}
