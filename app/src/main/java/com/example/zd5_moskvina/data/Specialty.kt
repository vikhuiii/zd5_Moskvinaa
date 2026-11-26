package com.example.zd5_moskvina.data

data class Specialty(
    val id: Int,
    val name: String,
    val description: String,
    val code: String,
    val duration: String,
    val qualification: String,
    val phone: String
)

object SpecialtyRepository {
    val specialties = listOf(
        Specialty(
            id = 1,
            name = "Программная инженерия",
            description = "Разработка, тестирование и сопровождение программного обеспечения.",
            code = "09.03.04",
            duration = "4 года",
            qualification = "Бакалавр",
            phone = "+79001234567"
        ),
        Specialty(
            id = 2,
            name = "Информационная безопасность",
            description = "Защита информации, криптография и обеспечение безопасности сетей.",
            code = "10.03.01",
            duration = "4 года",
            qualification = "Бакалавр",
            phone = "+79001234568"
        ),
        Specialty(
            id = 3,
            name = "Прикладная информатика",
            description = "Внедрение и поддержка ИТ-решений в бизнесе и экономике.",
            code = "09.03.03",
            duration = "4 года",
            qualification = "Бакалавр",
            phone = "+79001234569"
        )
    )
}
