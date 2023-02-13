package ru.practicum.shareit.booking.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.practicum.shareit.booking.enums.BookingStatus;
import ru.practicum.shareit.user.Create;
import ru.practicum.shareit.user.Update;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookingDto {

    @NotNull(groups = Update.class)
    Long id;

    @FutureOrPresent(groups = Create.class)
    LocalDateTime start;

    @Future(groups = Create.class)
    LocalDateTime end;

    @NotNull(groups = Create.class)
    Long itemId;

    Long bookerId;

    BookingStatus status;
}
