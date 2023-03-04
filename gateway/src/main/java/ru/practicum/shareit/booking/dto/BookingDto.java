package ru.practicum.shareit.booking.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.shareit.common.Create;
import ru.practicum.shareit.common.Update;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingDto {
    @NotNull(groups = Update.class)
    private Long id;
    @FutureOrPresent(groups = Create.class)
    private LocalDateTime start;
    @Future(groups = Create.class)
    private LocalDateTime end;
    @NotNull(groups = Create.class)
    private Long itemId;
    private Long bookerId;
    private BookingStatus status;
}
