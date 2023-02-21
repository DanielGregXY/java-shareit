package ru.practicum.shareit.request.controller;

import ru.practicum.shareit.request.dto.ItemRequestDtoResponse;
import ru.practicum.shareit.request.service.ItemRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import ru.practicum.shareit.request.dto.ItemRequestDto;
import static ru.practicum.shareit.ShareItApp.HEADER;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Positive;
import ru.practicum.shareit.user.Create;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Validated
@RestController
@RequestMapping(path = "/requests")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class ItemRequestController {
    private final ItemRequestService requestService;

    @PostMapping
    public ItemRequestDto create(@RequestHeader(HEADER) long userId,
                                 @Validated(Create.class) @RequestBody ItemRequestDto itemRequestDto) {
        return requestService.create(userId, itemRequestDto);
    }

    @GetMapping
    public List<ItemRequestDtoResponse> getRequestsInfo(@RequestHeader(HEADER) long userId) {
        return requestService.getRequestsInfo(userId);
    }

    @GetMapping("/{requestId}")
    public ItemRequestDtoResponse getRequestInfo(@RequestHeader(HEADER) long userId,
                                                 @PathVariable long requestId) {
        return requestService.getRequestInfo(userId, requestId);
    }

    @GetMapping("/all")
    public List<ItemRequestDtoResponse> getRequestsList(@RequestHeader(HEADER) long userId,
                                                        @PositiveOrZero @RequestParam(defaultValue = "0", required = false) int from,
                                                        @Positive @RequestParam(defaultValue = "10", required = false) int size) {
        return requestService.getRequestsList(userId, from, size);
    }
}
