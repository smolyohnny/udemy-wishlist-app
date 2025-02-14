package com.example.wishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val description: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(
            title = "Apple Watch SE",
            description = "Chytré hodinky - pro muže i ženy, kompatibilní s iOS, 1,78\" OLED displej, " +
                    "NFC platby skrze Apple Pay aplikaci, Bluetooth, GPS, WiFi, volání z hodinek přes " +
                    "telefon spárovaný s Bluetooth, krokoměr, monitoring spánku, měření tepu, " +
                    " 50 m (5 ATM), maximální výdrž baterie 18 h, s ovládáním v češtině"
        ),
        Wish(
            title = "MacBook Air",
            description = "MacBook - Apple M3 (8jádrový), 13,6\" IPS lesklý 2496 × 1664 px, " +
                    "RAM 16GB, Apple M3 8jádrová GPU, SSD 256GB, podsvícená klávesnice, " +
                    "webkamera, čtečka otisků prstů, WiFi 6, hmotnost 1,24 kg, macOS"
        )
    )
}