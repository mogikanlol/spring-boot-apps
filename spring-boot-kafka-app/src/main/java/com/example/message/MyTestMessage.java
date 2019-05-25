package com.example.message;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Accessors(chain = true)
public class MyTestMessage {

    @NotEmpty
    private String id;

    @NotEmpty
    private String content;
}
