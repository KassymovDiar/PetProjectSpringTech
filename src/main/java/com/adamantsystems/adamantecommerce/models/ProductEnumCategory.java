package com.adamantsystems.adamantecommerce.models;

public enum ProductEnumCategory {
    MOBILE("Смартфоны"),
    COMPUTER("Компьютеры"),
    GADGET("Гаджеты"),
    GAMING_CONSOLES("Игровые приставки"),
    LARGE_EQUIPMENT("Крупная техника для дома"),
    SMALL_EQUIPMENT("Малая техника для дома"),
    TV_AND_AUDIO("ТВ,Аудио,Видео"),
    BEAUTY_AND_HEALTH("Красота и здоровье");




    private String translate;

    ProductEnumCategory(String translate) {
        this.translate = translate;
    }

    public String getTranslate() {
        return translate;
    }

    }

