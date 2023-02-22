package ru.practicum.shareit.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import ru.practicum.shareit.booking.dto.BookingDtoResponse;
import ru.practicum.shareit.booking.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import javax.validation.constraints.PositiveOrZero;
import ru.practicum.shareit.booking.dto.BookingDto;
import javax.validation.constraints.Positive;
import ru.practicum.shareit.user.Create;
import lombok.RequiredArgsConstructor;
import java.util.List;

import static ru.practicum.shareit.ShareItApp.HEADER;
@Validated
@RestController
@RequestMapping(path = "/bookings")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public BookingDtoResponse create(@RequestHeader(HEADER) long id, @Validated(Create.class) @RequestBody BookingDto bookingDto) {
        return bookingService.create(id, bookingDto);
    }

    @PatchMapping("/{bookingId}")
    public BookingDtoResponse changeStatus(@RequestHeader(HEADER) long userId,
                                           @PathVariable long bookingId,
                                           @RequestParam boolean approved) {
        return bookingService.changeStatus(userId, bookingId, approved);
    }

    @GetMapping("/{bookingId}")
    public BookingDtoResponse getBookingInfo(@RequestHeader(HEADER) long userId,
                                             @PathVariable long bookingId) {
        return bookingService.getBookingInfo(userId, bookingId);
    }

    @GetMapping
    public List<BookingDtoResponse> getByBooker(@RequestHeader(HEADER) long userId,
                                                @RequestParam(defaultValue = "ALL", required = false) String state,
                                                @PositiveOrZero @RequestParam(defaultValue = "0", required = false) int from,
                                                @Positive @RequestParam(defaultValue = "20", required = false) int size) {
        return bookingService.getByBooker(userId, state, from, size);
    }

    @GetMapping("/owner")
    public List<BookingDtoResponse> getByOwner(@RequestHeader(HEADER) long userId,
                                               @RequestParam(defaultValue = "ALL", required = false) String state,
                                               @PositiveOrZero @RequestParam(defaultValue = "0", required = false) int from,
                                               @Positive @RequestParam(defaultValue = "20", required = false) int size) {
        return bookingService.getByOwner(userId, state, from, size);
    }
}
