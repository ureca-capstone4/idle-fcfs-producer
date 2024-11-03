package com.ureca.idle.producer.caller;


import com.ureca.idle.producer.caller.dto.CallProducerResp;
import com.ureca.idle.producer.caller.dto.CallSubmissionProducerReq;
import com.ureca.idle.producer.caller.web.auth.IdAndAuthority;
import com.ureca.idle.producer.caller.web.auth.LoginUser;
import com.ureca.idle.producer.event.Submission;
import com.ureca.idle.producer.producer.SubmissionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api/v1/submissions")
@RequiredArgsConstructor
public class SubmissionProducerWebRequestCaller implements SubmissionProducerCaller {

    private final SubmissionProducer submissionProducer;

    @PostMapping("")
    public CallProducerResp callSubmissionProducer(
            @LoginUser IdAndAuthority idAndAuthority,
            @RequestBody CallSubmissionProducerReq req
    ) {
        LocalDateTime currentTimeStamp = LocalDateTime.now();
        Submission submission = req.toSubmission(currentTimeStamp, idAndAuthority.id().toString());
        submissionProducer.produceSubmission(submission);
        return new CallProducerResp("응모에 성공하였습니다.");
    }

    @PostMapping("/{userId}")
    public CallProducerResp testCallSubmissionProducer(@PathVariable String userId) {
        LocalDateTime currentTimeStamp = LocalDateTime.now();
        Submission submission = new Submission(currentTimeStamp, userId, userId, "000000");
        submissionProducer.produceSubmission(submission);
        return new CallProducerResp("응모에 성공하였습니다.");
    }
}
