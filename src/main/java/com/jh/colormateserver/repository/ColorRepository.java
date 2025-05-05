package com.jh.colormateserver.repository;

import com.jh.colormateserver.entity.ColorCombination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<ColorCombination, Long> {

}
