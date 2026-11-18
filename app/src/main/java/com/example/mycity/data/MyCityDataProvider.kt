package com.example.mycity.data

import com.example.mycity.model.Category
import com.example.mycity.model.Place

object MyCityDataProvider {
    val allPlaces = listOf(
        Place(1, "Парк Чудес", "Центральный парк развлечений с аттракционами и колесом обозрения на набережной Томи.", android.R.drawable.ic_menu_camera, Category.PARK),
        Place(2, "Парк Ангелов", "Современный мемориальный парк с музыкальной башней, водопадом и зонами отдыха.", android.R.drawable.ic_menu_gallery, Category.PARK),
        Place(3, "Комсомольский парк имени Веры Волошиной", "Отличное место для прогулок, есть спортивные площадки и кинотеатр рядом.", android.R.drawable.ic_menu_compass, Category.PARK),

        Place(4, "Забой", "Культовый ресторан шахтерской тематики с сибирской кухней и аутентичным интерьером.", android.R.drawable.ic_menu_manage, Category.RESTAURANT),
        Place(5, "Port42", "Ресторан на набережной с панорамным видом на реку и авторской кухней.", android.R.drawable.ic_menu_mapmode, Category.RESTAURANT),
        Place(6, "Hofbrau Kemerovo", "Традиционный баварский ресторан-пивоварня с сытными мясными блюдами.", android.R.drawable.ic_menu_agenda, Category.RESTAURANT),

        Place(7, "Coffee Like", "Популярная сеть формата 'кофе с собой' с отличным выбором сезонных напитков.", android.R.drawable.ic_menu_recent_history, Category.COFFEE_SHOP),
        Place(8, "Подорожник", "Легендарная местная сеть быстрого питания и горячего кофе.", android.R.drawable.ic_menu_directions, Category.COFFEE_SHOP),
        Place(9, "Академия Кофе", "Уютная кофейня с альтернативными способами заваривания и свежей выпечкой.", android.R.drawable.ic_menu_info_details, Category.COFFEE_SHOP),

        Place(10, "Юбилейный", "Современный кинотеатр в ТРК 'Променад-3' с комфортными залами.", android.R.drawable.ic_media_play, Category.CINEMA),
        Place(11, "Космос", "Один из старейших кинотеатров города с обновленными залами и IMAX.", android.R.drawable.ic_media_play, Category.CINEMA),
        Place(12, "Rio Cinema", "Кинотеатр в ТРЦ 'РИО' с удобными креслами и отличным звуком.", android.R.drawable.ic_media_play, Category.CINEMA),

        Place(13, "Лапландия", "Один из крупнейших торгово-развлекательных центров города.", android.R.drawable.ic_menu_gallery, Category.MALL),
        Place(14, "Летосити", "Современный ТЦ с уникальным фуд-кортом и панорамными окнами.", android.R.drawable.ic_menu_gallery, Category.MALL),
        Place(15, "Гринвич", "Компактный торговый центр в молодежном районе ФПК.", android.R.drawable.ic_menu_gallery, Category.MALL)
    )
}