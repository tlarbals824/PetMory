package com.kusitms.samsion.application.comment.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateRequest {
    private String description;

    @Builder
    public CommentUpdateRequest(String description) {
        this.description = description;
    }
}
