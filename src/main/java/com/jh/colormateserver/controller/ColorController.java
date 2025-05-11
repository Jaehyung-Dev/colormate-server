package com.jh.colormateserver.controller;

import com.jh.colormateserver.dto.ColorCombinationDto;
import com.jh.colormateserver.entity.ColorCombination;
import com.jh.colormateserver.service.ColorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
@RequiredArgsConstructor
@Slf4j
public class ColorController {
    private final ColorService colorService;

    @GetMapping("/combinations")
    public List<ColorCombination> getAllColorCombinations() {
        return colorService.getAll();
    }

    @PostMapping("/combination")
    public ColorCombination saveCombination(@RequestBody ColorCombinationDto combinationDto) {
        return colorService.saveNewCombination(combinationDto);
    }
}
