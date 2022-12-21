package ru.vinogradov.vin.market.core.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//@EnableConfigurationProperties(
//        ProductServiceIntegrationProperties.class
//)
@RequiredArgsConstructor
public class AppConfig {
    //private final ProductServiceIntegrationProperties productServiceIntegrationProperties;
    private String url;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public WebClient productServiceWebClient() {
//        TcpClient tcpClient = TcpClient
//                .create()
//                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,
//                        productServiceIntegrationProperties.getConnectTimeout())
//                .doOnConnected(connection -> {
//                    connection.addHandlerLast(new ReadTimeoutHandler(
//                            productServiceIntegrationProperties.getReadTimeout(), TimeUnit.MILLISECONDS));
//                    connection.addHandlerLast(new WriteTimeoutHandler(
//                            productServiceIntegrationProperties.getWriteTimeout(), TimeUnit.MILLISECONDS));
//                });
//
//        return WebClient
//                .builder()
//                .baseUrl(productServiceIntegrationProperties.getUrl())
//                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
//                .build();
//    }
}
