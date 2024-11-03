package com.ureca.idle.producer.producer;


import com.ureca.idle.producer.client.SubmissionBufferQueueProduceClient;
import com.ureca.idle.producer.event.EventManager;
import com.ureca.idle.producer.event.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubmissionProducerImpl implements SubmissionProducer {

    private final SubmissionBufferQueueProduceClient submissionBufferQueueProduceClient;
    private final EventManager eventManager;

    @Override
    public void produceSubmission(Submission submission) {
        eventManager.checkEventEnd();
        eventManager.checkDuplicatedSubmission(submission);
        submissionBufferQueueProduceClient.pushSubmission(submission);
        eventManager.registerToDuplicatedSubmission(submission);
    }
}
