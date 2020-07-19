package com.aabhishek.indeetvassignment.business.domain.entity

data class ItemDetails(
    val id: Int,
    val name: String = "",
    val release_year: Int,
    val video_duration: String = "",
    val type: String = "",
    val created_on: String = "",
    val updated_on: String = "",
    val shortDescription: String = "",
    val description: String = "",
    val posterLink: String = ""
) {
}