package com.ureca.idle.producer.client;

import com.ureca.idle.producer.event.FcfsEventProperties;
import com.ureca.idle.producer.event.Submission;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
@RequiredArgsConstructor
public class SubmissionSQSBufferQueueProduceClient implements SubmissionBufferQueueProduceClient {

    private final SqsTemplate sqsTemplate;
    private final FcfsEventProperties fcfsEventProperties;

    @Override
    public void pushSubmission(Submission submission) {
        sqsTemplate.send(fcfsEventProperties.getTitle(), submission);
    }
}
