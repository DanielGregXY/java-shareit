package ru.practicum.shareit.user.dto;

import lombok.*;
import ru.practicum.shareit.common.Create;
import ru.practicum.shareit.common.Update;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserDto {
    private Long id;
    @NotBlank(groups = Create.class)
    private String name;
    @NotNull(groups = Create.class)
    @Email(groups = {Create.class, Update.class})
    private String email;
}