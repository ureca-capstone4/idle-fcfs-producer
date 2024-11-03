package com.ureca.idle.producer.caller.dto;


import com.ureca.idle.producer.event.Submission;

import java.time.LocalDateTime;

public record CallSubmissionProducerReq(String name, String phoneNum)  {

    public Submission toSubmission(LocalDateTime timeStamp, String userId) {
        return new Submission(timeStamp, userId, name, phoneNum);
    }
}

