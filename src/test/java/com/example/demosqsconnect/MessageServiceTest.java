package com.example.demosqsconnect;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class MessageServiceTest {

    @Test
    void sendMessageSendsExpectedRequest() {
        SqsClient sqsClient = mock(SqsClient.class);
        when(sqsClient.sendMessage(any(SendMessageRequest.class)))
                .thenReturn(SendMessageResponse.builder().build());

        MessageService service = new MessageService(sqsClient);
        String queueUrl = "https://sqs.us-east-1.amazonaws.com/123/test";
        String body = "hello";

        service.sendMessage(queueUrl, body);

        ArgumentCaptor<SendMessageRequest> captor = ArgumentCaptor.forClass(SendMessageRequest.class);
        verify(sqsClient).sendMessage(captor.capture());
        SendMessageRequest request = captor.getValue();
        assertEquals(queueUrl, request.queueUrl());
        assertEquals(body, request.messageBody());
    }
}
