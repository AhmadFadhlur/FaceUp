package com.example.faceup.network.models.predict

import com.google.gson.annotations.SerializedName

data class PredictResponse(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("predicted_class")
	val predictedClass: Int? = null,

	@field:SerializedName("class_jerawat")
	val classJerawat: String? = null
)
