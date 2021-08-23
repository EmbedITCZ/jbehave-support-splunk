package org.jbehavesupport.splunk;

import com.splunk.SSLSecurityProtocol;
import com.splunk.ServiceArgs;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class SplunkConfig {
    public static final String HTTPS_SCHEME = "https";

    @NonNull
    private String host;
    @NonNull
    private int port;
    @NonNull
    private String scheme;
    private String username;
    private String password;
    private String token;
    private SSLSecurityProtocol sslSecurityProtocol;

    public ServiceArgs toServiceArguments() {
        ServiceArgs args = new ServiceArgs();
        args.setUsername(username);
        args.setPassword(password);
        args.setToken(token);
        args.setHost(host);
        args.setPort(port);
        args.setScheme(scheme);
        if (HTTPS_SCHEME.equals(scheme)) {
            if (Objects.isNull(sslSecurityProtocol)) {
                throw new IllegalArgumentException("Configuration option 'org.jbehavesupport.splunk.sslSecurityProtocol' is required when 'org.jbehavesupport.splunk.schema' is 'https'");
            }
            args.setSSLSecurityProtocol(sslSecurityProtocol);
        }
        return args;
    }
}
