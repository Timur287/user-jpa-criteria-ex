package com.example.userjpacriteriaex.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SearchCriteria {
    String key;
    String operation;
    Object value;

//
//    public boolean isOrPredicate() {
//
//    }

//    public void setOrPredicate(boolean orPredicate) {
//        this.orPredicate = orPredicate;
//    }
}
