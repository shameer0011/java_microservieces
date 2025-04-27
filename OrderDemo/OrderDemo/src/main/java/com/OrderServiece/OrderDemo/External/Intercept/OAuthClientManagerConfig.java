// package com.OrderServiece.OrderDemo.External.Intercept;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.oauth2.client.*;
// import org.springframework.security.oauth2.client.endpoint.DefaultClientCredentialsTokenResponseClient;
// import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
// import org.springframework.security.oauth2.client.endpoint.OAuth2ClientCredentialsGrantRequest;
// import org.springframework.security.oauth2.client.endpoint.OAuth2ClientCredentialsGrantRequestEntityConverter;
// import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
// import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
// import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
// import org.springframework.web.util.UriComponentsBuilder;

// @Configuration
// public class OAuthClientManagerConfig {

//     @Bean
//     public OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clients,
//                                                                   OAuth2AuthorizedClientRepository authClients) {

//         OAuth2AuthorizedClientProvider authorizedClientProvider =
//                 OAuth2AuthorizedClientProviderBuilder.builder()
//                         .clientCredentials(builder -> builder.accessTokenResponseClient(customResponseClient()))
//                         .build();

//         DefaultOAuth2AuthorizedClientManager manager =
//                 new DefaultOAuth2AuthorizedClientManager(clients, authClients);
//         manager.setAuthorizedClientProvider(authorizedClientProvider);
//         return manager;
//     }

//     private OAuth2AccessTokenResponseClient<OAuth2ClientCredentialsGrantRequest> customResponseClient() {
//         var delegate = new DefaultClientCredentialsTokenResponseClient();
//         delegate.setRequestEntityConverter(new OAuth2ClientCredentialsGrantRequestEntityConverter() {
//             @Override
//             public org.springframework.http.RequestEntity<?> convert(OAuth2ClientCredentialsGrantRequest request) {
//                 var entity = super.convert(request);
//                 var registration = request.getClientRegistration();
//                 var tokenUri = UriComponentsBuilder.fromHttpUrl(registration.getProviderDetails().getTokenUri())
//                         .queryParam("audience", "https://dev-2d8txn41w8quqhi6.us.auth0.com/api/v2/")
//                         .build()
//                         .toUri();

//                 return new org.springframework.http.RequestEntity<>(
//                         entity.getBody(),
//                         entity.getHeaders(),
//                         entity.getMethod(),
//                         tokenUri
//                 );
//             }
//         });
//         return delegate;
//     }
// }
