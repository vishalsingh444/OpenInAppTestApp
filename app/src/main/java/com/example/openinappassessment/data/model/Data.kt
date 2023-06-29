package com.example.openinappassessment.data.model

data class Data(
    val overall_url_chart: OverallUrlChart = OverallUrlChart(),
    val recent_links: List<RecentLink> = listOf(RecentLink()),
    val top_links: List<TopLink> = listOf(TopLink())
)