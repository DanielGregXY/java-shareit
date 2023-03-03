package ru.practicum.shareit.request.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.common.Create;
import ru.practicum.shareit.request.client.ItemRequestClient;
import ru.practicum.shareit.request.dto.ItemRequestDto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import static ru.practicum.shareit.common.Variables.HEADER;

@RestController
@RequestMapping(path = "/requests")
@Validated
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItemRequestController {
    private final ItemRequestClient itemRequestClient;

    @PostMapping
    public ResponseEntity<Object> create(@RequestHeader(HEADER) long userId,
                                 @Validated(Create.class) @RequestBody ItemRequestDto itemRequestDto) {
        return itemRequestClient.create(userId, itemRequestDto);
    }

    @GetMapping
    public ResponseEntity<Object> getRequestsInfo(@RequestHeader(HEADER) long userId) {
        return itemRequestClient.getRequestsInfo(userId);
    }

    @GetMapping("/{requestId}")
    public ResponseEntity<Object> getRequestInfo(@RequestHeader(HEADER) long userId,
                                                 @PathVariable long requestId) {
        return itemRequestClient.getRequestInfo(userId, requestId);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getRequestsList(@RequestHeader(HEADER) long userId,
                                                  @PositiveOrZero @RequestParam(defaultValue = "0", required = false) int from,
                                                  @Positive @RequestParam(defaultValue = "10", required = false) int size) {
        return itemRequestClient.getRequestsList(userId, from, size);
    }
}