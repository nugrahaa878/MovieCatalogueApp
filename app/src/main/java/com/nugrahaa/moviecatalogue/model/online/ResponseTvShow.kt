package com.nugrahaa.moviecatalogue.model.online

import com.google.gson.annotations.SerializedName

data class ResponseTvShow(

		@field:SerializedName("page")
		val page: Int? = null,

		@field:SerializedName("total_pages")
		val totalPages: Int? = null,

		@field:SerializedName("results")
		val results: List<TVShow?>? = null,

		@field:SerializedName("total_results")
		val totalResults: Int? = null
)