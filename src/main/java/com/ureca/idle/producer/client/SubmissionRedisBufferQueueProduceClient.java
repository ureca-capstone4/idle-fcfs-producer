package com.ureca.idle.producer.client;


import com.ureca.idle.producer.event.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Deprecated
@Component
@RequiredArgsConstructor
public class SubmissionRedisBufferQueueProduceClient implements SubmissionBufferQueueProduceClient {

    @Override
    public void pushSubmission(Submission submission) {
    }
}
