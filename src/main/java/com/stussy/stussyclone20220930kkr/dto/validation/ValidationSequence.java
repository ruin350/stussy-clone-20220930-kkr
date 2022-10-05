package com.stussy.stussyclone20220930kkr.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;
// 검사순서를 의미 ValidationSequence
@GroupSequence({validationGroups.NotBlankGroup.class, 
                validationGroups.SizeGroup.class, 
                validationGroups.PatternCheckGroup.class,
                Default.class})
public interface ValidationSequence {}
