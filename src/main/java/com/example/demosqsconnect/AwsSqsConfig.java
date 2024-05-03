package com.example.demosqsconnect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.WebIdentityTokenFileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsSqsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Bean
    public SqsClient sqsClient() {
    	//Log adicionar
        return SqsClient.builder()
                .region(Region.of(awsRegion))
                .credentialsProvider(WebIdentityTokenFileCredentialsProvider.create())
                .build();
    }
}
