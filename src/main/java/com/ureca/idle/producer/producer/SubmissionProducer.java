package com.ureca.idle.producer.producer;

import com.ureca.idle.producer.event.Submission;

public interface SubmissionProducer {

    void produceSubmission(Submission submission);
}
