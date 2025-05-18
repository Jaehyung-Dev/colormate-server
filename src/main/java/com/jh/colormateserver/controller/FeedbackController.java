package com.jh.colormateserver.controller;

import com.jh.colormateserver.dto.FeedbackDto;
import com.jh.colormateserver.entity.Feedback;
import com.jh.colormateserver.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @PostMapping
    public Feedback save(@RequestBody FeedbackDto feedbackDto) {
        return feedbackService.saveFeedback(feedbackDto);
    }

    @GetMapping("/feedbackList")
    public List<Feedback> findAll() {
        return feedbackService.getAllFeedback();
    }
}
