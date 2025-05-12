package com.jh.colormateserver.service;

import com.jh.colormateserver.dto.FeedbackDto;
import com.jh.colormateserver.entity.Feedback;
import com.jh.colormateserver.entity.FeedbackType;
import com.jh.colormateserver.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public Feedback saveFeedback(FeedbackDto feedbackDto) {
        try {
            FeedbackType type = FeedbackType.valueOf(feedbackDto.getType());

            Feedback feedback = Feedback.builder()
                    .nickname(feedbackDto.getNickname())
                    .type(type)
                    .content(feedbackDto.getContent())
                    .build();

            return feedbackRepository.save(feedback);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("유효하지 않은 피드백 유형입니다: " + feedbackDto.getType());
        }
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}
