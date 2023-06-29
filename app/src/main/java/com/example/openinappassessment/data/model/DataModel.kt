package com.example.openinappassessment.data.model

data class DataModel(
    val applied_campaign: Int = 0,
    val data: Data = Data(),
    val extra_income: Double = 0.0,
    val links_created_today: Int = 0,
    val message: String = "N/A",
    val startTime: String = "N/A",
    val status: Boolean = true,
    val statusCode: Int = 0 ,
    val support_whatsapp_number: String = "N/A",
    val today_clicks: Int = 0,
    val top_location: String = "N/A",
    val top_source: String = "N/A",
    val total_clicks: Int = 0,
    val total_links: Int = 0
)