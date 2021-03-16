package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Task {
    /** タスクID */
    private Long id;

    /** タスク名 */
    @NotBlank
    @Size(max = 255)
    private String name;

    /** 終了状態 */
    private Boolean done = false;
}
