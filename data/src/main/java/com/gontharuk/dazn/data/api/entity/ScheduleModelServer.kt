package com.gontharuk.dazn.data.api.entity

import com.google.gson.annotations.SerializedName

data class ScheduleModelServer(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("date") val date: String,
    @SerializedName("imageUrl") val imageUrl: String,
)