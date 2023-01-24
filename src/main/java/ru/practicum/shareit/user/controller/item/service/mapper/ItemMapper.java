package ru.practicum.shareit.user.controller.item.service.mapper;

import lombok.Getter;
import lombok.Setter;
import ru.practicum.shareit.user.controller.item.dto.ItemDto;
import ru.practicum.shareit.user.controller.item.model.Item;

@Getter
@Setter
public class ItemMapper {

    public static ItemDto toItemDto(Item item) {
        return new ItemDto(item.getId(),
                item.getName(),
                item.getDescription(),
                item.getAvailable()
        );
    }

    public static Item toItem(ItemDto itemDto, long userId) {
        return new Item(itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getAvailable(),
                userId);
    }
}
