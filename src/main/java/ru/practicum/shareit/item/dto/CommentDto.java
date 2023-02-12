package ru.practicum.shareit.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.user.Create;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class CommentDto {
    private Long id;
    @NotNull(groups = Create.class)
    @NotBlank(groups = Create.class)
    private String text;
    private String authorName;
    private Boolean created;
}
