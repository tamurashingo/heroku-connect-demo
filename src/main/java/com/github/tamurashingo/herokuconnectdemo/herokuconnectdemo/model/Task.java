package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Long id;
    private String name;
    private Boolean done = false;
}
