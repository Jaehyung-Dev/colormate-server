package com.jh.colormateserver.service;

import com.jh.colormateserver.ColorCombinationDto;
import com.jh.colormateserver.entity.ColorCombination;
import com.jh.colormateserver.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorService {
    private final ColorRepository repository;

    public List<ColorCombination> getAll() {
        return repository.findAll();
    }

    public ColorCombination saveNewCombination(ColorCombinationDto combinationDto) {
        ColorCombination combination = ColorCombination.builder()
                .type(combinationDto.getType())
                .season(combinationDto.getSeason())
                .topColor(combinationDto.getTopColor())
                .bottomColor(combinationDto.getBottomColor())
                .shoesColor(combinationDto.getShoesColor())
                .build();
        return repository.save(combination);
    }
}
