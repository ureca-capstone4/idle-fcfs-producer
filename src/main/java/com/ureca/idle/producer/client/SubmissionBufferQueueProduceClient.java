package com.ureca.idle.producer.client;

import com.ureca.idle.producer.event.Submission;

public interface SubmissionBufferQueueProduceClient {

    void pushSubmission(Submission submission);
}
